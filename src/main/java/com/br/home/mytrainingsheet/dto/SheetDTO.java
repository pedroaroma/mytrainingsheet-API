package com.br.home.mytrainingsheet.dto;

import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.entity.sheet.Exercice;
import com.br.home.mytrainingsheet.enuns.SheetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SheetDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SheetType sheetType;

    @NotNull
    private Customer customer;

    private List<Exercice> exercices;

}
