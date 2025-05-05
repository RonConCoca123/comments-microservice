package com.commets.micro.service.commets_micro_service.Infraestructura.adaptadores;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.out.LikeRepository;
import com.commets.micro.service.commets_micro_service.Dominio.entidades.Like;

@Repository   
@Transactional
public class JpaLikeRepository implements LikeRepository {

    private final SpringDataLikeRepository springRepo;
    public JpaLikeRepository(SpringDataLikeRepository repo){ this.springRepo = repo; }

    @Override
    public Optional<Like> find(Long commentId, Long usuarioId){
        return springRepo.findByCommentIdAndUsuarioId(commentId, usuarioId)
                         .map(LikeEntity::toDomain);
    }

    @Override
    public void save(Like like){
        springRepo.save(LikeEntity.from(like));
    }

    @Override
    public void delete(Long commentId, Long usuarioId){
        springRepo.deleteByCommentIdAndUsuarioId(commentId, usuarioId);
    }
}