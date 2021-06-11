package com.br.home.mytrainingsheet.exception.exercise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExerciseNotFoundException extends Exception {

    public ExerciseNotFoundException(Long exerciseId) {
        super(String.format("Exercise with id %s was not found in the server.", exerciseId));
    }


}
