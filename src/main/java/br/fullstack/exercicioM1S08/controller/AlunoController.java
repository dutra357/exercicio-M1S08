package br.fullstack.exercicioM1S08.controller;

import br.fullstack.exercicioM1S08.model.ModelAluno;
import br.fullstack.exercicioM1S08.services.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @GetMapping
    public List<ModelAluno> get(){
        return alunoService.buscarAlunos();
    }

    @PostMapping
    public ModelAluno post(@RequestBody ModelAluno aluno) throws Exception {
        return alunoService.cadastrarAluno(aluno);
    }
}
