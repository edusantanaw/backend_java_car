package com.wswork.cars.domain.entities;

import com.wswork.cars.domain.exceptions.EntityValidationException;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.util.UUID;

public record CarModel(UUID id, CarBrand marca_id, String nome, BigDecimal valor_fipe) {
    @SneakyThrows()
    public CarModel {
        if (valor_fipe.floatValue() <= 0) throw new EntityValidationException("O valor fipe deve ser maior que 0");
    }
}
