package com.br.home.mytrainingsheet.repository;

import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.entity.sheet.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SheetRepository extends JpaRepository<Sheet, Long> {

//    @Query(
//            value = "SELECT * FROM sheet WHERE customer_id = ?1",
//            nativeQuery = true
//    )
//    List<Sheet> findAllActiveSheetNative(Long id);
    List<Sheet> findAllByCustomer(Customer customer);

}
