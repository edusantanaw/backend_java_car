package com.wswork.cars.config;

import com.wswork.cars.application.interactor.model.*;
import com.wswork.cars.infra.gateway.CarBrandGateway;
import com.wswork.cars.infra.gateway.CarGateway;
import com.wswork.cars.infra.gateway.CarModelGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarModelConfig {
    @Bean
    CreateCarModelInteractor createCarModelInteractor(CarBrandGateway carBrandRepository, CarModelGateway carModelRepository) {
        return new CreateCarModelInteractor(carBrandRepository, carModelRepository);
    }

    @Bean
    LoadCarModelByIdInteractor loadCarModelByIdInteractor(CarModelGateway carModelGateway) {
        return new LoadCarModelByIdInteractor(carModelGateway);
    }

    @Bean
    LoadAllCarModelInteractor loadAllCarModelInteractor(CarModelGateway carModelGateway) {
        return new LoadAllCarModelInteractor(carModelGateway);
    }

    @Bean
    DeleteCarModelInteractor deleteCarModelInteractor(CarModelGateway carModelGateway, CarGateway carGateway) {
        return new DeleteCarModelInteractor(carModelGateway, carGateway);
    }

    @Bean
    UpdateCarModelInteractor updateCarModelInteractor(CarModelGateway carModelGateway) {
        return new UpdateCarModelInteractor(carModelGateway);
    }
}
