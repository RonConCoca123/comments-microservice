package com.commets.micro.service.commets_micro_service.Aplicacion.puertos.out;

import java.util.Optional;

import com.commets.micro.service.commets_micro_service.Dominio.entidades.Like;

public interface LikeRepository {
    
    Optional<Like> find(Long commentId, Long usuarioId);
    void save(Like like);
    void delete(Long commentId, Long userId);
}
