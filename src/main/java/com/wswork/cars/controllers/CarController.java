package com.wswork.cars.controllers;

import com.wswork.cars.application.dto.CreateCarDto;
import com.wswork.cars.application.dto.UpdateCorDto;
import com.wswork.cars.application.interactor.car.*;
import com.wswork.cars.controllers.dtos.LoadManyCarsDto;
import com.wswork.cars.controllers.validation.CarValidation;
import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.exceptions.EntityValidationException;
import com.wswork.cars.domain.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/api/car")
@RequestMapping("/api/car")
@AllArgsConstructor()
public class CarController {
    private final CreateCarInteractor createCarInteractor;
    private final LoadCarByIdInteractor loadCarByIdInteractor;
    private final DeleteCarInteractor deleteCarInteractor;
    private final UpdateCarInteractor updateCarInteractor;
    private final LoadAllCarInteractor loadAllCarInteractor;

    @PostMapping()
    public ResponseEntity<Car> createCar(@RequestBody() @Valid CarValidation data) throws NotFoundException, EntityValidationException {
        CreateCarDto carDto = new CreateCarDto(data.modelo_id, data.ano, data.cor, data.num_portas, data.combustivel);
        Car car = createCarInteractor.create(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

    @GetMapping()
    public ResponseEntity<LoadManyCarsDto> loadAllCar() {
        List<Car> cars = loadAllCarInteractor.loadAll();
        return ResponseEntity.status(HttpStatus.OK).body(new LoadManyCarsDto(cars));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Car> loadCarById(@PathVariable UUID id) throws NotFoundException {
        Car car = loadCarByIdInteractor.loadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteCar(@PathVariable UUID id, @RequestBody @Valid CarValidation data) throws NotFoundException {
        String message = deleteCarInteractor.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Car> updateCar(@PathVariable UUID id, @RequestBody @Valid CarValidation data) throws NotFoundException {
        UpdateCorDto carDto = new UpdateCorDto(data.modelo_id, data.ano, data.cor, data.num_portas, data.combustivel, id);
        Car car = updateCarInteractor.update(carDto);
        return ResponseEntity.status(HttpStatus.OK).body(car);
    }
}
