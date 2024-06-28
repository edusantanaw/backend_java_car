package com.wswork.cars.infra.gateway;

import com.wswork.cars.application.gateway.*;

public interface CrudGateway<DomainEntity>
        extends CreateGateway<DomainEntity>,
        LoadByIdGateway<DomainEntity>,
        DeleteGateway<DomainEntity>,
        UpdateGateway<DomainEntity>,
        LoadAllGateway<DomainEntity> {
}
