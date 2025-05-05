package com.commets.micro.service.commets_micro_service.Infraestructura.adaptadores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataLikeRepository
        extends JpaRepository<LikeEntity, LikeId> {

    Optional<LikeEntity> findByCommentIdAndUsuarioId(Long commentId, Long usuarioId);
    void deleteByCommentIdAndUsuarioId(Long commentId, Long usuarioId);
}