package com.wswork.cars.infra.repository;

import com.wswork.cars.infra.entities.CarEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CarRepository extends CrudRepository<CarEntity, UUID> {
}
