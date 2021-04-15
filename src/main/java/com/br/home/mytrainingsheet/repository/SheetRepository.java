package com.br.home.mytrainingsheet.repository;

import com.br.home.mytrainingsheet.entity.sheet.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SheetRepository extends JpaRepository<Sheet, Long> {

}
