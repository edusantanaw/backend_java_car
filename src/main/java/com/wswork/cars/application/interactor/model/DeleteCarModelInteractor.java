package com.wswork.cars.application.interactor.model;

import com.wswork.cars.application.gateway.DeleteGateway;
import com.wswork.cars.application.gateway.FindByModeloGateway;
import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.domain.exceptions.DomainException;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DeleteCarModelInteractor {
    private final DeleteGateway<CarModel> repository;
    private final FindByModeloGateway<Car> carRepository;

    public DeleteCarModelInteractor(DeleteGateway<CarModel> repository, FindByModeloGateway<Car> carRepository) {
        this.repository = repository;
        this.carRepository = carRepository;
    }

    public String delete(UUID id) throws NotFoundException {
        Optional<CarModel> carModel = repository.loadById(id);
        if(carModel.isEmpty()) throw new NotFoundException("Modelo não encontrado");
        List<Car> cars = carRepository.findByModelo(id);
        if(!cars.isEmpty()) throw new DomainException("Delete todos os carros vinculados a este modelo!");
        repository.delete(carModel.get());
        return "Modelo deletado com sucesso!";
    }
}
