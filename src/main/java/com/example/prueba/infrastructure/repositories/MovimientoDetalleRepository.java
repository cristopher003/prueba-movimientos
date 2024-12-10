package com.example.prueba.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.prueba.domain.MovimientoDetalle;

import java.util.List;

@Repository
public interface MovimientoDetalleRepository extends JpaRepository<MovimientoDetalle, Long> {

    List<MovimientoDetalle> findByMovimientoId(Long movimientoId);

    
    @Query("SELECT md FROM MovimientoDetalle md WHERE md.movimiento.estado = :estado")
    List<MovimientoDetalle> findByEstadoEnMovimiento(@Param("estado") String estado);
}