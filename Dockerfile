# 1) Build stage
FROM maven:3.9.0-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
# copia solo dependencias para cachear
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests -B

# 2) Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copiamos el jar empaquetado
COPY --from=builder /app/target/*.jar app.jar

# Configuraciones recomendadas
ENV JAVA_OPTS="-Xms512m -Xmx1024m"
EXPOSE 8081
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
