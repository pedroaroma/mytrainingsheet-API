package com.br.home.mytrainingsheet.service;

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

        verifyIfIsAlreadyRegistered(customerDTO.getEmail());
        Customer customer = customerMapper.toModel(customerDTO);
        Customer customerSaved = customerRepository.save(customer);

        return customerMapper.toDTO(customerSaved);
    }


    private void verifyIfIsAlreadyRegistered(String email) throws CustomerAlreadyRegisteredException {

        Optional<Customer> optSavedCustomer = customerRepository.findByEmail(email);

        if (optSavedCustomer.isPresent()) {
            throw new CustomerAlreadyRegisteredException(email);
        }
    }

}
