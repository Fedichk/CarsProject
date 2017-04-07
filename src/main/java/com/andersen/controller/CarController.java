package com.andersen.controller;

import com.andersen.model.Car;
import com.andersen.model.CarModel;
import com.andersen.repository.CarModelRepository;
import com.andersen.repository.CarRepository;
import lombok.Data;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller
@Data
public class CarController {

    private final CarRepository carRepository;
    private final CarModelRepository modelRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String carName;
    private String carProductionCountry;
    private Car targetCar;
    private String modelName;
    private Integer modelYear;
    private Long modelPrice;

    @Autowired
    public CarController(CarRepository carRepository, CarModelRepository modelRepository) {
        this.carRepository = carRepository;
        this.modelRepository = modelRepository;
    }

    public List<Car> getAll() {
        return carRepository.findAllByOrderByIdAsc();
    }

    public void onRowSelect(SelectEvent event) {
        Car tempCar = (Car) event.getObject();
        targetCar = carRepository.findOne(tempCar.getId());
        targetCar.setModels(modelRepository.findAllByManufacturerNameId(targetCar.getId()));
    }

    public List<CarModel> getModels() {
        return modelRepository.findAll();
    }

    @Secured("ROLE_ADMIN")
    public void save() {
        Car car = new Car();
        car.setCarName(carName);
        car.setProductionCountry(carProductionCountry);
        carRepository.saveAndFlush(car);
    }

    public void saveModel() {
        CarModel model = new CarModel();
        model.setModelName(modelName);
        model.setManufacturedYear(modelYear);
        model.setPrice(modelPrice);
        model.setManufacturerName(carRepository.findOne(targetCar.getId()));
        modelRepository.saveAndFlush(model);
    }

    @Secured("ROLE_ADMIN")
    public void saveModelByPlSql() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "", modelRepository.saveModel(modelName, modelYear, modelPrice, targetCar.getId())));
    }
}
