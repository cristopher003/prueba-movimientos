package com.example.prueba.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movimiento_detalle", schema = "testswisslub")
@Data
@NoArgsConstructor
public class MovimientoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El movimiento no puede ser nulo.")
    @ManyToOne
    @JoinColumn(name = "movimiento_id", nullable = false)
    private Movimiento movimiento;

    @NotBlank(message = "El código del ítem no puede estar vacío.")
    @Size(max = 20, message = "El código del ítem no puede superar los 20 caracteres.")
    @Column(name = "item_codigo", nullable = false, length = 20)
    private String itemCodigo;

    @NotNull(message = "La cantidad enviada no puede ser nula.")
    @Positive(message = "La cantidad enviada debe ser mayor a cero.")
    @Column(name = "cantidad_enviada", nullable = false)
    private Integer cantidadEnviada;
}
