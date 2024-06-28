package com.wswork.cars.infra.repository;

import com.wswork.cars.infra.entities.CarModelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CarModelRepository extends CrudRepository<CarModelEntity, UUID> {
}
