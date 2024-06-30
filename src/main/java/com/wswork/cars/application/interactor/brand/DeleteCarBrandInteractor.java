package com.wswork.cars.application.interactor.brand;

import com.wswork.cars.application.gateway.DeleteGateway;
import com.wswork.cars.application.gateway.FindByBrandGateway;
import com.wswork.cars.domain.entities.CarBrand;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.domain.exceptions.DomainException;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DeleteCarBrandInteractor {
    private final DeleteGateway<CarBrand> repository;
    private final FindByBrandGateway<CarModel> carModelRepository;

    public DeleteCarBrandInteractor(DeleteGateway<CarBrand> repository, FindByBrandGateway<CarModel> carModelRepository) {
        this.repository = repository;
        this.carModelRepository = carModelRepository;
    }

    public String delete(UUID id) throws NotFoundException {
        Optional<CarBrand> carBrand = repository.loadById(id);
        if(carBrand.isEmpty()) throw new NotFoundException("Marca não encontrada!");
        List<CarModel> carModels = carModelRepository.findByBrand(id);
        if(!carModels.isEmpty()) throw new DomainException("Delete todos os modelos vinculados a esta marca!");
        repository.delete(carBrand.get());
        return "Marca deletada com sucesso!";
    }
}
