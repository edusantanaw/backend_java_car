package com.wswork.cars;

import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.entities.CarBrand;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.domain.exceptions.EntityValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
class CarDomainEntityTests {

    @Test()
    @DisplayName("Should throw an exception if the field 'ano' is less or equal 1870!")
    void createCarModelYearExceptionTest() {
        CarBrand carBrand = new CarBrand(UUID.randomUUID(), "test");
        CarModel carModel = new CarModel(UUID.randomUUID(), carBrand, "test", BigDecimal.valueOf(1000));
        EntityValidationException exception = Assertions.assertThrowsExactly(
                EntityValidationException.class,
                () ->
                        new Car(carModel, 1800, "#c3c3c3", 4, "DIESEL", UUID.randomUUID(), null)
        );
        Assertions.assertEquals("O ano deve ser maior que 1870!", exception.getMessage());
    }

    @Test()
    @DisplayName("Should throw if the fuel is not DIESEL or FLEX!")
    void createCarFuelTypeValidModel() {
        CarBrand carBrand = new CarBrand(UUID.randomUUID(), "test");
        CarModel carModel = new CarModel(UUID.randomUUID(), carBrand, "test", BigDecimal.valueOf(1000));
        EntityValidationException exception = Assertions.assertThrowsExactly(
                EntityValidationException.class,
                () ->
                        new Car(carModel, 1900, "#c3c3c3", 4, "fuel", UUID.randomUUID(), null)
        );
        Assertions.assertEquals("O tipo de combustivel é invalido!", exception.getMessage());
    }

    @Test()
    @DisplayName("Should create the car successfully and transform the field 'combustivel' to uppercase!")
    void createCarSuccessfully() {
        CarBrand carBrand = new CarBrand(UUID.randomUUID(), "test");
        CarModel carModel = new CarModel(UUID.randomUUID(), carBrand, "test", BigDecimal.valueOf(1000));
        Car car = new Car(carModel, 1900, "#c3c3c3", 4, "diesel", UUID.randomUUID(), null);
        Assertions.assertEquals(car.getAno(), 1900);
        Assertions.assertEquals(car.getCombustivel(), "DIESEL");
    }
}
