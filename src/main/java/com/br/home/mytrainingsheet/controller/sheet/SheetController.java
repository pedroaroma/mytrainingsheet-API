package com.br.home.mytrainingsheet.controller.sheet;

import com.br.home.mytrainingsheet.dto.sheet.SheetDTO;
import com.br.home.mytrainingsheet.dto.sheet.SheetInfoDTO;
import com.br.home.mytrainingsheet.exception.customer.CustomerNotFoundException;
import com.br.home.mytrainingsheet.exception.sheet.SheetNotFoundException;
import com.br.home.mytrainingsheet.service.sheet.SheetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/{userId}/sheets")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SheetController implements SheetControllerDocs {

    private final SheetService sheetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SheetInfoDTO createSheet(@RequestBody SheetDTO sheetDTO, @PathVariable Long userId) throws CustomerNotFoundException {
        return sheetService.createSheet(sheetDTO, userId);
    }

//    @GetMapping
//    @RequestMapping("/lol")
//    @ResponseStatus(HttpStatus.OK)
//    public List<SheetDTO> getAllSheetsNativeQuery(@PathVariable Long id) {
//       return sheetService.getAllSheetsByCustomerNativeQuery(id);
//
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SheetInfoDTO> getAllSheets(@PathVariable Long userId) throws CustomerNotFoundException {
        return sheetService.getAllSheetsByCustomer(userId);

    }

    @GetMapping("/{sheetId}")
    @ResponseStatus(HttpStatus.OK)
    public SheetInfoDTO getSingleSheet(@PathVariable Long sheetId) throws SheetNotFoundException {
        return sheetService.getSingleSheetById(sheetId);
    }

    @PatchMapping("/{sheetId}")
    @ResponseStatus(HttpStatus.OK)
    public SheetInfoDTO updateSheet(@RequestBody SheetInfoDTO sheetInfoDTO, @PathVariable Long sheetId) throws SheetNotFoundException {
        return sheetService.updateSheet(sheetInfoDTO, sheetId);
    }

    @DeleteMapping("/{sheetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSingleSheet(@PathVariable Long sheetId) throws SheetNotFoundException {
        sheetService.deleteSingleSheetById(sheetId);
    }


}
