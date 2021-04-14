package com.br.home.mytrainingsheet.entity.sheet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Exercice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Many Exercice to One Sheet
    @ManyToOne
    @JoinColumn(name = "sheet_id")
    @JsonIgnore
    private Sheet sheet;

    private String name;

    private Integer series;

    private Integer repetitions;

    private Integer rest;


}
