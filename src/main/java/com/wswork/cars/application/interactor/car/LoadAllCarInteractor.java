package com.wswork.cars.application.interactor.car;

import com.wswork.cars.application.gateway.LoadAllGateway;
import com.wswork.cars.domain.entities.Car;

import java.util.List;

public class LoadAllCarInteractor {
    private final LoadAllGateway<Car> repository;

    public LoadAllCarInteractor(LoadAllGateway<Car> repository) {
        this.repository = repository;
    }

    public List<Car> loadAll() {
        return repository.loadAll();
    }
}
