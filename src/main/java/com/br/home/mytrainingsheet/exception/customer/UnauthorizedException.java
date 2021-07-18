package com.br.home.mytrainingsheet.exception.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends Exception {

    public UnauthorizedException() {
        super(new String("You do not have access to create or edit this resource."));
    }
}
