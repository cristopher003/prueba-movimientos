package com.example.prueba.application.mappers;


import com.example.prueba.application.dtos.MovimientoRequestDTO;
import com.example.prueba.application.dtos.MovimientoResponseDTO;
import com.example.prueba.domain.Movimiento;
import com.example.prueba.domain.MovimientoDetalle;
import com.example.prueba.infrastructure.repositories.MovimientoRepository;
import com.example.prueba.application.dtos.MovimientoDetalleRequestDTO;
import com.example.prueba.application.dtos.MovimientoDetalleResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovimientoMapper {

     @Autowired
    private MovimientoRepository movimientoRepository
    ;
    // Método para convertir de MovimientoRequestDTO a Movimiento
    public Movimiento toEntity(MovimientoRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        Movimiento movimiento = new Movimiento();
        // Mapear los campos manualmente
        // movimiento.setId(requestDTO.getId());
        movimiento.setIdEmpresa(requestDTO.getIdEmpresa());
        movimiento.setDescripcion(requestDTO.getDescripcion());
        movimiento.setBodegaOrigenCodigo(requestDTO.getBodegaOrigenCodigo());
        movimiento.setBodegaDestinoCodigo(requestDTO.getBodegaDestinoCodigo());
        movimiento.setFechaCreacion(requestDTO.getFechaCreacion());
        movimiento.setFechaEntrega(requestDTO.getFechaEntrega());
        movimiento.setEstado(requestDTO.getEstado() != null ? requestDTO.getEstado() : "P"); // Valor por defecto "P"
        return movimiento;
    }

    // Método para convertir de Movimiento a MovimientoResponseDTO
    public MovimientoResponseDTO toResponseDTO(Movimiento movimiento) {
        if (movimiento == null) {
            return null;
        }
        MovimientoResponseDTO responseDTO = new MovimientoResponseDTO();
        // Mapear los campos manualmente
        responseDTO.setId(movimiento.getId());
        responseDTO.setIdEmpresa(movimiento.getIdEmpresa());
        responseDTO.setDescripcion(movimiento.getDescripcion());
        responseDTO.setBodegaOrigenCodigo(movimiento.getBodegaOrigenCodigo());
        responseDTO.setBodegaDestinoCodigo(movimiento.getBodegaDestinoCodigo());
        responseDTO.setFechaCreacion(movimiento.getFechaCreacion());
        responseDTO.setFechaEntrega(movimiento.getFechaEntrega());
        responseDTO.setEstado(movimiento.getEstado());
        responseDTO.setDetalles(toDetalleResponseDTOList(movimiento.getDetalles()));
        return responseDTO;
    }

    // Método para convertir de MovimientoDetalleRequestDTO a MovimientoDetalle
    public MovimientoDetalle toEntity(MovimientoDetalleRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        MovimientoDetalle detalle = new MovimientoDetalle();
        Movimiento movimiento = movimientoRepository.findById(requestDTO.getMovimientoId())
        .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        // Mapear los campos manualmente
        // detalle.setId(requestDTO.getId());
        detalle.setMovimiento(movimiento);
        detalle.setItemCodigo(requestDTO.getItemCodigo());
        detalle.setCantidadEnviada(requestDTO.getCantidadEnviada());
        return detalle;
    }

    // Método para convertir de MovimientoDetalle a MovimientoDetalleResponseDTO
    public MovimientoDetalleResponseDTO toResponseDTO(MovimientoDetalle detalle) {
        if (detalle == null) {
            return null;
        }
        MovimientoDetalleResponseDTO responseDTO = new MovimientoDetalleResponseDTO();
        // Mapear los campos manualmente
        responseDTO.setId(detalle.getId());
        responseDTO.setMovimientoId(detalle.getMovimiento().getId());
        responseDTO.setItemCodigo(detalle.getItemCodigo());
        responseDTO.setCantidadEnviada(detalle.getCantidadEnviada());
        return responseDTO;
    }

    // Método para convertir de lista de Movimiento a lista de MovimientoResponseDTO
    public List<MovimientoResponseDTO> toResponseDTOList(List<Movimiento> movimientos) {
        if (movimientos == null) {
            return null;
        }
        return movimientos.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Método para convertir de lista de MovimientoDetalle a lista de MovimientoDetalleResponseDTO
    public List<MovimientoDetalleResponseDTO> toDetalleResponseDTOList(List<MovimientoDetalle> detalles) {
        if (detalles == null) {
            return null;
        }
        return detalles.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}

