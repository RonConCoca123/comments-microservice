package com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in;

import java.util.List;

import com.commets.micro.service.commets_micro_service.Dominio.entidades.Comment;

public interface ConsultarComentarioEstudianteUseCase {
    List<Comment> ejecutarComEstu(Long idUsuario);
}
