package com.example.prueba.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.prueba.application.dtos.MovimientoDetallesCustomDTO;

@Entity
@Table(name = "movimiento", schema = "testswisslub")
@Data
@AllArgsConstructor
@Builder
@SqlResultSetMapping(
    name = "MovimientoConDetallesMapping",
    classes = @ConstructorResult(
        targetClass = MovimientoDetallesCustomDTO.class,
        columns = {
            @ColumnResult(name = "movimiento_id", type = Long.class),
            @ColumnResult(name = "movimiento_detalle_id", type = Long.class),
            @ColumnResult(name = "bodega_origen_codigo", type = String.class),
            @ColumnResult(name = "empresa", type = String.class),
            @ColumnResult(name = "bodega_destino_codigo", type = String.class),
            @ColumnResult(name = "item_id", type = String.class)
        }
    )
)
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El id de la empresa no puede ser nulo.")
    @Column(name = "id_empresa", nullable = false)
    private Long idEmpresa;

    @NotBlank(message = "La descripción no puede estar vacía.")
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotBlank(message = "El código de la bodega de origen no puede estar vacío.")
    @Size(max = 20, message = "El código de la bodega de origen no puede superar los 20 caracteres.")
    @Column(name = "bodega_origen_codigo", nullable = false, length = 20)
    private String bodegaOrigenCodigo;

    @NotBlank(message = "El código de la bodega de destino no puede estar vacío.")
    @Size(max = 20, message = "El código de la bodega de destino no puede superar los 20 caracteres.")
    @Column(name = "bodega_destino_codigo", nullable = false, length = 20)
    private String bodegaDestinoCodigo;

    @NotNull(message = "La fecha de creación no puede ser nula.")
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    @FutureOrPresent(message = "La fecha de entrega debe ser en el presente o en el futuro.")
    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @NotBlank(message = "El estado no puede estar vacío.")
    @Pattern(regexp = "P|T|E", message = "El estado debe ser 'P' (Pendiente), 'T' (Tránsito) o 'E' (Entregado).")
    @Column(name = "estado", nullable = false, length = 1)
    @Builder.Default
    private String estado = "P";

    // Relación con MovimientoDetalle
    @OneToMany(mappedBy = "movimiento", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<MovimientoDetalle> detalles = new ArrayList<>();

    public Movimiento(){

    }
}
