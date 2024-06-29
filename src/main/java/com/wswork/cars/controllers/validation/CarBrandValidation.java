package com.wswork.cars.controllers.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarBrandValidation {
    @NotNull(message = "o campo nome é obrigatorio!")
    @NotBlank(message = "o campo nome é obrigatorio!")
    public String nome;
}
