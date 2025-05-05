package com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in;

public interface RegistrarComentarioUseCase {
    Long ejecutarR(Long idUsuario, Long idDocente,
                  String comentario, int calificacion);
}

