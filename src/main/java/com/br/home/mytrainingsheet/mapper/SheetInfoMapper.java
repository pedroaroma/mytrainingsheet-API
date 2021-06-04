package com.br.home.mytrainingsheet.mapper;

import com.br.home.mytrainingsheet.dto.sheet.SheetInfoDTO;
import com.br.home.mytrainingsheet.entity.sheet.Sheet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SheetInfoMapper {

    SheetInfoMapper INSTANCE = Mappers.getMapper(SheetInfoMapper.class);

    Sheet toModel(SheetInfoMapper sheetInfoMapper);
    SheetInfoDTO toDTO(Sheet sheet);
}
