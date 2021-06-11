package com.br.home.mytrainingsheet.repository;

import com.br.home.mytrainingsheet.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
