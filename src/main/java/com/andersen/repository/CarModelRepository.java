package com.andersen.repository;

import com.andersen.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    List<CarModel> findAllByManufacturerNameId(long id);

    @Procedure(name = "save_model")
    String saveModel(@Param("paramModelName") String modelName, @Param("paramYear") Integer manufacturedYear,
                     @Param("paramPrice") Long price, @Param("paramManufactureId") Long manufacturedId);

    @Procedure(name = "delete_model")
    String deleteModel(@Param("carModelId") Long id);
}
