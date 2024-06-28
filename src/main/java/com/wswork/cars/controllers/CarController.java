package com.wswork.cars.controllers;

import com.wswork.cars.application.dto.CreateCarDto;
import com.wswork.cars.application.interactor.car.CreateCarInteractor;
import com.wswork.cars.controllers.validation.CreateCarValidation;
import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/car")
@RequestMapping("/api/car")
@AllArgsConstructor()
public class CarController {
    private final CreateCarInteractor createCarInteractor;

    @PostMapping()
    public ResponseEntity<Car> CreateCar(@RequestBody() @Valid CreateCarValidation data) throws NotFoundException {
        CreateCarDto carDto = new CreateCarDto(data.modelo_id, data.ano, data.cor, data.num_portas, data.combustivel);
        Car car = createCarInteractor.create(carDto);
        return ResponseEntity.status(201).body(car);
    }
}
