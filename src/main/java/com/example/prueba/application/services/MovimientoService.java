package com.example.prueba.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.application.dtos.MovimientoConDetallesDTO;
import com.example.prueba.application.dtos.MovimientoDetalleResponseDTO;
import com.example.prueba.application.dtos.MovimientoRequestDTO;
import com.example.prueba.application.dtos.MovimientoResponseDTO;
import com.example.prueba.application.mappers.MovimientoMapper;
import com.example.prueba.domain.Movimiento;
import com.example.prueba.domain.MovimientoDetalle;
import com.example.prueba.infrastructure.repositories.MovimientoDetalleRepository;
import com.example.prueba.infrastructure.repositories.MovimientoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private MovimientoDetalleRepository movimientoDetalleRepository;

    @Autowired
    private MovimientoMapper movimientoMapper;

    // Crear un movimiento con detalles
    public MovimientoResponseDTO saveMovimiento(MovimientoRequestDTO movimientoDTO) {
        Movimiento movimiento = movimientoMapper.toEntity(movimientoDTO);
        Movimiento savedMovimiento = movimientoRepository.save(movimiento);
        List<MovimientoDetalle> detalles = movimientoDTO.getDetalles().stream()
                .map(movimientoMapper::toEntity)
                .collect(Collectors.toList());
        detalles.forEach(detalle -> detalle.setMovimiento(savedMovimiento));
        movimientoDetalleRepository.saveAll(detalles);
        return movimientoMapper.toResponseDTO(savedMovimiento);
    }

    public MovimientoResponseDTO updateMovimiento(Long movimientoId, MovimientoRequestDTO requestDTO) {
        Movimiento movimiento = movimientoRepository.findById(movimientoId)
            .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        movimiento.setDescripcion(requestDTO.getDescripcion());
        movimiento.setIdEmpresa(requestDTO.getIdEmpresa());
        movimiento.setBodegaOrigenCodigo(requestDTO.getBodegaOrigenCodigo());
        movimiento.setBodegaDestinoCodigo(requestDTO.getBodegaDestinoCodigo());
        movimiento.setFechaCreacion(requestDTO.getFechaCreacion());
        movimiento.setFechaEntrega(requestDTO.getFechaEntrega());
        movimiento.setEstado(requestDTO.getEstado());
        movimiento = movimientoRepository.save(movimiento);
        return movimientoMapper.toResponseDTO(movimiento);
    }

    public MovimientoResponseDTO crearMovimiento(MovimientoRequestDTO requestDTO) {
        Movimiento movimiento = movimientoMapper.toEntity(requestDTO);
        Movimiento savedMovimiento = movimientoRepository.save(movimiento);
        return movimientoMapper.toResponseDTO(savedMovimiento);
    }
    
    // Obtener un movimiento por id
    public MovimientoResponseDTO getMovimientoById(Long id) {
        Movimiento movimiento = movimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        return movimientoMapper.toResponseDTO(movimiento);
    }

    // Obtener movimientos por estado
    public List<MovimientoResponseDTO> getMovimientosByEstado(String estado) {
        List<Movimiento> movimientos = movimientoRepository.findByEstado(estado);
        return movimientos.stream()
                .map(movimientoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Obtener la estructura solicitada por estado
    public List<MovimientoConDetallesDTO> getMovimientoConDetallesPorEstado(String estado) {
        return movimientoRepository.findMovimientoDetalleConBodegasPorEstado(estado);
    }
}
