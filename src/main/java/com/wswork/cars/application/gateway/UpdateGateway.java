package com.wswork.cars.application.gateway;

public interface UpdateGateway<DomainEntity> {
    public DomainEntity update(DomainEntity data);
}
