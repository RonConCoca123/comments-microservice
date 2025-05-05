package com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in;

public interface ToogleLikeUseCase {
    boolean ejecutarToogle(Long idUsuario, Long idComentario);
}
