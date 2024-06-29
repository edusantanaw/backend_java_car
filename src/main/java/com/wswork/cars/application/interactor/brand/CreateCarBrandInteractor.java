package com.wswork.cars.application.interactor.brand;

import com.wswork.cars.application.gateway.CreateGateway;
import com.wswork.cars.domain.entities.CarBrand;

public class CreateCarBrandInteractor {
    private final CreateGateway<CarBrand> repository;

    public CreateCarBrandInteractor(CreateGateway<CarBrand> repository) {
        this.repository = repository;
    }

    public CarBrand create(String nome) {
        return repository.create(new CarBrand(null, nome));
    }
}
