package com.wswork.cars.controllers.dtos;

import com.wswork.cars.domain.entities.CarBrand;

import java.util.List;

public class LoadManyCarBrandsDto {
    List<CarBrand> brands;
    public LoadManyCarBrandsDto(List<CarBrand> list){
        brands = list;
    }
}
