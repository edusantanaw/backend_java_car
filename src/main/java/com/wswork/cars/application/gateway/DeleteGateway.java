package com.wswork.cars.application.gateway;

import java.util.UUID;

public interface DeleteGateway<DomainEntity> extends  LoadByIdGateway<DomainEntity> {
    public void delete(DomainEntity entity);
}
