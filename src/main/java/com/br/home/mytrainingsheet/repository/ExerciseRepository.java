package com.br.home.mytrainingsheet.repository;

import com.br.home.mytrainingsheet.entity.Exercise;
import com.br.home.mytrainingsheet.entity.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findAllBySheet(Sheet sheet);

}
