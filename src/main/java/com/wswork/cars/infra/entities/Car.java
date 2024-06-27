package com.wswork.cars.infra.entities;

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
public class Car {
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
    @JoinColumn(referencedColumnName = "id")
    CarModel modelo_id;
}
