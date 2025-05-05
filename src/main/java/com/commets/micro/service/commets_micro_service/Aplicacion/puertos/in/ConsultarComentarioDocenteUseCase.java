package com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in;

import java.util.List;

import com.commets.micro.service.commets_micro_service.Dominio.entidades.Comment;

public interface ConsultarComentarioDocenteUseCase {
    List<Comment> ejecutarComDoc(Long idDocente, Long idUsuario,
                                     boolean moderador, int cantidad,
                                     boolean ordenadoFecha);
}
