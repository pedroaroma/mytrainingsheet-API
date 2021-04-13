package com.br.home.mytrainingsheet.service;

import com.br.home.mytrainingsheet.exception.CustomerNotFoundException;
import lombok.AllArgsConstructor;
import com.br.home.mytrainingsheet.dto.CustomerDTO;
import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.exception.CustomerAlreadyRegisteredException;
import com.br.home.mytrainingsheet.mapper.CustomerMapper;
import com.br.home.mytrainingsheet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws CustomerAlreadyRegisteredException {

        verifyIfIsAlreadyRegisteredByEmail(customerDTO.getEmail());
        Customer customer = customerMapper.toModel(customerDTO);
        Customer customerSaved = customerRepository.save(customer);

        return customerMapper.toDTO(customerSaved);
    }

    public void deleteById(Long id) throws CustomerNotFoundException {
        verifyIfAlreadyRegistredById(id);
        customerRepository.deleteById(id);
    }


    private void verifyIfIsAlreadyRegisteredByEmail(String email) throws CustomerAlreadyRegisteredException {

        Optional<Customer> optSavedCustomer = customerRepository.findByEmail(email);

        if (optSavedCustomer.isPresent()) {
            throw new CustomerAlreadyRegisteredException(email);
        }
    }

    private Customer verifyIfAlreadyRegistredById(Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

}
