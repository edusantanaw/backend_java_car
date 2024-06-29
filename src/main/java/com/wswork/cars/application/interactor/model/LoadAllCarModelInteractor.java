package com.wswork.cars.application.interactor.model;

import com.wswork.cars.application.gateway.LoadAllGateway;
import com.wswork.cars.domain.entities.CarModel;

import java.util.List;

public class LoadAllCarModelInteractor {
    private final LoadAllGateway<CarModel> repository;

    public LoadAllCarModelInteractor(LoadAllGateway<CarModel> repository) {
        this.repository = repository;
    }

    public List<CarModel> loadAll(){
        return repository.loadAll();
    }
}
