package com.example.prueba.application.mappers;
import java.util.List;

import org.mapstruct.*;

import com.example.prueba.application.dtos.MovimientoDetalleRequestDTO;
import com.example.prueba.application.dtos.MovimientoDetalleResponseDTO;
import com.example.prueba.application.dtos.MovimientoRequestDTO;
import com.example.prueba.application.dtos.MovimientoResponseDTO;
import com.example.prueba.domain.Movimiento;
import com.example.prueba.domain.MovimientoDetalle;

@Mapper(componentModel = "spring")
public interface MovimientoMapperC {

    // Movimiento mappers
    Movimiento toEntity(MovimientoRequestDTO requestDTO);
    MovimientoResponseDTO toResponseDTO(Movimiento movimiento);

    // MovimientoDetalle mappers
    MovimientoDetalle toEntity(MovimientoDetalleRequestDTO requestDTO);
    MovimientoDetalleResponseDTO toResponseDTO(MovimientoDetalle detalle);

    // List mappers
    List<MovimientoResponseDTO> toResponseDTOList(List<Movimiento> movimientos);
    List<MovimientoDetalleResponseDTO> toDetalleResponseDTOList(List<MovimientoDetalle> detalles);

    // Métodos custom si es necesario
    default String mapEstado(String estado) {
        if (estado == null) {
            return "P"; // Estado por defecto
        }
        return estado;
    }
}
