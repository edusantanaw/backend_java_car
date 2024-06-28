package com.wswork.cars.config;

import com.wswork.cars.application.interactor.car.*;
import com.wswork.cars.infra.gateway.CarGateway;
import com.wswork.cars.infra.gateway.CarModelGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {
    @Bean
    CreateCarInteractor createCarInteractor(CarModelGateway carModelGateway, CarGateway carGateway) {
        return new CreateCarInteractor(carModelGateway, carGateway);
    }

    @Bean
    LoadCarByIdInteractor loadCarByIdInteractor(CarGateway carGateway) {
        return new LoadCarByIdInteractor(carGateway);
    }

    @Bean
    DeleteCarInteractor deleteCarInteractor(CarGateway carGateway) {
        return new DeleteCarInteractor(carGateway);
    }

    @Bean
    UpdateCarInteractor updateCarInteractor(CarGateway carGateway) {
        return new UpdateCarInteractor(carGateway);
    }

    @Bean
    LoadAllCarInteractor loadAllCarInteractor(CarGateway carGateway) {
        return new LoadAllCarInteractor(carGateway);
    }
}
