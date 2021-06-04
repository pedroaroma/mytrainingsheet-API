package com.br.home.mytrainingsheet.service.customer;

import com.br.home.mytrainingsheet.dto.customer.CustomerDTO;
import com.br.home.mytrainingsheet.dto.customer.CustomerInfoDTO;
import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.exception.customer.CustomerAlreadyRegisteredException;
import com.br.home.mytrainingsheet.exception.customer.CustomerDTOIsEmpty;
import com.br.home.mytrainingsheet.exception.customer.CustomerNotFoundException;
import com.br.home.mytrainingsheet.mapper.CustomerInfoMapper;
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
    private final CustomerInfoMapper customerInfoMapper = CustomerInfoMapper.INSTANCE;

    public CustomerInfoDTO createCustomer(CustomerDTO customerDTO) throws CustomerAlreadyRegisteredException {

        verifyIfIsAlreadyRegisteredByEmail(customerDTO.getEmail());
        Customer customer = customerMapper.toModel(customerDTO);
        Customer customerSaved = customerRepository.save(customer);

        return customerInfoMapper.toDTO(customerSaved);
    }

    public void deleteById(Long id) throws CustomerNotFoundException {
        verifyIfAlreadyRegistredById(id);
        customerRepository.deleteById(id);
    }

    public CustomerInfoDTO updateCustomer(CustomerDTO customerDTO, Long id) throws CustomerNotFoundException, CustomerDTOIsEmpty {


        Customer customerForUpdate = verifyIfAlreadyRegistredById(id);
        verifyIfCustomerDTOisEmpty(customerDTO);

        Customer customer = customerMapper.toModel(customerDTO);

        if (customer.getPassword() != null && !customer.getPassword().isEmpty()) {
            customerForUpdate.setPassword(customer.getPassword());
        }
        if (customer.getFullName() != null && !customer.getFullName().isEmpty()) {
            customerForUpdate.setFullName(customer.getFullName());
        }
        customerRepository.save(customerForUpdate);

        return customerInfoMapper.toDTO(customerForUpdate);

    }

    public CustomerInfoDTO getCustomerInfo(Long id) throws CustomerNotFoundException {
        Customer customer = verifyIfAlreadyRegistredById(id);
        return customerInfoMapper.toDTO(customer);
    }

    //endpoint para testes
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

    private void verifyIfCustomerDTOisEmpty(CustomerDTO customerDTO) throws CustomerDTOIsEmpty {
        if ((customerDTO.getPassword() == null || customerDTO.getPassword().isEmpty()) && (customerDTO.getFullName() == null || customerDTO.getFullName().isEmpty())) {
            throw new CustomerDTOIsEmpty();
        }
    }

}
