package com.example.prueba.presentation.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.prueba.application.dtos.MovimientoConDetallesDTO;
import com.example.prueba.application.dtos.MovimientoDetalleResponseDTO;
import com.example.prueba.application.dtos.MovimientoRequestDTO;
import com.example.prueba.application.dtos.MovimientoResponseDTO;
import com.example.prueba.application.services.MovimientoService;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@CrossOrigin(origins = "*")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    // Crear o actualizar un movimiento con detalles
    @PostMapping
    public ResponseEntity<MovimientoResponseDTO> createMovimiento(@RequestBody MovimientoRequestDTO movimientoDTO) {
        MovimientoResponseDTO savedMovimiento = movimientoService.saveMovimiento(movimientoDTO);
        return ResponseEntity.ok(savedMovimiento);
    }

    @PutMapping("/{movimientoId}")
    public ResponseEntity<MovimientoResponseDTO> updateMovimiento(
        @PathVariable Long movimientoId, 
        @RequestBody MovimientoRequestDTO requestDTO) {
        return ResponseEntity.ok(movimientoService.updateMovimiento(movimientoId, requestDTO));
    }

    // Obtener un movimiento por id
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoResponseDTO> getMovimientoById(@PathVariable Long id) {
        MovimientoResponseDTO movimientoDTO = movimientoService.getMovimientoById(id);
        return ResponseEntity.ok(movimientoDTO);
    }

    // Obtener movimientos por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<MovimientoResponseDTO>> getMovimientosByEstado(@PathVariable String estado) {
        List<MovimientoResponseDTO> movimientos = movimientoService.getMovimientosByEstado(estado);
        return ResponseEntity.ok(movimientos);
    }

    // Obtener la estructura con los detalles por estado
    @GetMapping("/con-detalles/estado/{estado}")
    public ResponseEntity<List<MovimientoConDetallesDTO>> getMovimientoConDetallesPorEstado(@PathVariable String estado) {
        List<MovimientoConDetallesDTO> detalles = movimientoService.getMovimientoConDetallesPorEstado(estado);
        return ResponseEntity.ok(detalles);
    }
}

