package com.br.home.mytrainingsheet.mapper;

import com.br.home.mytrainingsheet.dto.CustomerInfoDTO;
import com.br.home.mytrainingsheet.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerInfoMapper {

    CustomerInfoMapper INSTANCE = Mappers.getMapper(CustomerInfoMapper.class);

    Customer toModel(CustomerInfoMapper customerInfoMapper);
    CustomerInfoDTO toDTO(Customer customer);


}
