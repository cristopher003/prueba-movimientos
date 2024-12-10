package com.example.prueba.application.dtos;
import lombok.Data;

@Data
public class MovimientoDetalleResponseDTO {

    private Long id;

    private Long movimientoId;

    private String itemCodigo;

    private Integer cantidadEnviada;
}

