package com.br.home.mytrainingsheet.repository;

import com.br.home.mytrainingsheet.entity.sheet.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SheetRepository extends JpaRepository<Sheet, Long> {

}
