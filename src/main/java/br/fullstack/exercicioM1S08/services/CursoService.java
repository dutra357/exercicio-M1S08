package br.fullstack.exercicioM1S08.services;

import br.fullstack.exercicioM1S08.model.ModelAluno;
import br.fullstack.exercicioM1S08.model.ModelCurso;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

import static br.fullstack.exercicioM1S08.model.ModelCurso.buscarPorId;

@Service
public class CursoService {

    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public List<ModelCurso> buscarCursos() {
        return ModelCurso.getCursos();
    }

    public ModelCurso cadastrarCurso(ModelCurso curso) throws Exception {
        if (validar(curso)) {
            return ModelCurso.cadastrar(curso);
        }
        return null;
    }

    public ModelCurso burcarPorId(Integer id) throws Exception {
        return buscarPorId(id);
    }

    private boolean validar (ModelCurso curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new Exception("Nome é impresacindível!");
        }

        if (curso.getCargaHoraria() == null) {throw new Exception("Carga horária obrigatória!");}
        return true;
    }

    public ModelCurso matricularAluno (Integer id, Integer alunoId) throws Exception {
        ModelCurso curso = buscarPorId(id);
        ModelAluno aluno = alunoService.burcarPorId(alunoId);
        ModelCurso.matricular(curso, aluno);

        return curso;
    }
}
