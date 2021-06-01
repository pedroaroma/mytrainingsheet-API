package com.br.home.mytrainingsheet.controller.customer;

import com.br.home.mytrainingsheet.dto.CustomerDTO;
import com.br.home.mytrainingsheet.exception.CustomerAlreadyRegisteredException;
import com.br.home.mytrainingsheet.exception.CustomerNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api("Administra fichar de treino para frequentadores de academia")
public interface CustomerControllerDocs {

    @ApiOperation(value = "Criação de um novo usuário")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Usuário criado com sucesso!"),
        @ApiResponse(code = 400, message = "Falta alguns campos para completar o cadastro"),
        @ApiResponse(code = 404, message = "Usuário não encontrado")
    })
    CustomerDTO createCustomer(CustomerDTO customerDTO) throws CustomerAlreadyRegisteredException;
    void deleteById(Long id) throws CustomerNotFoundException;

}
