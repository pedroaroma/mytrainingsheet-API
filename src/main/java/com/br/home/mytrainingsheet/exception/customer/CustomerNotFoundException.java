package com.br.home.mytrainingsheet.exception.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException(Long id) {
        super(String.format("User with id %s was not found in the server.", id));
    }


}
