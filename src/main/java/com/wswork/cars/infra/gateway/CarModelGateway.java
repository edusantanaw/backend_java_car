package com.wswork.cars.infra.gateway;

import com.wswork.cars.application.gateway.FindByBrandGateway;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.infra.entities.CarModelEntity;
import com.wswork.cars.infra.repository.CarModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service()
@AllArgsConstructor
public class CarModelGateway implements CrudGateway<CarModel>, FindByBrandGateway<CarModel> {

    CarModelRepository repository;

    @Override
    public CarModel create(CarModel data) {
        CarModelEntity carModel = CarModelEntity.toPersistence(data);
        carModel.setDeleted(0);
        CarModelEntity createCarModel = repository.save(carModel);
        return CarModelEntity.toDomain(createCarModel);
    }

    @Override
    public void delete(CarModel carModel) {
        CarModelEntity carModelEntity = CarModelEntity.toPersistence(carModel);
        carModelEntity.setDeleted(1);
        repository.save(carModelEntity);
    }

    @Override
    public List<CarModel> loadAll() {
        List<CarModelEntity> carModel = repository.findByDeleted(0);
        return carModel.stream().map(CarModelEntity::toDomain).toList();
    }

    @Override
    public Optional<CarModel> loadById(UUID id) {
        Optional<CarModelEntity> carEntity = repository.findById(id);
        return carEntity.map(CarModelEntity::toDomain);
    }

    @Override
    public CarModel update(CarModel data) {
        CarModelEntity carModel = CarModelEntity.toPersistence(data);
        CarModelEntity carModelEntityUpdated = repository.save(carModel);
        return CarModelEntity.toDomain(carModelEntityUpdated);
    }

    public List<CarModel> findByBrand(UUID id) {
        List<CarModelEntity> carModelEntities = repository.findByMarcaId(id);
        return  carModelEntities.stream().map(CarModelEntity::toDomain).toList();
    }
}
