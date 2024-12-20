package com.example.prueba.presentation.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.prueba.application.dtos.MovimientoDetalleRequestDTO;
import com.example.prueba.application.dtos.MovimientoDetalleResponseDTO;
import com.example.prueba.application.services.MovimientoDetalleService;

import java.util.List;

@RestController
@RequestMapping("/api/movimiento-detalles")
public class MovimientoDetalleController {

    @Autowired
    private MovimientoDetalleService movimientoDetalleService;

      @GetMapping
    public List<MovimientoDetalleResponseDTO> obtenerTodos() {
        return movimientoDetalleService.obtenerTodos();
     }

    @PostMapping
    public ResponseEntity<MovimientoDetalleResponseDTO> createMovimientoDetalle(
        @RequestBody MovimientoDetalleRequestDTO requestDTO) {
        return ResponseEntity.ok(movimientoDetalleService.createMovimientoDetalle(requestDTO));
 
    }

    @PutMapping("/{detalleId}")
    public ResponseEntity<MovimientoDetalleResponseDTO> updateMovimientoDetalle(
        @PathVariable Long detalleId, 
        @RequestBody MovimientoDetalleRequestDTO requestDTO) {
        return ResponseEntity.ok(movimientoDetalleService.updateMovimientoDetalle(detalleId, requestDTO));
    }
    
    // movimiento detalle por id
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoDetalleResponseDTO> getMovimientoDetalleById(@PathVariable Long id) {
        MovimientoDetalleResponseDTO detalleDTO = movimientoDetalleService.getMovimientoDetalleById(id);
        return ResponseEntity.ok(detalleDTO);
    }

    //  detalles por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<MovimientoDetalleResponseDTO>> getDetallesByEstado(@PathVariable String estado) {
        List<MovimientoDetalleResponseDTO> detalles = movimientoDetalleService.getDetallesByEstado(estado);
        return ResponseEntity.ok(detalles);
    }

    //  detalles por movimiento_id
    @GetMapping("/movimiento/{movimientoId}")
    public ResponseEntity<List<MovimientoDetalleResponseDTO>> getDetallesByMovimientoId(@PathVariable Long movimientoId) {
        List<MovimientoDetalleResponseDTO> detalles = movimientoDetalleService.getDetallesByMovimientoId(movimientoId);
        return ResponseEntity.ok(detalles);
    }
}
