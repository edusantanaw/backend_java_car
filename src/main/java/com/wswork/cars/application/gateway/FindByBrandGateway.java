package com.wswork.cars.application.gateway;

import java.util.List;
import java.util.UUID;

public interface FindByBrandGateway<Entity> {
    public List<Entity> findByBrand(UUID id);
}
