package com.wswork.cars.application.gateway;

public interface UpdateGateway<DomainEntity> extends LoadByIdGateway<DomainEntity> {
    public DomainEntity update(DomainEntity data);
}
