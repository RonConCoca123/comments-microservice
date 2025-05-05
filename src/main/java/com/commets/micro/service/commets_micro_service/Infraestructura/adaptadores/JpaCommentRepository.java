package com.commets.micro.service.commets_micro_service.Infraestructura.adaptadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.out.CommentRepository;
import com.commets.micro.service.commets_micro_service.Dominio.entidades.Comment;

@Repository @Transactional
public class JpaCommentRepository implements CommentRepository {

    private final SpringDataCommentRepository springRepo;
    public JpaCommentRepository(SpringDataCommentRepository repo){springRepo=repo;}

    @Override public Comment save(Comment c){
        return springRepo.save(CommentEntity.from(c)).toDomain();
    }
    @Override public Optional<Comment> byId(Long id){
        return springRepo.findById(id).map(CommentEntity::toDomain);
    }
    @Override public List<Comment> byUsuario(Long u){
        // crea método findByUsuarioId si lo necesitas
        return springRepo.findAll().stream()
               .filter(e -> e.getUsuarioId().equals(u))
               .map(CommentEntity::toDomain).toList();
    }
    @Override
    public List<Comment> byDocente(Long docenteId, boolean orden) {
        List<Comment> lista = springRepo.findByDocenteId(docenteId)
            .stream()
            .map(CommentEntity::toDomain)
            .toList();

        if (orden) {
            List<Comment> mutable = new ArrayList<>(lista);
            mutable.sort((a,b) ->
                b.getFechaCreacion().compareTo(a.getFechaCreacion())
            );
            return mutable;
        }
        return lista;
    }   
    @Override
    public List<Comment> all(boolean orden) {
        // 1) Obtenemos la lista de domain objects
        List<Comment> lista = springRepo.findAll().stream()
            .map(CommentEntity::toDomain)
            .toList();          // inmutable

        if (orden) {
            // 2) Creamos una copia mutable
            List<Comment> mutable = new ArrayList<>(lista);
            // 3) Ordenamos por fecha descendente
            mutable.sort((a,b) ->
                b.getFechaCreacion().compareTo(a.getFechaCreacion())
            );
            return mutable;
        }
        return lista;
    }
    @Override public void delete(Long id){ springRepo.deleteById(id); }
    @Override public void updateLikeCount(Long id,int d){ springRepo.updateLikeCount(id,d); }
    @Override public double promedio(Long docenteId){
        return springRepo.findByDocenteId(docenteId).stream()
               .mapToInt(CommentEntity::getCalificacion).average().orElse(0);
    }
}