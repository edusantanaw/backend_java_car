package com.wswork.cars.infra.repository;

import com.wswork.cars.infra.entities.CarModelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CarModelRepository extends CrudRepository<CarModelEntity, UUID> {
}
