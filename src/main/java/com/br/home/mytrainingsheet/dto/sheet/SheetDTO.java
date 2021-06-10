package com.br.home.mytrainingsheet.dto.sheet;

import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.entity.Exercise;
import com.br.home.mytrainingsheet.enuns.DayOfTheWeek;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SheetDTO {

    private Long id;

    @NotNull
    private String sheetName;

    @NotNull
    private Customer customer;

    private List<Exercise> exercises;

    @Column(nullable = false)
    @NotNull
    private DayOfTheWeek weekDay;

}
