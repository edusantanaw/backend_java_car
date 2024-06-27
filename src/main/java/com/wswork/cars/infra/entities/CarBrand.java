package com.wswork.cars.infra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name="marca")
@Entity()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
public class CarBrand {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column()
    String nome_marca;
}
