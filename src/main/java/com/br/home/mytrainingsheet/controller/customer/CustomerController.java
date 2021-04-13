package com.br.home.mytrainingsheet.controller.customer;

import com.br.home.mytrainingsheet.dto.CustomerDTO;
import com.br.home.mytrainingsheet.exception.CustomerAlreadyRegisteredException;
import com.br.home.mytrainingsheet.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController implements CustomerControllerDocs {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody @Valid CustomerDTO customerDTO) throws CustomerAlreadyRegisteredException {
        return customerService.createCustomer(customerDTO);
    }

}