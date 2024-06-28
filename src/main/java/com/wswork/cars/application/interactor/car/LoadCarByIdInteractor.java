package com.wswork.cars.application.interactor.car;

import com.wswork.cars.application.gateway.LoadByIdGateway;
import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.Optional;
import java.util.UUID;

public class LoadCarByIdInteractor {
    private final LoadByIdGateway<Car> repository;

    public LoadCarByIdInteractor(LoadByIdGateway<Car> repository) {
        this.repository = repository;
    }

    public Car loadById(UUID id) throws NotFoundException {
        Optional<Car> car = repository.loadById(id);
        if(car.isEmpty()) throw new NotFoundException("Carro não encontrado!");
        return  car.get();
    }
}
