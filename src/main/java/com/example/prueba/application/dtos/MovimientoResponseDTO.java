package com.example.prueba.application.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class MovimientoResponseDTO {

    private Long id;

    private Long idEmpresa;

    private String descripcion;

    private String bodegaOrigenCodigo;

    private String bodegaDestinoCodigo;

    private LocalDate fechaCreacion;

    private LocalDate fechaEntrega;

    private String estado;

    private List<MovimientoDetalleResponseDTO> detalles;
}

