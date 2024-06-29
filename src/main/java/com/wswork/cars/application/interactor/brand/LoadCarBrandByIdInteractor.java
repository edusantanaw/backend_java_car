package com.wswork.cars.application.interactor.brand;

import com.wswork.cars.application.gateway.LoadByIdGateway;
import com.wswork.cars.domain.entities.CarBrand;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.Optional;
import java.util.UUID;

public class LoadCarBrandByIdInteractor {
    private final LoadByIdGateway<CarBrand> repository;

    public LoadCarBrandByIdInteractor(LoadByIdGateway<CarBrand> carBrandLoadByIdGateway) {
        this.repository = carBrandLoadByIdGateway;
    }

    public CarBrand loadById(UUID id) throws NotFoundException {
        Optional<CarBrand> carBrand = repository.loadById(id);
        if(carBrand.isEmpty())throw new NotFoundException("Marca não encontrada!");
        return  carBrand.get();
    }
}
