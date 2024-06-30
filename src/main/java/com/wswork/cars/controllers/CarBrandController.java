package com.wswork.cars.controllers;

import com.wswork.cars.application.interactor.brand.*;
import com.wswork.cars.controllers.dtos.LoadManyCarBrandsDto;
import com.wswork.cars.controllers.validation.CarBrandValidation;
import com.wswork.cars.domain.entities.CarBrand;
import com.wswork.cars.domain.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/brand")
@AllArgsConstructor
public class CarBrandController {
    private final CreateCarBrandInteractor createCarBrandInteractor;
    private final LoadAllCarBrandInteractor loadAllCarBrandInteractor;
    private final LoadCarBrandByIdInteractor loadCarBrandByIdInteractor;
    private final DeleteCarBrandInteractor deleteCarBrandInteractor;
    private final UpdateCarBrandInteractor updateCarBrandInteractor;

    @PostMapping
    ResponseEntity<CarBrand> create(@RequestBody @Valid CarBrandValidation carBrandValidation) {
        CarBrand carBrand = createCarBrandInteractor.create(carBrandValidation.nome_marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(carBrand);
    }

    @GetMapping()
    ResponseEntity<LoadManyCarBrandsDto> loadAll() {
        List<CarBrand> carBrands = loadAllCarBrandInteractor.loadAll();
        return ResponseEntity.status(HttpStatus.OK).body(new LoadManyCarBrandsDto(carBrands));
    }

    @GetMapping(value = "{id}")
    ResponseEntity<CarBrand> loadById(@PathVariable UUID id) throws NotFoundException {
        CarBrand carBrand = loadCarBrandByIdInteractor.loadById(id);
        return ResponseEntity.status(HttpStatus.OK).body(carBrand);
    }

    @DeleteMapping(value = "{id}")
    ResponseEntity<String> delete(@PathVariable UUID id) throws NotFoundException {
        String message = deleteCarBrandInteractor.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @PutMapping(value = "{id}")
    ResponseEntity<CarBrand> update(@PathVariable UUID id, @RequestBody @Valid CarBrandValidation carBrandValidation) throws NotFoundException {
        CarBrand carBrand = updateCarBrandInteractor.update(id, carBrandValidation.nome_marca);
        return ResponseEntity.status(HttpStatus.OK).body(carBrand);
    }

}
