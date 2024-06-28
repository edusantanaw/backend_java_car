package com.wswork.cars.config;

import com.wswork.cars.application.interactor.car.CreateCarInteractor;
import com.wswork.cars.infra.gateway.CarGateway;
import com.wswork.cars.infra.gateway.CarModelGateway;
import com.wswork.cars.infra.repository.CarModelRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {
    @Bean
    CreateCarInteractor createCarInteractor(CarModelGateway carModelGateway, CarGateway carGateway){
        return new CreateCarInteractor(carModelGateway, carGateway);
    }
}
