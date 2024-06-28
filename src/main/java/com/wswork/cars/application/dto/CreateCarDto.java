package com.wswork.cars.application.dto;

import com.wswork.cars.domain.entities.CarModel;

import java.util.Date;
import java.util.UUID;

public record CreateCarDto(UUID modelo_id, Integer ano, String cor, Integer num_portas, String combustivel) {
}
