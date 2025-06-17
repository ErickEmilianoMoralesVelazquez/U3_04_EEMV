package com.almacenes.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String clave;

    private LocalDate fechaRegistro;
    private Double precioVenta;
    private Double precioRenta;

    @Column(length = 1)
    private String tamano;

    @ManyToOne
    @JoinColumn(name = "sede_id")
    private Sede sede;
}