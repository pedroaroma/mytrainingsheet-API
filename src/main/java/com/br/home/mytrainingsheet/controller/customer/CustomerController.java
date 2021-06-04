package com.br.home.mytrainingsheet.controller.customer;

import com.br.home.mytrainingsheet.dto.customer.CustomerDTO;
import com.br.home.mytrainingsheet.dto.customer.CustomerInfoDTO;
import com.br.home.mytrainingsheet.exception.customer.CustomerAlreadyRegisteredException;
import com.br.home.mytrainingsheet.exception.customer.CustomerDTOIsEmpty;
import com.br.home.mytrainingsheet.exception.customer.CustomerNotFoundException;
import com.br.home.mytrainingsheet.service.customer.CustomerService;
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
    public CustomerInfoDTO createCustomer(@RequestBody @Valid CustomerDTO customerDTO) throws CustomerAlreadyRegisteredException {
        return customerService.createCustomer(customerDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerInfoDTO getCustomerInfo(@PathVariable Long id) throws CustomerNotFoundException {
        return customerService.getCustomerInfo(id);
    }

    @PatchMapping("/{id}")
    public CustomerInfoDTO updateCustomerInfo(@PathVariable Long id, @RequestBody CustomerDTO customerDTO)
            throws CustomerNotFoundException, CustomerDTOIsEmpty {
        return customerService.updateCustomer(customerDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws CustomerNotFoundException {
        customerService.deleteById(id);
    }

    //endpoint apenas para testes
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
