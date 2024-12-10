package com.example.prueba.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MovimientoDetallesCustomDTO {

    private Long movimientoId;
    private Long movimientoDetalleId;
    private String bodegaOrigenCodigo;
    private Long empresaId;
    private String bodegaDestinoCodigo;
    private Long itemId;


}
