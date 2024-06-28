package com.wswork.cars.application.usecases.car;

import com.wswork.cars.application.dto.CreateCarDto;
import com.wswork.cars.application.gateway.CreateGateway;
import com.wswork.cars.application.gateway.LoadByIdGateway;
import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.domain.exceptions.NotFoundException;

import java.util.Optional;

public class CreateCarInteractor {
    private final LoadByIdGateway<CarModel> carModelGateway;
    private final CreateGateway<Car> carGateway;

    public CreateCarInteractor(LoadByIdGateway<CarModel> carModelGateway, CreateGateway<Car> carGateway) {
        this.carModelGateway = carModelGateway;
        this.carGateway = carGateway;
    }

    public Car create(CreateCarDto data) throws NotFoundException {
        Optional<CarModel> carModel = carModelGateway.loadById(data.modelo_id());
        if(carModel.isEmpty()) throw new NotFoundException("Modelo de carro não encontrado!");
        Car car = carGateway.create(new Car(
                carModel.get(),
                data.ano(),
                data.cor(),
                data.num_portas(),
                data.combustivel(),
                null, null
        ));
        return car;
    }
}
