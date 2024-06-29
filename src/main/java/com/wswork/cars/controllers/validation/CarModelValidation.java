package com.wswork.cars.controllers.validation;

import com.wswork.cars.domain.entities.CarBrand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public class CarModelValidation {
    @NotNull(message = "O campo marca_id é obrigatorio!")
    public UUID marca_id;
    @NotNull(message = "O campo nome é obrigatorio!")
    @NotBlank(message = "O campo nome é obrigatorio!")
    public String nome;
    @NotNull(message = "o campo valor_fipe é obrigatorio!")
    public BigDecimal valor_fipe;
}
