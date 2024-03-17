package br.fullstack.exercicioM1S08.controller;

import br.fullstack.exercicioM1S08.model.ModelCurso;
import br.fullstack.exercicioM1S08.services.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }


    @GetMapping
    public List<ModelCurso> get(){
        return cursoService.buscarCursos();
    }

    @PostMapping
    public ModelCurso post(@RequestBody ModelCurso curso) throws Exception {
        return cursoService.cadastrarCurso(curso);
    }
}
