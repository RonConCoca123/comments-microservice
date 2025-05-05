package com.commets.micro.service.commets_micro_service.Infraestructura.adaptadores;
import com.commets.micro.service.commets_micro_service.Dominio.entidades.Like;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment_like")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(LikeId.class)            // PK compuesta
public class LikeEntity {

    @Id @Column(name="comment_id") private Long commentId;
    @Id @Column(name="usuario_id") private Long usuarioId;

    @Column(name="fecha", nullable=false)
    private java.time.Instant fecha;

    public static LikeEntity from(Like l){
        return LikeEntity.builder()
                .commentId(l.getCommentId())
                .usuarioId(l.getUserId())
                .fecha(l.getFecha())
                .build();
    }
    public Like toDomain(){ return new Like(commentId, usuarioId); }
}

/* PK compuesta */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
class LikeId implements java.io.Serializable {
    private Long commentId;
    private Long usuarioId;
}
