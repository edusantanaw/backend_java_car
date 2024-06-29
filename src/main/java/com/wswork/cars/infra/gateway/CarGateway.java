package com.wswork.cars.infra.gateway;

import com.wswork.cars.application.gateway.FindByModeloGateway;
import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.infra.entities.CarEntity;
import com.wswork.cars.infra.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CarGateway implements  CrudGateway<Car>, FindByModeloGateway<Car> {
    private CarRepository repository;

    public Car create(Car data){
        CarEntity car = CarEntity.toPersistence(data);
        CarEntity created = repository.save(car);
        return CarEntity.toDomain(created);
    }

    @Override
    public Optional<Car> loadById(UUID id) {
        Optional<CarEntity> car = repository.findById(id);
        return car.map(CarEntity::toDomain);
    }

    @Override
    public void delete(Car data) {
        CarEntity entity = CarEntity.toPersistence(data);
        entity.setDeleted(1);
        repository.save(entity);
    }

    @Override
    public List<Car> loadAll() {
        List<CarEntity> cars = repository.findByDeleted(0);
        return cars.stream().map(CarEntity::toDomain).toList();
    }

    @Override
    public Car update(Car data) {
        CarEntity car = CarEntity.toPersistence(data);
        CarEntity updated = repository.save(car);
        return CarEntity.toDomain(updated);
    }

    public List<Car> findByModelo(UUID modelo_id) {
        List<CarEntity> cars = repository.findByModeloId(modelo_id);
        return cars.stream().map(CarEntity::toDomain).toList();
    }
}
