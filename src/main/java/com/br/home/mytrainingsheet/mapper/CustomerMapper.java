package com.br.home.mytrainingsheet.mapper;

import com.br.home.mytrainingsheet.dto.CustomerDTO;
import com.br.home.mytrainingsheet.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toModel(CustomerDTO customerDTO);
    CustomerDTO toDTO(Customer customer);



}
