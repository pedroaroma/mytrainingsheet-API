package com.br.home.mytrainingsheet.dto.exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseInfoDTO {

    private String name;

    private Integer series;

    private Integer repetitions;

    private Float weight;

    private Integer rest;

    private String comment;

    private Integer position;

}
