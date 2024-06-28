package com.wswork.cars.application.dto;

import java.util.UUID;

public record UpdateCorDto (UUID modelo_id, Integer ano, String cor, Integer num_portas, String combustivel, UUID id){
}
