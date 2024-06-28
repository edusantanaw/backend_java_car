package com.wswork.cars.application.interactor.car;

import com.wswork.cars.application.gateway.DeleteGateway;
import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DeleteCarInteractor {
    private final DeleteGateway<Car> repository;

    public DeleteCarInteractor(DeleteGateway<Car> repository) {
        this.repository = repository;
    }

    public String delete(UUID id) throws NotFoundException {
        Optional<Car> car = repository.loadById(id);
        if(car.isEmpty()) throw new NotFoundException("Carro não encontrado!");
        repository.delete(car.get());
        return "Carro deletado com sucesso!";
    }
}
