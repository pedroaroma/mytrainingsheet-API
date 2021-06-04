package com.br.home.mytrainingsheet.entity.sheet;

import com.br.home.mytrainingsheet.entity.Customer;
import com.br.home.mytrainingsheet.enuns.DayOfTheWeek;
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
    private String sheetName;

    @OneToMany(mappedBy = "sheet",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    //One Sheet to Many Exercices
    private List<Exercice> exercices;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfTheWeek weekDay;

}
