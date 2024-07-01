package com.wswork.cars.infra.entities;

import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.entities.CarModel;
import com.wswork.cars.domain.exceptions.EntityValidationException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Table(name = "carro")
@Entity()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
public class CarEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    Integer ano;
    @Column(nullable = false)
    String cor;
    @Column(nullable = false)
    String combustivel;
    @Column(nullable = false)
    Integer num_portas;
    @Column(name = "timestamp_cadastro", updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    Date timestamp_cadastro;
    @ManyToOne()
    @JoinColumn(name = "modelo_id", nullable = false)
    CarModelEntity modelo;
    @Column(columnDefinition = "integer default 0")
    Integer deleted = 0;


    public static Car toDomain(CarEntity entity)  {
        return new Car(
                CarModelEntity.toDomain(entity.modelo),
                entity.ano,
                entity.cor,
                entity.num_portas,
                entity.combustivel,
                entity.id,
                entity.timestamp_cadastro
        );
    }

    public static CarEntity toPersistence(Car domain){
        return CarEntity.builder()
                .id(domain.getId())
                .modelo(CarModelEntity.toPersistence(domain.getModelo()))
                .ano(domain.getAno())
                .combustivel(domain.getCombustivel())
                .cor(domain.getCor())
                .num_portas(domain.getNum_portas())
                .timestamp_cadastro(new Date())
                .deleted(0)
                .build();
    }
}
