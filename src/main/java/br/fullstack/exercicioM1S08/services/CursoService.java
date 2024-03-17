package br.fullstack.exercicioM1S08.services;

import br.fullstack.exercicioM1S08.model.ModelAluno;
import br.fullstack.exercicioM1S08.model.ModelCurso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    public List<ModelCurso> buscarCursos() {
        return ModelCurso.getCursos();
    }

    public ModelCurso cadastrarCurso(ModelCurso curso) throws Exception {
        if (validar(curso)) {
            return ModelCurso.cadastrar(curso);
        }
        return null;
    }



    private boolean validar (ModelCurso curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new Exception("Nome é impresacindível!");
        }

        if (curso.getCargaHoraria() == null) {throw new Exception("Carga horária obrigatória!");}
        return true;
    }
}
