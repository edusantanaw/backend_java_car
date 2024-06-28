package com.wswork.cars.infra.entities;

import com.wswork.cars.domain.entities.CarBrand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Table(name = "marca")
@Entity()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
public class CarBrandEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column()
    String nome_marca;
    @Column()
    Integer deleted = 0;
    @OneToMany()
    List<CarModelEntity> carModels;

    public static CarBrand toDomain(CarBrandEntity entity) {
        return new CarBrand(entity.id, entity.nome_marca);
    }

    public static CarBrandEntity toPersistence(CarBrand domain) {
        return CarBrandEntity.builder().id(domain.id()).nome_marca(domain.nome_marca()).build();
    }
}
