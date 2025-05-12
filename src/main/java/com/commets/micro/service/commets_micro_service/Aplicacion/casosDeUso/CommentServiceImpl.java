package com.commets.micro.service.commets_micro_service.Aplicacion.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Service;

import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.*;
import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.out.CommentRepository;
import com.commets.micro.service.commets_micro_service.Dominio.entidades.Comment;

@Service
public class CommentServiceImpl implements RegistrarComentarioUseCase, EliminarComentarioUseCase, ConsultarComentarioEstudianteUseCase,
ConsultarComentarioDocenteUseCase, ConsultarTodosComentariosUseCase, PromedioCalificacionUseCase{

    private final CommentRepository repo;
    public CommentServiceImpl(CommentRepository repo){this.repo=repo;}

    @Override
    public Long ejecutarR(Long idUsuario, Long idDocente, String comentario, int calificacion) {
        if(calificacion<1||calificacion>10) throw new IllegalArgumentException("El la calificación debe ser entre 1-5");
        return repo.save(new Comment(idUsuario,idDocente,comentario,calificacion)).getId(); 
    }

    @Override
    public void ejecutarDelete(Long idComentario) {
        repo.delete(idComentario);
    }

    @Override
    public List<Comment> ejecutarComEstu(Long idUsuario) {
        return repo.byUsuario(idUsuario);
    }

    @Override
    public List<Comment> ejecutarComDoc(Long idDocente, Long idUsuario, boolean moderador, int cantidad,
            boolean ordenadoFecha) {
                var list = repo.byDocente(idDocente,ordenadoFecha);
                if(cantidad!=-1) list = list.subList(0, Math.min(cantidad,list.size()));
                if(!moderador) list.forEach(c->{}); // nada extra; propietario se calcula en controller
                return list;     
    }

    @Override
    public List<Comment> ejecutarAll(boolean ordenadoFecha, int cantidad) {
        var list = repo.all(ordenadoFecha);
        if(cantidad!=-1) list = list.subList(0, Math.min(cantidad,list.size()));
        return list;
    }

    @Override
    public double ejecutarPromedio(Long idDocente) {
        return repo.promedio(idDocente);
    }






    

    
}
