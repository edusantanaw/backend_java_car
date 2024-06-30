package com.wswork.cars.application.interactor.model;

import com.wswork.cars.application.dto.CarModelDto;
import com.wswork.cars.application.gateway.CreateGateway;
import com.wswork.cars.application.gateway.LoadByIdGateway;
import com.wswork.cars.domain.entities.CarBrand;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.domain.exceptions.EntityValidationException;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.Optional;

public class CreateCarModelInteractor {
    private final LoadByIdGateway<CarBrand> carBrandRepository;
    private final CreateGateway<CarModel> carModelRepository;

    public CreateCarModelInteractor(LoadByIdGateway<CarBrand> carBrandRepository, CreateGateway<CarModel> carModelRepository) {
        this.carBrandRepository = carBrandRepository;
        this.carModelRepository = carModelRepository;
    }

    public CarModel create(CarModelDto carModelDto) throws NotFoundException {
        Optional<CarBrand> carBrand = carBrandRepository.loadById(carModelDto.marca_id());
        if(carBrand.isEmpty()) throw new NotFoundException("Marca não encontrada!");
        CarModel carModel = new CarModel(null, carBrand.get(), carModelDto.nome(), carModelDto.valor_fipe());
        return carModelRepository.create(carModel);
    }
}
