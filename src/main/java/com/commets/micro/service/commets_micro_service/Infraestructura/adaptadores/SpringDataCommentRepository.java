package com.commets.micro.service.commets_micro_service.Infraestructura.adaptadores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SpringDataCommentRepository
       extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findByDocenteId(Long docenteId);

    @Modifying
    @Query("UPDATE CommentEntity c SET c.likeCount = c.likeCount + :delta " +
           "WHERE c.id = :commentId")
    void updateLikeCount(Long commentId, int delta);
}
