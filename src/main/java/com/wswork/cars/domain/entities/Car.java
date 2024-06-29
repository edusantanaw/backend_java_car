package com.wswork.cars.domain.entities;

import com.wswork.cars.domain.enums.Fuel;
import com.wswork.cars.domain.exceptions.EntityValidationException;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class Car {
    CarModel modelo;
    Integer ano;
    String cor;
    Integer num_portas;
    String combustivel;
    UUID id;
    Date timestamp_cadastro;

    @SneakyThrows()
    public Car(CarModel modelo, Integer ano, String cor, Integer num_portas, String combustivel, UUID id,
               Date timestamp_cadastro) {
        if (ano <= 1870) throw new EntityValidationException("O ano deve ser maior que 1870!");
        boolean isFuelValid = Fuel.have(combustivel);
        if (!isFuelValid) throw new EntityValidationException("O tipo de combustivel é invalido!");
        this.combustivel = combustivel.toUpperCase();
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.num_portas = num_portas;
        this.id = id;
        this.timestamp_cadastro = timestamp_cadastro;
    }
}
