package com.commets.micro.service.commets_micro_service.Infraestructura.adaptadores;

import java.time.Instant;

import com.commets.micro.service.commets_micro_service.Dominio.entidades.Comment;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CommentEntity {

    /* ①  ID autoincremental -> Long  */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* ②  Nuevos nombres de columnas  */
    @Column(name = "usuario_id",  nullable = false)  private Long usuarioId;
    @Column(name = "docente_id",  nullable = false)  private Long docenteId;

    @Column(nullable = false) private String cuerpo;
    @Column(name="calificacion", nullable = false) private int calificacion;
    @Column(name = "created_at",  nullable = false) private Instant createdAt;

    @Column(name = "likes_count", nullable = false) private int likeCount;

    /* ---------- mapeos ---------- */
    public static CommentEntity from(Comment c){
        return CommentEntity.builder()
                .id(c.getId())
                .usuarioId(c.getUsuarioId())
                .docenteId(c.getDocenteId())
                .cuerpo(c.getCuerpo())
                .calificacion(c.getCalificacion())
                .createdAt(
                c.getFechaCreacion() != null ? c.getFechaCreacion()
                                             : java.time.Instant.now())
                .likeCount(c.getLikeCount())
                .build();
    }

    public Comment toDomain(){
        Comment d = new Comment(this.id,
        this.usuarioId,
        this.docenteId,
        this.cuerpo,
        this.calificacion,
        this.createdAt,    // toma la fecha de la BD
        this.likeCount);
        /* reflejar ID y likes */
        // usa reflexión o un setter protegido si lo añades
        try {
            var idField = Comment.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(d, id);
            var likesF = Comment.class.getDeclaredField("likeCount");
            likesF.setAccessible(true);
            likesF.setInt(d, likeCount);
        } catch (Exception ignored) {}
        return d;
    }
}