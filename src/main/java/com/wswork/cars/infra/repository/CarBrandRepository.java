package com.wswork.cars.infra.repository;

import com.wswork.cars.infra.entities.CarBrandEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CarBrandRepository extends CrudRepository<CarBrandEntity, UUID> {
}
