package com.br.home.mytrainingsheet.exception.sheet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SheetNotFoundException extends Exception {

    public SheetNotFoundException(Long id) {
        super(String.format("Sheet with id %s was not found in the server.", id));
    }

}
