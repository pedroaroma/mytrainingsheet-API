package com.br.home.mytrainingsheet.entity.sheet;

import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.enuns.SheetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sheet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Many Sheet to One Customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private SheetType sheetType;


    @OneToMany(mappedBy = "sheet", cascade = CascadeType.ALL, orphanRemoval = true)
    //One Sheet to Many Exercices
    private List<Exercice> exercices;


}
