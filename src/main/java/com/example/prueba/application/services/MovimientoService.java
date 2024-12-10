package com.example.prueba.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.prueba.application.dtos.MovimientoDetallesCustomDTO;
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


     @Transactional(readOnly = true)
    public List<MovimientoResponseDTO> obtenerTodos() {
        return movimientoRepository.findAll().stream()
            .map(movimientoMapper::toResponseDTO)
            .collect(Collectors.toList());
    }


    public MovimientoResponseDTO saveMovimiento(MovimientoRequestDTO movimientoDTO) {
        System.err.println(movimientoMapper.toEntity(movimientoDTO));
        Movimiento movimiento = movimientoMapper.toEntity(movimientoDTO);
        Movimiento savedMovimiento = movimientoRepository.save(movimiento);
        List<MovimientoDetalle> detalles = movimientoDTO.getDetalles().stream()
                .map(movimientoMapper::toEntity)
                .collect(Collectors.toList());
        detalles.forEach(detalle -> detalle.setMovimiento(savedMovimiento));
        movimientoDetalleRepository.saveAll(detalles);
        savedMovimiento.setDetalles(detalles);
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
    
   
    public MovimientoResponseDTO getMovimientoById(Long id) {
        Movimiento movimiento = movimientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        return movimientoMapper.toResponseDTO(movimiento);
    }

  
    public List<MovimientoResponseDTO> getMovimientosByEstado(String estado) {
        List<Movimiento> movimientos = movimientoRepository.findByEstado(estado);
        return movimientos.stream()
                .map(movimientoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Consulta custom
    public List<MovimientoDetallesCustomDTO> getMovimientoConDetallesPorEstado(String estado) {
        return movimientoRepository.findMovimientoDetalleConBodegasPorEstado(estado);
    }

   // eliminar - cambiar por borrado logico
    public void eliminar(Long id) {
        Movimiento movimiento = movimientoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("movimiento no encontrado"));
            movimientoRepository.delete(movimiento);
    }
}
