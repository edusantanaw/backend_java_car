package com.wswork.cars.controllers.dtos;

import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.entities.CarModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class CarResponseDto {
    public UUID modelo_id;
    public Integer ano;
    public String cor;
    public Integer num_portas;
    public String combustivel;
    public UUID id;
    public Date timestamp_cadastro;
    public String nome_modelo;
    public BigDecimal valor;
    public UUID marca_id;
    public CarResponseDto(Car car){
        modelo_id = car.getModelo().id();
        ano = car.getAno();
        cor = car.getCor();
        num_portas = car.getNum_portas();
        combustivel = car.getCombustivel();
        timestamp_cadastro = car.getTimestamp_cadastro();
        nome_modelo = car.getModelo().nome();
        valor = car.getModelo().valor_fipe();
        marca_id = car.getModelo().marca_id().id();
        id = car.getId();
    }
}
