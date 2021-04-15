package com.br.home.mytrainingsheet.service;

import com.br.home.mytrainingsheet.dto.SheetDTO;
import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.entity.sheet.Sheet;
import com.br.home.mytrainingsheet.exception.CustomerNotFoundException;
import com.br.home.mytrainingsheet.mapper.SheetMapper;
import com.br.home.mytrainingsheet.repository.CustomerRepository;
import com.br.home.mytrainingsheet.repository.SheetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SheetService {

    private final SheetRepository sheetRepository;
    private final SheetMapper sheetMapper = SheetMapper.INSTANCE;
    private final CustomerRepository customerRepository;

    public SheetDTO createSheet(SheetDTO sheetDTO, Long id) throws CustomerNotFoundException {

        Optional<Customer> customerOpt = customerRepository.findById(id);
        sheetDTO.setCustomer(customerOpt.get());

        Sheet sheet = sheetMapper.toModel(sheetDTO);
        Sheet sheetSaved = sheetRepository.save(sheet);



        return sheetMapper.toDTO(sheetSaved);
    }

    public List<SheetDTO> getAllSheets(Long id) {

        Optional<Customer> customerOpt = customerRepository.findById(id);
        Customer customer = customerOpt.get();
        //encontra um modo de recuperar as sheets criando uma query direta, passando como parametro
        //o  objeto Customer

        List<Sheet> sheets = customer.getSheets();
        List<SheetDTO> sheetDTOS = new ArrayList<>();
        sheets.stream().forEach(sheet -> sheetDTOS.add(sheetMapper.toDTO(sheet)));

        return sheetDTOS;
    }
}
