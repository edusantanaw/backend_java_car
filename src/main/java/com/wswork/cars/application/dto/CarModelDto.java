package com.wswork.cars.application.dto;

import com.wswork.cars.domain.entities.CarBrand;

import java.math.BigDecimal;
import java.util.UUID;

public record CarModelDto(UUID marca_id, String nome, BigDecimal valor_fipe) {
}
