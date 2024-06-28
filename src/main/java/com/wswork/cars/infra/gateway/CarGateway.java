package com.wswork.cars.infra.gateway;

import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.infra.entities.CarEntity;
import com.wswork.cars.infra.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class CarGateway implements  CrudGateway<Car> {
    @Autowired
    private CarRepository repository;

    public Car create(Car data){
        CarEntity car = CarEntity.toPersistence(data);
        CarEntity created = repository.save(car);
        return CarEntity.toDomain(created);
    }
}
