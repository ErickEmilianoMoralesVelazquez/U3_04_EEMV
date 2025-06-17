package com.almacenes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombreCompleto;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 10, max = 15)
    private String telefono;

    @NotBlank(message = "El correo es obligatorio")
//    @Email(message = "El correo no es válido")
    private String correoElectronico;
}
