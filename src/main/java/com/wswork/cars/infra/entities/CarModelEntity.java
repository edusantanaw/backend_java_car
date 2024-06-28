package com.wswork.cars.infra.entities;

import com.wswork.cars.domain.entities.CarModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Table(name = "modelo")
@Entity()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
public class CarModelEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    String nome;
    @Column(nullable = false)
    BigDecimal valor_fipe;
    @ManyToOne()
    @JoinColumn(name = "marca_id", nullable = false)
    CarBrandEntity marca;
    @Column()
    Integer deleted = 0;

    @OneToMany(mappedBy = "modelo")
    List<CarEntity> cars;

    public static CarModel toDomain(CarModelEntity entity) {
        return new CarModel(
                entity.id,
                CarBrandEntity.toDomain(entity.marca),
                entity.nome,
                entity.valor_fipe
        );
    }

    public static CarModelEntity toPersistence(CarModel domain) {
        return CarModelEntity.builder()
                .nome(domain.nome())
                .id(domain.id())
                .valor_fipe(domain.valor_fipe())
                .build();
    }
}

