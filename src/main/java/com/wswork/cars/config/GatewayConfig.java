package com.wswork.cars.config;

import com.wswork.cars.infra.gateway.CarGateway;
import com.wswork.cars.infra.gateway.CarModelGateway;
import com.wswork.cars.infra.repository.CarModelRepository;
import com.wswork.cars.infra.repository.CarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    CarModelGateway carModelGateway(CarModelRepository repository){
        return new CarModelGateway(repository);
    }

    @Bean
    CarGateway carGateway(CarRepository repository){
        return  new CarGateway(repository);
    }
}
