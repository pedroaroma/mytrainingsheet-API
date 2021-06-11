package com.br.home.mytrainingsheet.mapper;

import com.br.home.mytrainingsheet.dto.exercise.ExerciseDTO;
import com.br.home.mytrainingsheet.entity.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExerciseMapper {

    ExerciseMapper INSTANCE = Mappers.getMapper(ExerciseMapper.class);

    Exercise toModel(ExerciseDTO exerciseDTO);
    ExerciseDTO toDTO(Exercise exercise);

}
