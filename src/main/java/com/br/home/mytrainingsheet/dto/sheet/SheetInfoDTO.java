package com.br.home.mytrainingsheet.dto.sheet;

import com.br.home.mytrainingsheet.enuns.DayOfTheWeek;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SheetInfoDTO {

    private Long id;

    @NotNull
    private String sheetName;

    //private List<Exercice> exercices;

    @Enumerated(EnumType.STRING)
    @NotNull
    private DayOfTheWeek weekDay;
}
