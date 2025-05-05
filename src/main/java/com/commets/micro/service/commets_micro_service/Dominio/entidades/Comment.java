package com.commets.micro.service.commets_micro_service.Dominio.entidades;

import java.time.Instant;


public class Comment {
    private Long id;
    private Long usuarioId;
    private Long docenteId;
    private String cuerpo;
    private Instant fechaCreacion;
    private int calificacion;
    private int likeCount = 0;

    protected Comment() { }
    public Comment(Long usuarioId, Long docenteId,
                   String cuerpo, int calificacion) {
        this.usuarioId  = usuarioId;
        this.docenteId  = docenteId;
        this.cuerpo     = cuerpo;
        this.calificacion = calificacion;
        this.fechaCreacion = Instant.now();
    }

    public Comment(Long id, Long usuarioId, Long docenteId,
                   String cuerpo, int calificacion){
                    this.id = id;
                    this.usuarioId = usuarioId;
                    this.docenteId = docenteId;
                    this.cuerpo = cuerpo;
                    this.calificacion = calificacion;
                    this.fechaCreacion = Instant.now();
                   }
    
                   public Comment(Long id,
                   Long usuarioId,
                   Long docenteId,
                   String cuerpo,
                   int calificacion,
                   Instant fechaCreacion,
                   int likeCount) {
      this.id             = id;
      this.usuarioId      = usuarioId;
      this.docenteId      = docenteId;
      this.cuerpo         = cuerpo;
      this.calificacion   = calificacion;
      this.fechaCreacion  = fechaCreacion;
      this.likeCount      = likeCount;
    }
    
    public Long getId() {
        return id;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }
    public Long getDocenteId() {
        return docenteId;
    }
    public String getCuerpo() {
        return cuerpo;
    }
    public Instant getFechaCreacion() {
        return fechaCreacion;
    }
    public int getCalificacion() {
        return calificacion;
    }
    public int getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void increasedLikes(){
        this.likeCount++;
    }

    public void decreasedLikes(){
        this.likeCount--; 
    }
}
