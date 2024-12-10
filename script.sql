-- Insertar movimientos (10 movimientos de ejemplo)
INSERT INTO movimiento (id_empresa, descripcion, bodega_origen_codigo, bodega_destino_codigo, fecha_creacion, fecha_entrega, estado)
VALUES
  (1001, 'Movimiento de prueba 1', 'BOD-01', 'BOD-02', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P'),
  (1002, 'Movimiento de prueba 2', 'BOD-03', 'BOD-04', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P'),
  (1001, 'Movimiento de prueba 3', 'BOD-01', 'BOD-03', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P'),
  (1002, 'Movimiento de prueba 4', 'BOD-02', 'BOD-04', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P'),
  (1001, 'Movimiento de prueba 5', 'BOD-01', 'BOD-02', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P'),
  (1002, 'Movimiento de prueba 6', 'BOD-03', 'BOD-01', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P'),
  (1001, 'Movimiento de prueba 7', 'BOD-02', 'BOD-03', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P'),
  (1002, 'Movimiento de prueba 8', 'BOD-04', 'BOD-01', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P'),
  (1001, 'Movimiento de prueba 9', 'BOD-03', 'BOD-04', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P'),
  (1002, 'Movimiento de prueba 10', 'BOD-01', 'BOD-02', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 'P');


-- Insertar detalles para los 10 movimientos
-- Movimiento 1
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (1, 'ITEM-001', 10),
  (1, 'ITEM-002', 20),
  (1, 'ITEM-003', 30);

-- Movimiento 2
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (2, 'ITEM-004', 40),
  (2, 'ITEM-005', 25);

-- Movimiento 3
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (3, 'ITEM-006', 15),
  (3, 'ITEM-007', 35),
  (3, 'ITEM-008', 50);

-- Movimiento 4
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (4, 'ITEM-009', 5),
  (4, 'ITEM-010', 60);

-- Movimiento 5
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (5, 'ITEM-011', 18),
  (5, 'ITEM-012', 22);

-- Movimiento 6
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (6, 'ITEM-013', 7),
  (6, 'ITEM-014', 13),
  (6, 'ITEM-015', 29);

-- Movimiento 7
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (7, 'ITEM-016', 31),
  (7, 'ITEM-017', 21);

-- Movimiento 8
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (8, 'ITEM-018', 45),
  (8, 'ITEM-019', 10);

-- Movimiento 9
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (9, 'ITEM-020', 60),
  (9, 'ITEM-021', 5);

-- Movimiento 10
INSERT INTO movimiento_detalle (movimiento_id, item_codigo, cantidad_enviada)
VALUES
  (10, 'ITEM-022', 35),
  (10, 'ITEM-023', 12);
