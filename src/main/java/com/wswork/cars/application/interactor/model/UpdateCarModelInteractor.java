package com.wswork.cars.application.interactor.model;

import com.wswork.cars.application.dto.CarModelDto;
import com.wswork.cars.application.gateway.UpdateGateway;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.Optional;
import java.util.UUID;

public class UpdateCarModelInteractor {
    private final UpdateGateway<CarModel> repository;

    public UpdateCarModelInteractor(UpdateGateway<CarModel> repository) {
        this.repository = repository;
    }

    public CarModel update(UUID id, CarModelDto carModelDto) throws NotFoundException {
        Optional<CarModel> carModelOptional = repository.loadById(id);
        if (carModelOptional.isEmpty()) throw new NotFoundException("Modelo não encontrado!");
        CarModel carModel = new CarModel(id, carModelOptional.get().marca_id(), carModelDto.nome(), carModelDto.valor_fipe());
        return repository.update(carModel);
    }
}
