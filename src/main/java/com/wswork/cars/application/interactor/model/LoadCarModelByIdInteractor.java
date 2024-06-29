package com.wswork.cars.application.interactor.model;

import com.wswork.cars.application.gateway.LoadByIdGateway;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.domain.exceptions.NotFoundException;
import com.wswork.cars.infra.gateway.CarModelGateway;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class LoadCarModelByIdInteractor {
    public final LoadByIdGateway<CarModel> repository;

    public LoadCarModelByIdInteractor(LoadByIdGateway<CarModel> repository) {
        this.repository = repository;
    }

    public CarModel loadById(UUID id) throws NotFoundException {
        Optional<CarModel> carModel = repository.loadById(id);
        if(carModel.isEmpty()) throw new NotFoundException("Modelo não econtrado!");
        return carModel.get();
    }
}
