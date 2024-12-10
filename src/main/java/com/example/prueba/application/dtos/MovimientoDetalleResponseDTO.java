package com.example.prueba.application.dtos;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovimientoDetalleResponseDTO {

    private Long id;

    private Long movimientoId;

    private String itemCodigo;

    private Integer cantidadEnviada;
}

