package br.fullstack.exercicioM1S08.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class ModelAluno {
    private String nome;

    @Setter(AccessLevel.NONE)
    private Integer id;

    private static Integer nextId = 1;

    //mais prático para JSON
    private LocalDate dataNascimento;


    private Integer getNextId() {
        return nextId++;
    }
}
