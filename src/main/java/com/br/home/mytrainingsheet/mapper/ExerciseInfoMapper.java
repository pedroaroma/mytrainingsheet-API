package com.br.home.mytrainingsheet.mapper;

import com.br.home.mytrainingsheet.dto.exercise.ExerciseInfoDTO;
import com.br.home.mytrainingsheet.entity.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExerciseInfoMapper {

    ExerciseInfoMapper INSTANCE = Mappers.getMapper(ExerciseInfoMapper.class);

    Exercise toModel(ExerciseInfoMapper exerciseInfoMapper);
    ExerciseInfoDTO toDTO(Exercise exercise);

}
