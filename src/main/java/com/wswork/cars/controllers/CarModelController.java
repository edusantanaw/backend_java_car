package com.wswork.cars.controllers;

import com.wswork.cars.application.dto.CarModelDto;
import com.wswork.cars.application.interactor.car.CreateCarInteractor;
import com.wswork.cars.application.interactor.model.*;
import com.wswork.cars.controllers.dtos.LoadManyCarModelsDto;
import com.wswork.cars.controllers.validation.CarModelValidation;
import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.domain.exceptions.EntityValidationException;
import com.wswork.cars.domain.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/api/model")
@RequestMapping("/api/model")
@AllArgsConstructor
public class CarModelController {
    private final CreateCarModelInteractor createCarModelInteractor;
    private final LoadCarModelByIdInteractor loadCarModelByIdInteractor;
    private final DeleteCarModelInteractor deleteCarModelInteractor;
    private final LoadAllCarModelInteractor loadAllCarModelInteractor;
    private final UpdateCarModelInteractor updateCarModelInteractor;

    @PostMapping()
    ResponseEntity<CarModel> create(@RequestBody @Valid CarModelValidation carModelValidation) throws NotFoundException {
        CarModelDto carModelDto = new CarModelDto(carModelValidation.marca_id, carModelValidation.nome, carModelValidation.valor_fipe);
        CarModel carModel = createCarModelInteractor.create(carModelDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(carModel);
    }

    @GetMapping
    ResponseEntity<LoadManyCarModelsDto> loadAll() {
        List<CarModel> carModels = loadAllCarModelInteractor.loadAll();
        return ResponseEntity.status(HttpStatus.OK).body(new LoadManyCarModelsDto(carModels));
    }

    @GetMapping(value = "{id}")
    ResponseEntity<CarModel> loadById(@PathVariable UUID id) throws NotFoundException {
        CarModel carModel = loadCarModelByIdInteractor.loadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carModel);
    }

    @DeleteMapping(value = "{id}")
    ResponseEntity<String> delete(@PathVariable UUID id) throws NotFoundException {
        String message = deleteCarModelInteractor.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @PutMapping(value = "{id}")
    ResponseEntity<CarModel> update(@PathVariable UUID id, @RequestBody @Valid CarModelValidation carModelValidation) throws NotFoundException {
        CarModelDto carModelDto = new CarModelDto(carModelValidation.marca_id, carModelValidation.nome, carModelValidation.valor_fipe);
        CarModel carModel = updateCarModelInteractor.update(id, carModelDto);
        return ResponseEntity.status(HttpStatus.OK).body(carModel);
    }
}
