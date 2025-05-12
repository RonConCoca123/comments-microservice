package com.commets.micro.service.commets_micro_service.Infraestructura.adaptadores.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GlobalCorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")               // aplica a todos los endpoints
                .allowedOrigins("*")             // o tu frontend: e.g. "https://misitio.com"
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)          // si quieres enviar cookies / auth
                .maxAge(3600);
    }
}
