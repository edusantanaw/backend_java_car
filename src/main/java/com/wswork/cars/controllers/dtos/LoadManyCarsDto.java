package com.wswork.cars.controllers.dtos;

import com.wswork.cars.domain.entities.Car;

import java.util.List;

public class LoadManyCarsDto {
    public List<CarResponseDto> cars;
    public LoadManyCarsDto(List<Car> carsList) {
        cars = carsList.stream().map(CarResponseDto::new).toList();
    }
}
