package com.br.home.mytrainingsheet.exception.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class CustomerDTOIsEmpty extends Exception{
    public CustomerDTOIsEmpty() {
        super();
    }
}
