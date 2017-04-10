package com.andersen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Car {

    @Id
    @GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequenceName", value = "car_sequence"),
            @org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
    })

    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)

    private Long id;

    private String carName;

    private String productionCountry;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CarModel> models;
}