package com.commets.micro.service.commets_micro_service.Aplicacion.puertos.out;

import java.util.List;
import java.util.Optional;

import com.commets.micro.service.commets_micro_service.Dominio.entidades.Comment;

public interface CommentRepository {
    
    Comment save(Comment c);
    Optional<Comment> byId(Long id);
    List<Comment> byUsuario(Long u);
    List<Comment> byDocente(Long d, boolean orden);
    List<Comment> all(boolean orden);
    void delete(Long id);
    void updateLikeCount(Long id,int delta);
    double promedio(Long docenteId);
}
