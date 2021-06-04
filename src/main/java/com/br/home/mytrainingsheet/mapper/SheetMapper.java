package com.br.home.mytrainingsheet.mapper;


import com.br.home.mytrainingsheet.dto.sheet.SheetDTO;
import com.br.home.mytrainingsheet.entity.sheet.Sheet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SheetMapper {
    SheetMapper INSTANCE = Mappers.getMapper(SheetMapper.class);

    Sheet toModel(SheetDTO sheetDTO);
    SheetDTO toDTO(Sheet sheet);

}
