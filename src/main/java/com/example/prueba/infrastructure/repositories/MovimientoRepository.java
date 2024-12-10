package com.example.prueba.infrastructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.prueba.application.dtos.MovimientoConDetallesDTO;
import com.example.prueba.application.dtos.MovimientoDetalleResponseDTO;
import com.example.prueba.domain.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

    // Puedes agregar consultas personalizadas si es necesario
    List<Movimiento> findByIdEmpresa(Long idEmpresa);

    // Buscar por estado
    List<Movimiento> findByEstado(String estado);

  @Query("SELECT new com.example.prueba.application.dtos.MovimientoConDetallesDTO(m.id, d.id, m.bodegaOrigenCodigo,m.idEmpresa , m.bodegaDestinoCodigo, d.id) " +
            "FROM Movimiento m " +
            "JOIN m.detalles d " +
            "WHERE m.estado = :estado")
    List<MovimientoConDetallesDTO> findMovimientoDetalleConBodegasPorEstado(@Param("estado") String estado);
}