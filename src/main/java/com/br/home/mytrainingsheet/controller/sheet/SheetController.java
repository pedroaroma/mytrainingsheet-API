package com.br.home.mytrainingsheet.controller.sheet;

import com.br.home.mytrainingsheet.dto.SheetDTO;
import com.br.home.mytrainingsheet.exception.CustomerNotFoundException;
import com.br.home.mytrainingsheet.service.SheetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/{id}/sheets")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SheetController implements SheetControllerDocs {

    private final SheetService sheetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SheetDTO createSheet(@RequestBody SheetDTO sheetDTO, @PathVariable Long id) throws CustomerNotFoundException {
        return sheetService.createSheet(sheetDTO, id);
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
    public List<SheetDTO> getAllSheets(@PathVariable Long id) {
        return sheetService.getAllSheetsByCustomer(id);

    }

    @DeleteMapping
    @RequestMapping("/{idSheet}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSingleSheet(@PathVariable Long idSheet) {
        sheetService.deleteSingleSheetById(idSheet);
    }


}
