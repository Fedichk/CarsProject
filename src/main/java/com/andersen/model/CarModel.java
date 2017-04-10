package com.andersen.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "save_model",
                procedureName = "cars_project_pkg.save_model",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "paramModelName", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "paramYear", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "paramPrice", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "paramManufactureId", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "delete_model",
                procedureName = "delete_model_pkg.delete_model",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "carModelId", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "MESSAGE", type = String.class)
                })
})
public class CarModel {

    @Id
    @GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequenceName", value = "model_sequence"),
            @org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
    })
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String modelName;

    private Integer manufacturedYear;

    private Long price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacture_id", referencedColumnName = "id")
    private Car manufacturerName;
}
