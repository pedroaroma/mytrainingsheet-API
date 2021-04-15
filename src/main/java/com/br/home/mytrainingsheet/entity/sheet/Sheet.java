package com.br.home.mytrainingsheet.entity.sheet;

import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.enuns.SheetType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Sheet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Many Sheet to One Customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SheetType sheetType;


    @OneToMany(mappedBy = "sheet",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    //One Sheet to Many Exercices
    private List<Exercice> exercices;


}
