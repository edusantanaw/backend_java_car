package com.wswork.cars.application.gateway;

import java.util.Optional;
import java.util.UUID;

public interface LoadByIdGateway<Entity> {
    public abstract Optional<Entity> loadById(UUID id);
}
