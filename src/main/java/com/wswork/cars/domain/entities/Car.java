package com.wswork.cars.domain.entities;

import com.wswork.cars.domain.enums.Fuel;
import com.wswork.cars.domain.exceptions.EntityValidationException;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.UUID;

public record Car(CarModel modelo, Integer ano, String cor, Integer num_portas, String combustivel, UUID id,
                  Date timestamp_cadastro) {
    @SneakyThrows()
    public Car {
        if (ano <= 1870) throw new EntityValidationException("O ano deve ser maior que 1870!");
        boolean isFuelValid = Fuel.have(combustivel);
        if (!isFuelValid) throw new EntityValidationException("O tipo de combustivel é invalido!");
        combustivel = combustivel.toUpperCase();
    }
}
