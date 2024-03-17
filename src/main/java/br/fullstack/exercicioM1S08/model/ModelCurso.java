package br.fullstack.exercicioM1S08.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ModelCurso {
    private String nome;

    @Getter
    private static List<ModelCurso> cursos = new ArrayList<>();

    @Setter(AccessLevel.NONE)
    private Integer id;
    private static Integer nextId = 1;

    private String descricao;

    private  Integer cargaHoraria;

    private List<ModelAluno> alunosMatriculados = new ArrayList<>();


    private Integer getNextId() {
        return nextId++;
    }

    public static ModelCurso cadastrar(ModelCurso curso){
        curso.id = curso.getNextId();
        cursos.add(curso);
        return curso;
    }

    public static ModelCurso buscarPorId(Integer id) throws Exception {
        for (ModelCurso curso : cursos) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado.");
    }

    public static void matricular(ModelCurso curso, ModelAluno aluno) {
        curso.getAlunosMatriculados().add(aluno);
    }

}
