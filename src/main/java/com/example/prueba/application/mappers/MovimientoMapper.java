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
    private MovimientoRepository movimientoRepository;

    // convertir de MovimientoRequestDTO a Movimiento
    public Movimiento toEntity(MovimientoRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        Movimiento movimiento = new Movimiento();
   
        movimiento.setIdEmpresa(requestDTO.getIdEmpresa());
        movimiento.setDescripcion(requestDTO.getDescripcion());
        movimiento.setBodegaOrigenCodigo(requestDTO.getBodegaOrigenCodigo());
        movimiento.setBodegaDestinoCodigo(requestDTO.getBodegaDestinoCodigo());
        movimiento.setFechaCreacion(requestDTO.getFechaCreacion());
        movimiento.setFechaEntrega(requestDTO.getFechaEntrega());
        movimiento.setEstado(requestDTO.getEstado() != null ? requestDTO.getEstado() : "P"); // Valor por defecto "P"
        return movimiento;
    }

    // convertir de Movimiento a MovimientoResponseDTO
    public MovimientoResponseDTO toResponseDTO(Movimiento movimiento) {
        if (movimiento == null) {
            return null;
        }

          return MovimientoResponseDTO.builder()
            .id(movimiento.getId())
            .idEmpresa(movimiento.getIdEmpresa())
            .descripcion(movimiento.getDescripcion())
            .bodegaOrigenCodigo(movimiento.getBodegaOrigenCodigo())
            .bodegaDestinoCodigo(movimiento.getBodegaDestinoCodigo())
            .fechaCreacion(movimiento.getFechaCreacion())
            .fechaEntrega(movimiento.getFechaEntrega())
            .estado(movimiento.getEstado())
            .detalles(toDetalleResponseDTOList(movimiento.getDetalles()))
            .build();

    }

    // convertir de MovimientoDetalleRequestDTO a MovimientoDetalle
    public MovimientoDetalle toEntity(MovimientoDetalleRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }
        MovimientoDetalle detalle = new MovimientoDetalle();
        if (requestDTO.getMovimientoId()!=null) {
            Movimiento movimiento = movimientoRepository.findById(requestDTO.getMovimientoId())
            .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
            detalle.setMovimiento(movimiento);
        }
       
        detalle.setItemCodigo(requestDTO.getItemCodigo());
        detalle.setCantidadEnviada(requestDTO.getCantidadEnviada());
        return detalle;
    }

    //convertir de MovimientoDetalle a MovimientoDetalleResponseDTO
    public MovimientoDetalleResponseDTO toResponseDTO(MovimientoDetalle detalle) {
        if (detalle == null) {
            return null;
        }

        return MovimientoDetalleResponseDTO.builder()
        .id(detalle.getId())
        .movimientoId(detalle.getMovimiento().getId())
        .itemCodigo(detalle.getItemCodigo())
        .cantidadEnviada(detalle.getCantidadEnviada()).build();
        
    }

    // convertir de lista de Movimiento a lista de MovimientoResponseDTO
    public List<MovimientoResponseDTO> toResponseDTOList(List<Movimiento> movimientos) {
        if (movimientos == null) {
            return null;
        }
        return movimientos.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    //  convertir de lista de MovimientoDetalle a lista de MovimientoDetalleResponseDTO
    public List<MovimientoDetalleResponseDTO> toDetalleResponseDTOList(List<MovimientoDetalle> detalles) {
        if (detalles == null) {
            return null;
        }
        return detalles.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}

