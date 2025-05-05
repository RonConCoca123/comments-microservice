package com.commets.micro.service.commets_micro_service.Infraestructura.adaptadores;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.ConsultarComentarioDocenteUseCase;
import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.ConsultarComentarioEstudianteUseCase;
import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.ConsultarTodosComentariosUseCase;
import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.EliminarComentarioUseCase;
import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.PromedioCalificacionUseCase;
import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.RegistrarComentarioUseCase;
import com.commets.micro.service.commets_micro_service.Aplicacion.puertos.in.ToogleLikeUseCase;
    


@RestController
@RequestMapping("/comments")
public class CommentController {

    private final RegistrarComentarioUseCase regUC;
    private final EliminarComentarioUseCase  delUC;
    private final ConsultarComentarioEstudianteUseCase estUC;
    private final ConsultarComentarioDocenteUseCase   docUC;
    private final ConsultarTodosComentariosUseCase     allUC;
    private final PromedioCalificacionUseCase      avgUC;
    private final ToogleLikeUseCase                likeUC;

    public CommentController(RegistrarComentarioUseCase r,
                             EliminarComentarioUseCase d,
                             ConsultarComentarioEstudianteUseCase e,
                             ConsultarComentarioDocenteUseCase doc,
                             ConsultarTodosComentariosUseCase a,
                             PromedioCalificacionUseCase p,
                             ToogleLikeUseCase l){
        this.regUC=r; this.delUC=d; this.estUC=e; this.docUC=doc; this.allUC=a; this.avgUC=p; this.likeUC=l;
    }

    @GetMapping("/comentarios_estudiante")
    public Map<String,Object> comentariosEstudiante(
            @RequestParam("id_usuario") Long idUsuario) {

        var lista = estUC.ejecutarComEstu(idUsuario);
        return Map.of("comentarios", lista);
    }

    /** 2. Obtener comentarios del docente */
    @GetMapping("/comentarios_docente")
    public Map<String,Object> comentariosDocente(
            @RequestParam("id_docente") Long idDocente,
            @RequestParam("id_usuario") Long idUsuario,
            @RequestParam(value="moderador", defaultValue="false") boolean moderador,
            @RequestParam(value="cantidad",  defaultValue="3")    int cantidad,
            @RequestParam(value="ordenado_fecha", defaultValue="true") boolean ordenado) {

        var lista = docUC.ejecutarComDoc(idDocente, idUsuario, moderador, cantidad, ordenado);
        return Map.of("comentarios", lista);
    }

    /** 3. Promedio de calificación de un docente */
    @GetMapping("/promedio_calificacion")
    public Map<String,Object> promedio(
            @RequestParam("id_docente") Long idDocente) {

        double avg = avgUC.ejecutarPromedio(idDocente);
        return Map.of("promedio", avg);
    }

    /** 4. Obtener todos los comentarios */
    @GetMapping("/total_comentarios")
    public Map<String,Object> total(
            @RequestParam(value="ordenado_fecha", defaultValue="true") boolean ordenado,
            @RequestParam(value="cantidad", defaultValue="2") int cantidad) {

        var lista = allUC.ejecutarAll(ordenado, cantidad);
        return Map.of("comentarios", lista);
    }

    /* ----------   MÉTODOS POST (sin cambios) ---------- */

    @PostMapping("/registrar_comentario")
    public Map<String,Object> registrar(@RequestParam Long id_usuario,
                                        @RequestParam Long id_docente,
                                        @RequestParam String comentario,
                                        @RequestParam int calificacion) {
        Long id = regUC.ejecutarR(id_usuario,id_docente,comentario,calificacion);
        return Map.of("response","success","id_comentario",id);
    }

    @PostMapping("/eliminar_comentario")
    public Map<String,String> eliminar(@RequestParam Long id_comentario){
        delUC.ejecutarDelete(id_comentario);
        return Map.of("response","success");
    }

    @PostMapping("/like_comentario")
    public Map<String,String> like(@RequestParam Long id_usuario,
                                   @RequestParam Long id_comentario){
        likeUC.ejecutarToogle(id_usuario,id_comentario);
        return Map.of("response","success");
    }
    
}
