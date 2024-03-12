package br.fullstack.exercicioM1S08.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class ModelCurso {
    private String nome;

    @Setter(AccessLevel.NONE)
    private Integer id;
    private static Integer nextId = 1;

    private String descricao;
    private  Integer cargaHoraria;


    private Integer getNextId() {
        return nextId++;
    }

}
