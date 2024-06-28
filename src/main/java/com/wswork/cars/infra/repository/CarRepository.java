package com.wswork.cars.infra.repository;

import com.wswork.cars.infra.entities.CarEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CarRepository extends CrudRepository<CarEntity, UUID> {
    List<CarEntity> findByDeleted(Integer deleted);
}
