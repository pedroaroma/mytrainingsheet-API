package com.br.home.mytrainingsheet.controller.exercice;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer/{userId}/sheets/exercise")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExerciseController {
}
