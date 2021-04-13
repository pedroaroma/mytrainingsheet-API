package com.br.home.mytrainingsheet.controller.customer;

import com.br.home.mytrainingsheet.dto.CustomerDTO;
import com.br.home.mytrainingsheet.exception.CustomerAlreadyRegisteredException;
import com.br.home.mytrainingsheet.exception.CustomerNotFoundException;
import com.br.home.mytrainingsheet.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws CustomerNotFoundException {
        customerService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public CustomerDTO updateCustomerInfo(@PathVariable Long id, @RequestBody CustomerDTO customerDTO)
            throws CustomerNotFoundException {
        return customerService.updateCustomer(customerDTO, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerInfo(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.getCustomerInfos(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
