package com.br.home.mytrainingsheet.exception.sheet;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoSheetsException extends Exception {
    public NoSheetsException(Long id) {
        super(String.format("There are no sheets for the user ", id));
    }
}
