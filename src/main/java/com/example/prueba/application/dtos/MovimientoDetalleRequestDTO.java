package com.example.prueba.application.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MovimientoDetalleRequestDTO {

    @NotNull(message = "El ID del movimiento no puede ser nulo.")
    private Long movimientoId;

    @NotBlank(message = "El código del ítem no puede estar vacío.")
    @Size(max = 20, message = "El código del ítem no puede superar los 20 caracteres.")
    private String itemCodigo;

    @NotNull(message = "La cantidad enviada no puede ser nula.")
    @Positive(message = "La cantidad enviada debe ser mayor a cero.")
    private Integer cantidadEnviada;
}

