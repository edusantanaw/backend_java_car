package com.wswork.cars.infra.gateway;

import com.wswork.cars.application.gateway.FindByBrandGateway;
import com.wswork.cars.domain.entities.CarBrand;
import com.wswork.cars.infra.entities.CarBrandEntity;
import com.wswork.cars.infra.repository.CarBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CarBrandGateway implements CrudGateway<CarBrand> {
    private final CarBrandRepository repository;

    @Override
    public CarBrand create(CarBrand data) {
        CarBrandEntity carEntity = CarBrandEntity.toPersistence(data);
        CarBrandEntity createdCar = repository.save(carEntity);
        return CarBrandEntity.toDomain(createdCar);
    }

    @Override
    public void delete(CarBrand carBrand) {
        CarBrandEntity carBrandEntity = CarBrandEntity.toPersistence(carBrand);
        carBrandEntity.setDeleted(1);
        repository.save(carBrandEntity);
    }

    @Override
    public List<CarBrand> loadAll() {
        List<CarBrandEntity> carBrands = repository.findByDeleted(0);
        return carBrands.stream().map(CarBrandEntity::toDomain).toList();
    }

    @Override
    public Optional<CarBrand> loadById(UUID id) {
        Optional<CarBrandEntity> carBrand = repository.findById(id);
        return carBrand.map(CarBrandEntity::toDomain);
    }

    @Override
    public CarBrand update(CarBrand data) {
        CarBrandEntity carBrand = CarBrandEntity.toPersistence(data);
        CarBrandEntity updated = repository.save(carBrand);
        return CarBrandEntity.toDomain(updated);
    }
}
