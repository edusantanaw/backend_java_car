package com.wswork.cars.config;

import com.wswork.cars.application.interactor.brand.*;
import com.wswork.cars.infra.gateway.CarBrandGateway;
import com.wswork.cars.infra.gateway.CarModelGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarBrandConfig {
    @Bean
    CreateCarBrandInteractor createCarBrandInteractor(CarBrandGateway carBrandGateway){
        return new CreateCarBrandInteractor(carBrandGateway);
    }

    @Bean
    LoadCarBrandByIdInteractor loadCarBrandByIdInteractor(CarBrandGateway carBrandGateway){
        return new LoadCarBrandByIdInteractor(carBrandGateway);
    }

    @Bean
    LoadAllCarBrandInteractor loadAllCarBrandInteractor(CarBrandGateway carBrandGateway){
        return new LoadAllCarBrandInteractor(carBrandGateway);
    }
    @Bean
    DeleteCarBrandInteractor deleteCarBrandInteractor(CarBrandGateway carBrandGateway, CarModelGateway carModelGateway){
        return new DeleteCarBrandInteractor(carBrandGateway, carModelGateway);
    }

    @Bean
    UpdateCarBrandInteractor updateCarBrandInteractor(CarBrandGateway carBrandGateway) {
        return new UpdateCarBrandInteractor(carBrandGateway);
    }
}
