package com.br.home.mytrainingsheet.controller.exercice;


import com.br.home.mytrainingsheet.dto.exercise.ExerciseDTO;
import com.br.home.mytrainingsheet.dto.exercise.ExerciseInfoDTO;
import com.br.home.mytrainingsheet.entity.Exercise;
import com.br.home.mytrainingsheet.exception.customer.CustomerNotFoundException;
import com.br.home.mytrainingsheet.exception.sheet.SheetNotFoundException;
import com.br.home.mytrainingsheet.service.exercise.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer/{userId}/sheets/{sheetId}/exercise")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExerciseController {

    private final ExerciseService exerciseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExerciseInfoDTO createExercise(@RequestBody ExerciseDTO exerciseDTO,
                                          @PathVariable Long userId,
                                          @PathVariable Long sheetId)
            throws CustomerNotFoundException, SheetNotFoundException {

        return exerciseService.createExercise(exerciseDTO, userId, sheetId);
    }

}
