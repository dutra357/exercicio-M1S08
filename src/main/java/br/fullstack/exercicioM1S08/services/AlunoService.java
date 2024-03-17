package br.fullstack.exercicioM1S08.services;

import br.fullstack.exercicioM1S08.model.ModelAluno;
import br.fullstack.exercicioM1S08.model.ModelCurso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    public List<ModelAluno> buscarAlunos() {
        return ModelAluno.getAlunos();
    }

    public ModelAluno cadastrarAluno(ModelAluno aluno) throws Exception {
        if (validar(aluno)) {
            return ModelAluno.cadastrar(aluno);
        }
        return null;
    }

    public ModelAluno burcarPorId(Integer id) throws Exception {
        return ModelAluno.buscarPorId(id);
    }

    private boolean validar (ModelAluno aluno) throws Exception {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new Exception("Nome é impresacindível!");
        }

        if (aluno.getDataNascimento() == null) {
            throw new Exception("Data de nascimento requerida!");
        }

        return true;
    }


}
