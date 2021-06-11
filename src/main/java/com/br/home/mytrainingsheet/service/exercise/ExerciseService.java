package com.br.home.mytrainingsheet.service.exercise;

import com.br.home.mytrainingsheet.dto.exercise.ExerciseDTO;
import com.br.home.mytrainingsheet.dto.exercise.ExerciseInfoDTO;
import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.entity.Exercise;
import com.br.home.mytrainingsheet.entity.Sheet;
import com.br.home.mytrainingsheet.exception.customer.CustomerNotFoundException;
import com.br.home.mytrainingsheet.exception.sheet.SheetNotFoundException;
import com.br.home.mytrainingsheet.mapper.ExerciseInfoMapper;
import com.br.home.mytrainingsheet.mapper.ExerciseMapper;
import com.br.home.mytrainingsheet.repository.CustomerRepository;
import com.br.home.mytrainingsheet.repository.ExerciseRepository;
import com.br.home.mytrainingsheet.repository.SheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final CustomerRepository customerRepository;
    private final SheetRepository sheetRepository;

    private final ExerciseMapper exerciseMapper = ExerciseMapper.INSTANCE;
    private final ExerciseInfoMapper exerciseInfoMapper = ExerciseInfoMapper.INSTANCE;

    public ExerciseInfoDTO createExercise(ExerciseDTO exerciseDTO, Long userId, Long sheetId)
            throws SheetNotFoundException, CustomerNotFoundException {

        Optional<Sheet> sheetOpt = Optional.ofNullable(sheetRepository.findById(sheetId)
                .orElseThrow(() -> new SheetNotFoundException(sheetId)));

        exerciseDTO.setSheet(sheetOpt.get());

        Optional<Customer> customerOpt = Optional.ofNullable(customerRepository.findById(userId)
                .orElseThrow(() -> new CustomerNotFoundException(userId)));

        exerciseDTO.getSheet().setCustomer(customerOpt.get());


        Exercise exercise = exerciseMapper.toModel(exerciseDTO);
        Exercise exerciseSaved = exerciseRepository.save(exercise);

        return exerciseInfoMapper.toDTO(exerciseSaved);
    }

}
