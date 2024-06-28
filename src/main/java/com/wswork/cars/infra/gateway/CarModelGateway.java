package com.wswork.cars.infra.gateway;

import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.infra.entities.CarEntity;
import com.wswork.cars.infra.entities.CarModelEntity;
import com.wswork.cars.infra.repository.CarModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service()
@AllArgsConstructor
public class CarModelGateway  implements  CrudGateway<CarModel>{

    CarModelRepository repository;

    @Override
    public CarModel create(CarModel data) {
        return null;
    }

    @Override
    public void delete(CarModel carModel) {

    }

    @Override
    public List<CarModel> loadAll() {
        return null;
    }

    @Override
    public Optional<CarModel> loadById(UUID id) {
        Optional<CarModelEntity> carEntity = repository.findById(id);
        return carEntity.map(CarModelEntity::toDomain);
    }

    @Override
    public CarModel update(CarModel data) {
        return null;
    }
}
