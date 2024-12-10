package com.example.prueba.presentation.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.prueba.application.dtos.MovimientoDetallesCustomDTO;
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

  
    @GetMapping
    public List<MovimientoResponseDTO> obtenerTodos() {
        return movimientoService.obtenerTodos();
    }
    
    // Crear 
    @PostMapping
    public ResponseEntity<MovimientoResponseDTO> createMovimiento(@RequestBody MovimientoRequestDTO movimientoDTO) {
        MovimientoResponseDTO savedMovimiento = movimientoService.saveMovimiento(movimientoDTO);
        return ResponseEntity.ok(savedMovimiento);
    }

    //editar
    @PutMapping("/{movimientoId}")
    public ResponseEntity<MovimientoResponseDTO> updateMovimiento(
        @PathVariable Long movimientoId, 
        @RequestBody MovimientoRequestDTO requestDTO) {
        return ResponseEntity.ok(movimientoService.updateMovimiento(movimientoId, requestDTO));
    }

    //  movimiento por id
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoResponseDTO> getMovimientoById(@PathVariable Long id) {
        MovimientoResponseDTO movimientoDTO = movimientoService.getMovimientoById(id);
        return ResponseEntity.ok(movimientoDTO);
    }

    //  movimientos por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<MovimientoResponseDTO>> getMovimientosByEstado(@PathVariable String estado) {
        List<MovimientoResponseDTO> movimientos = movimientoService.getMovimientosByEstado(estado);
        return ResponseEntity.ok(movimientos);
    }

    //  custon por estado
    @GetMapping("/custom/{estado}")
    public ResponseEntity<List<MovimientoDetallesCustomDTO>> getMovimientoConDetallesPorEstado(@PathVariable String estado) {
        List<MovimientoDetallesCustomDTO> detalles = movimientoService.getMovimientoConDetallesPorEstado(estado);
        return ResponseEntity.ok(detalles);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        movimientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

