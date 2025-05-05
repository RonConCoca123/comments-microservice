package com.commets.micro.service.commets_micro_service.Dominio.entidades;

import java.time.Instant;

public class Like {
    private Long commentId;
    private Long userId;
    private Instant fecha = Instant.now();

    protected Like() {
        // Constructor protegido para JPA
    }
    public Like(Long commentId, Long userId) {
        this.commentId = commentId;
        this.userId = userId;
    }
    public Long getCommentId() {
        return commentId;
    }
    public Long getUserId() {
        return userId;
    }
    public Instant getFecha() {
        return fecha;
    }
}
