package com.wswork.cars.application.interactor.brand;

import com.wswork.cars.application.gateway.UpdateGateway;
import com.wswork.cars.domain.entities.CarBrand;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.Optional;
import java.util.UUID;

public class UpdateCarBrandInteractor {
    private final UpdateGateway<CarBrand> repository;

    public UpdateCarBrandInteractor(UpdateGateway<CarBrand> repository) {
        this.repository = repository;
    }

    public CarBrand update(UUID id, String name) throws NotFoundException {
        Optional<CarBrand> carBrandOptional = repository.loadById(id);
        if (carBrandOptional.isEmpty()) throw new NotFoundException(("Marca não econtrada!"));
        CarBrand carBrand = new CarBrand(id, name);
        return repository.update(carBrand);
    }
}
