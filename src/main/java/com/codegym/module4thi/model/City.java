package com.codegym.module4thi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCity;
    private double acreage;
    private Integer population;
    private Integer gdp;
    private String describe1;
    @ManyToOne
    private Country country;
}
