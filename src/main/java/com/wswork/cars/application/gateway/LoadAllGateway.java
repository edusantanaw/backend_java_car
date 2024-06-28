package com.wswork.cars.application.gateway;

import java.util.List;

public interface LoadAllGateway<DomainEntity> {
    public List<DomainEntity> loadAll();
}
