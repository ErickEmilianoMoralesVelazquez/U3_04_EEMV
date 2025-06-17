package com.almacenes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClienteDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombreCompleto;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 10, max = 15)
    private String telefono;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo no es válido")
    private String correoElectronico;
}
