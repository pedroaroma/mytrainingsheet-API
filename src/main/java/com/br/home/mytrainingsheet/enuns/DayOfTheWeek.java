package com.br.home.mytrainingsheet.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DayOfTheWeek {

    SUNDAY("Domingo"),
    MONDAY("Segunda-Feira"),
    TUESDAY("Terça-Feira"),
    WEDNESDAY("Quarta-Feira"),
    THURSDAY("Quinta-Feira"),
    FRIDAY("Sexta-Feira"),
    SATURDAY("Sábado");


    private final String dayDescription;
}
