package com.wswork.cars.infra.gateway;

public interface CrudGateway<DomainEntity> {
    public abstract DomainEntity  create(DomainEntity data);
}
