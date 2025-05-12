package com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CommentDto {

    @JsonProperty("id_usuario")
    @NotNull
    private Long idUsuario;

    @JsonProperty("id_docente")
    @NotNull
    private Long idDocente;

    @JsonProperty("comentario")
    @NotBlank
    private String comentario;

    @JsonProperty("calificacion")
    @Min(1) @Max(10)
    private int calificacion;

    public CommentDto() {}

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdDocente() { return idDocente; }
    public void setIdDocente(Long idDocente) { this.idDocente = idDocente; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }
}
