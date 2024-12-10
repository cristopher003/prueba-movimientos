package com.example.prueba.application.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovimientoRequestDTO {

    @NotNull(message = "El id de la empresa no puede ser nulo.")
    private Long idEmpresa;

    @NotBlank(message = "La descripción no puede estar vacía.")
    private String descripcion;

    @NotBlank(message = "El código de la bodega de origen no puede estar vacío.")
    @Size(max = 20, message = "El código de la bodega de origen no puede superar los 20 caracteres.")
    private String bodegaOrigenCodigo;

    @NotBlank(message = "El código de la bodega de destino no puede estar vacío.")
    @Size(max = 20, message = "El código de la bodega de destino no puede superar los 20 caracteres.")
    private String bodegaDestinoCodigo;

    @NotNull(message = "La fecha de creación no puede ser nula.")
    private LocalDate fechaCreacion;

    @FutureOrPresent(message = "La fecha de entrega debe ser en el presente o en el futuro.")
    private LocalDate fechaEntrega;

    @NotBlank(message = "El estado no puede estar vacío.")
    @Pattern(regexp = "P|T|E", message = "El estado debe ser 'P' (Pendiente), 'T' (Tránsito) o 'E' (Entregado).")
    @Column(name = "estado", nullable = false, length = 1)
    private String estado = "P";

    private List<MovimientoDetalleRequestDTO> detalles;
}

