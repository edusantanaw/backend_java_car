package com.wswork.cars.controllers.dtos;

import com.wswork.cars.domain.entities.CarModel;

import java.util.List;

public class LoadManyCarModelsDto {
    public List<CarModel> models;

    public LoadManyCarModelsDto(List<CarModel> models) {
        this.models = models;
    }
}
