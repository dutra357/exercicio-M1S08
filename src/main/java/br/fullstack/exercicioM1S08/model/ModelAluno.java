package br.fullstack.exercicioM1S08.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class ModelAluno {

    @Getter
    private static List<ModelAluno> alunos = new ArrayList<>();

    private String nome;

    @Setter(AccessLevel.NONE)
    private Integer id;

    private static Integer nextId = 1;

    //mais prático para JSON
    private LocalDate dataNascimento;


    private static Integer getNextId() {
        return nextId++;
    }

    public static ModelAluno cadastrar(ModelAluno aluno) {
        aluno.id = getNextId();
        alunos.add(aluno);
        return aluno;
    }
}
