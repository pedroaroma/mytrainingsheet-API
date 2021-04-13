package com.br.home.mytrainingsheet.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SheetType {

    A("Ficha A"),
    B("Ficha B"),
    C("Ficha C"),
    D("Ficha D"),
    E("Ficha E"),
    F("Ficha F"),
    G("Ficha G");


    private final String description;
}
