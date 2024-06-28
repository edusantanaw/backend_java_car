package com.wswork.cars.infra.entities;

import com.wswork.cars.domain.entities.Car;
import com.wswork.cars.domain.entities.CarModel;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp_cadastro")
    Date timestamp_cadastro;
    @ManyToOne()
    @JoinColumn(name = "modelo_id", nullable = false)
    CarModelEntity modelo;
    @Column()
    Integer deleted = 0;


    public static Car toDomain(CarEntity entity) {
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
                .id(domain.id())
                .modelo(CarModelEntity.toPersistence(domain.modelo()))
                .ano(domain.ano())
                .combustivel(domain.combustivel())
                .timestamp_cadastro(domain.timestamp_cadastro())
                .cor(domain.cor())
                .num_portas(domain.num_portas())
                .build();
    }
}
