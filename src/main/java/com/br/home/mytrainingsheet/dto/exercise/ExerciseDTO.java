package com.br.home.mytrainingsheet.dto.exercise;


import com.br.home.mytrainingsheet.entity.Sheet;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDTO {

    private Long id;

    private Sheet sheet;

    private String name;

    private Integer series;

    private Integer repetitions;

    private Float weight;

    private Integer rest;

    private String comment;

    private Integer position;

}
