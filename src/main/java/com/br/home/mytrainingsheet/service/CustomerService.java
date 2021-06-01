package com.br.home.mytrainingsheet.service;

import com.br.home.mytrainingsheet.dto.CustomerDTO;
import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.exception.CustomerAlreadyRegisteredException;
import com.br.home.mytrainingsheet.exception.CustomerDTOIsEmpty;
import com.br.home.mytrainingsheet.exception.CustomerNotFoundException;
import com.br.home.mytrainingsheet.mapper.CustomerMapper;
import com.br.home.mytrainingsheet.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id) throws CustomerNotFoundException, CustomerDTOIsEmpty {


        Customer customerForUpdate = verifyIfAlreadyRegistredById(id);
        verifiyIfCustomerDTOisEmpty(customerDTO);

        Customer customer = customerMapper.toModel(customerDTO);

        if (customer.getPassword() != null) {
            customerForUpdate.setPassword(customer.getPassword());
        }
        if (customer.getFullName() != null) {
            customerForUpdate.setFullName(customer.getFullName());
        }
        customerRepository.save(customerForUpdate);

        return customerMapper.toDTO(customerForUpdate);

    }

    public CustomerDTO getCustomerInfos(Long id) throws CustomerNotFoundException {
        Customer customer = verifyIfAlreadyRegistredById(id);
        return customerMapper.toDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {

        List<Customer> customers;
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        customers = customerRepository.findAll();

        customers.forEach(customer -> customerDTOS.add(customerMapper.toDTO(customer)));

        return customerDTOS;

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

    private void verifiyIfCustomerDTOisEmpty(CustomerDTO customerDTO) throws CustomerDTOIsEmpty {
        if (customerDTO.getPassword() == null && customerDTO.getFullName() == null) {
            throw new CustomerDTOIsEmpty();
        }
    }


}
