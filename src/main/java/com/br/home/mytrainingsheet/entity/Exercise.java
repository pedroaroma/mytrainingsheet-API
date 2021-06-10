package com.br.home.mytrainingsheet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Exercise implements Serializable {

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

    private Float weight;

    private Integer rest;

    private String comment;

}
