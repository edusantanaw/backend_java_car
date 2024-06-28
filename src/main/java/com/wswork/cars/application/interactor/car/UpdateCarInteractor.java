package com.wswork.cars.application.interactor.car;

import com.wswork.cars.application.dto.UpdateCorDto;
import com.wswork.cars.application.gateway.UpdateGateway;
import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.Optional;

public class UpdateCarInteractor {
    private final UpdateGateway<Car> repository;

    public UpdateCarInteractor(UpdateGateway<Car> repository) {
        this.repository = repository;
    }

    public Car update(UpdateCorDto data) throws NotFoundException {
        Optional<Car> carOptional = repository.loadById(data.id());
        if(carOptional.isEmpty()) throw new NotFoundException("Carro não encontrado!");
        Car car = carOptional.get();
        car.setAno(data.ano());
        car.setCor(data.cor());
        car.setCombustivel(data.combustivel());
        car.setNum_portas(data.num_portas());
        repository.update(car);
        return car;
    }
}
