package com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CommentDto {
    @NotNull
    private Long id_usuario;

    @NotNull
    private Long id_docente;

    @NotBlank
    private String comentario;

    @Min(1) @Max(10)
    private int calificacion;

    public CommentDto() {}

    public Long getIdUsuario() { return id_usuario; }
    public void setIdUsuario(Long id_usuario) { this.id_usuario = id_usuario; }

    public Long getIdDocente() { return id_docente; }
    public void setIdDocente(Long id_docente) { this.id_docente = id_docente; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }
}
