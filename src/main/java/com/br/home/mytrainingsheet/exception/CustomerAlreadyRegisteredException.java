package com.br.home.mytrainingsheet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerAlreadyRegisteredException extends Exception {

    public CustomerAlreadyRegisteredException(String email) {
        super(String.format("This email %s is already registred", email));
    }
}
