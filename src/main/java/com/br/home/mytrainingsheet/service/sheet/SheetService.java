package com.br.home.mytrainingsheet.service.sheet;

import com.br.home.mytrainingsheet.dto.sheet.SheetDTO;
import com.br.home.mytrainingsheet.dto.sheet.SheetInfoDTO;
import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.entity.Sheet;
import com.br.home.mytrainingsheet.exception.customer.CustomerNotFoundException;
import com.br.home.mytrainingsheet.exception.sheet.SheetNotFoundException;
import com.br.home.mytrainingsheet.mapper.SheetInfoMapper;
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
    private final SheetInfoMapper sheetInfoMapper = SheetInfoMapper.INSTANCE;

    public SheetInfoDTO createSheet(SheetDTO sheetDTO, Long userId) throws CustomerNotFoundException {

        Optional<Customer> customerOpt = Optional.ofNullable(customerRepository.findById(userId)
                .orElseThrow(() -> new CustomerNotFoundException(userId)));

        sheetDTO.setCustomer(customerOpt.get());

        //List<SheetInfoDTO> sheetInfoDTO = getAllSheetsByCustomer(customerOpt.get().getId());

        Sheet sheet = sheetMapper.toModel(sheetDTO);
        Sheet sheetSaved = sheetRepository.save(sheet);


        return sheetInfoMapper.toDTO(sheetSaved);
    }

//    public List<SheetDTO> getAllSheets(Long id) {
//
//        Optional<Customer> customerOpt = customerRepository.findById(id);
//        Customer customer = customerOpt.get();
//        //encontra um modo de recuperar as sheets criando uma query direta, passando como parametro
//        //o  objeto Customer
//
//        List<Sheet> sheets = customer.getSheets();
//        List<SheetDTO> sheetDTOS = new ArrayList<>();
//        sheets.stream().forEach(sheet -> sheetDTOS.add(sheetMapper.toDTO(sheet)));
//
//        return sheetDTOS;

//    }

    public SheetInfoDTO updateSheet(SheetInfoDTO sheetInfoDTO, Long idSheet) throws SheetNotFoundException {
        //colocar exception de sheetInfoDTO is empty 304 not modified
        Optional<Sheet> sheetOpt = Optional.ofNullable(sheetRepository.findById(idSheet)
                .orElseThrow(() -> new SheetNotFoundException(idSheet)));

        Sheet sheetInfoUpdate = sheetOpt.get();

        if (sheetInfoDTO.getSheetName() != null && !sheetInfoDTO.getSheetName().isEmpty()) {
            sheetInfoUpdate.setSheetName(sheetInfoDTO.getSheetName());
        }
        if (sheetInfoDTO.getWeekDay() != null && !sheetInfoDTO.getWeekDay().toString().isEmpty()) {
            sheetInfoUpdate.setWeekDay(sheetInfoDTO.getWeekDay());
        }

        sheetRepository.save(sheetInfoUpdate);

        return sheetInfoMapper.toDTO(sheetInfoUpdate);
    }

    public List<SheetInfoDTO> getAllSheetsByCustomer(Long id) throws CustomerNotFoundException {

        Optional<Customer> customerOpt = Optional.ofNullable(customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id)));

        Customer customer = customerOpt.get();

        List<Sheet> sheets = sheetRepository.findAllByCustomer(customer);


        List<SheetInfoDTO> sheetDTOS = new ArrayList<>();

        sheets.forEach(sheet -> sheetDTOS.add(sheetInfoMapper.toDTO(sheet)));


        return sheetDTOS;
    }

    public SheetInfoDTO getSingleSheetById(Long id) throws SheetNotFoundException {

        Optional<Sheet> sheetOptional = Optional.ofNullable(sheetRepository.findById(id)
                .orElseThrow(() -> new SheetNotFoundException(id)));

        Sheet sheet = sheetOptional.get();

        SheetInfoDTO singleSheet = sheetInfoMapper.toDTO(sheet);

        return singleSheet;
    }

    public void deleteSingleSheetById(Long idSheet) throws SheetNotFoundException {

        Optional<Sheet> sheetOptional = Optional.ofNullable(sheetRepository.findById(idSheet)
                .orElseThrow(() -> new SheetNotFoundException(idSheet)));

        Sheet sheet = sheetOptional.get();

        sheetRepository.delete(sheet);

    }
//    public List<SheetDTO> getAllSheetsByCustomerNativeQuery(Long id) {
//
//        List<Sheet> sheets = sheetRepository.findAllActiveSheetNative(id);
//        List<SheetDTO> sheetDTOS = new ArrayList<>();
//
//        sheets.forEach(sheet -> sheetDTOS.add(sheetMapper.toDTO(sheet)));
//
//        return sheetDTOS;

//    }

}
