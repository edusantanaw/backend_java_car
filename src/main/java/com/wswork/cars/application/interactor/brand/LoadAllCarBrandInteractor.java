package com.wswork.cars.application.interactor.brand;

import com.wswork.cars.application.gateway.LoadAllGateway;
import com.wswork.cars.domain.entities.CarBrand;

import java.util.List;

public class LoadAllCarBrandInteractor {
    private final LoadAllGateway<CarBrand> repository;

    public LoadAllCarBrandInteractor(LoadAllGateway<CarBrand> repository) {
        this.repository = repository;
    }

    public List<CarBrand> loadAll() {
        return repository.loadAll();
    }
}
