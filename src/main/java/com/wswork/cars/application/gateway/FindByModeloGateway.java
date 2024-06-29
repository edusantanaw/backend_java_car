package com.wswork.cars.application.gateway;

import java.util.List;
import java.util.UUID;

public interface FindByModeloGateway <DomainEntity>{
    List<DomainEntity> findByModelo(UUID modelo);
}
