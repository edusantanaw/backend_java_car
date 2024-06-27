package com.wswork.cars.infra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "modelo")
@Entity()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
public class CarModel {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    String nome;
    @Column(nullable = false)
    BigDecimal valor_fipe;
    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    CarBrand marca_id;
}

