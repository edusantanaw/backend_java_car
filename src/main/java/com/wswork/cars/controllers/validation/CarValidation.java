package com.wswork.cars.controllers.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CarValidation {
    @NotNull(message = "O modelo_id é obrigatorio!")
    public UUID modelo_id;
    @NotNull(message = "O capo ano é obrigatorio!")
    public Integer ano;
    @NotNull(message = "o campo cor é obrigatoria!")
    @NotBlank(message = "o campo cor é obrigatoria!")
    public String cor;
    @NotNull(message = "O campo num_portas é obrigatorio!")
    public Integer num_portas;
    @NotNull(message = "O campo combustivel é obrigatorio!")
    @NotBlank(message = "O campo combustivel é obrigatorio!")
    public String combustivel;
}
