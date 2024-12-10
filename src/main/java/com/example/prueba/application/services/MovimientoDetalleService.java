package com.example.prueba.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.application.dtos.MovimientoDetalleRequestDTO;
import com.example.prueba.application.dtos.MovimientoDetalleResponseDTO;
import com.example.prueba.application.dtos.MovimientoResponseDTO;
import com.example.prueba.application.mappers.MovimientoMapper;
import com.example.prueba.domain.Movimiento;
import com.example.prueba.domain.MovimientoDetalle;
import com.example.prueba.infrastructure.repositories.MovimientoDetalleRepository;
import com.example.prueba.infrastructure.repositories.MovimientoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimientoDetalleService {

    @Autowired
    private MovimientoDetalleRepository movimientoDetalleRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private MovimientoMapper movimientoMapper;

        @Transactional(readOnly = true)
        public List<MovimientoDetalleResponseDTO> obtenerTodos() {
            return movimientoDetalleRepository.findAll().stream()
                .map(movimientoMapper::toResponseDTO)
                .collect(Collectors.toList());
        }

       public MovimientoDetalleResponseDTO createMovimientoDetalle( MovimientoDetalleRequestDTO requestDTO) {
        Movimiento movimiento = movimientoRepository.findById(requestDTO.getMovimientoId())
            .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        MovimientoDetalle detalle = movimientoMapper.toEntity(requestDTO);
        detalle.setMovimiento(movimiento);
        detalle = movimientoDetalleRepository.save(detalle);
        return movimientoMapper.toResponseDTO(detalle);
    }

    public MovimientoDetalleResponseDTO updateMovimientoDetalle( Long detalleId, MovimientoDetalleRequestDTO requestDTO) {
        Movimiento movimiento = movimientoRepository.findById(requestDTO.getMovimientoId())
            .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        MovimientoDetalle detalle = movimientoDetalleRepository.findById(detalleId)
            .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
        detalle.setItemCodigo(requestDTO.getItemCodigo());
        detalle.setCantidadEnviada(requestDTO.getCantidadEnviada());
        detalle.setMovimiento(movimiento);
        detalle = movimientoDetalleRepository.save(detalle);
        return movimientoMapper.toResponseDTO(detalle);
    }
    // Obtener un movimiento detalle por id
    public MovimientoDetalleResponseDTO getMovimientoDetalleById(Long id) {
        MovimientoDetalle detalle = movimientoDetalleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MovimientoDetalle no encontrado"));
        return movimientoMapper.toResponseDTO(detalle);
    }

    // Obtener detalles por estado
    public List<MovimientoDetalleResponseDTO> getDetallesByEstado(String estado) {
 
                List<MovimientoDetalle> detalles = movimientoDetalleRepository.findByEstadoEnMovimiento(estado); // O el método con @Query
                return detalles.stream()
                .map(movimientoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Obtener detalles por movimiento_id
    public List<MovimientoDetalleResponseDTO> getDetallesByMovimientoId(Long movimientoId) {
        List<MovimientoDetalle> detalles = movimientoDetalleRepository.findByMovimientoId(movimientoId);
        return detalles.stream()
                .map(movimientoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
