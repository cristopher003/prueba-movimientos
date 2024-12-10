-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 10-12-2024 a las 20:03:41
-- Versión del servidor: 8.3.0
-- Versión de PHP: 8.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE DATABASE IF NOT EXISTS testswisslub;
USE testswisslub;

DROP TABLE IF EXISTS `movimiento`;
CREATE TABLE IF NOT EXISTS `movimiento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bodega_destino_codigo` varchar(20) NOT NULL,
  `bodega_origen_codigo` varchar(20) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `id_empresa` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `movimiento`
--

INSERT INTO `movimiento` (`id`, `bodega_destino_codigo`, `bodega_origen_codigo`, `descripcion`, `estado`, `fecha_creacion`, `fecha_entrega`, `id_empresa`) VALUES
(1, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(2, 'BOD-04', 'BOD-03', 'Movimiento de prueba 2', 'E', '2024-12-10', '2024-12-17', 1002),
(3, 'BOD-03', 'BOD-01', 'Movimiento de prueba 3', 'P', '2024-12-10', '2024-12-17', 1001),
(4, 'BOD-04', 'BOD-02', 'Movimiento de prueba 4', 'P', '2024-12-10', '2024-12-17', 1002),
(5, 'BOD-02', 'BOD-01', 'Movimiento de prueba 5', 'T', '2024-12-10', '2024-12-17', 1001),
(6, 'BOD-01', 'BOD-03', 'Movimiento de prueba 6', 'P', '2024-12-10', '2024-12-17', 1002),
(7, 'BOD-03', 'BOD-02', 'Movimiento de prueba 7', 'P', '2024-12-10', '2024-12-17', 1001),
(8, 'BOD-01', 'BOD-04', 'Movimiento de prueba 8', 'T', '2024-12-10', '2024-12-17', 1002),
(9, 'BOD-04', 'BOD-03', 'Movimiento de prueba 9', 'P', '2024-12-10', '2024-12-17', 1001),
(10, 'BOD-02', 'BOD-01', 'Movimiento de prueba 10', 'E', '2024-12-10', '2024-12-17', 1002),
(11, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(12, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(13, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(14, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(15, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(16, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(17, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(18, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(19, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(20, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(22, 'BOD-02', 'BOD-01', 'Movimiento de prueba 1', 'P', '2024-12-10', '2024-12-17', 1001),
(23, 'BOD-02', 'BOD-01', 'Movimiento de prueba edit', 'P', '2024-12-10', '2024-12-17', 1001);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento_detalle`
--

DROP TABLE IF EXISTS `movimiento_detalle`;
CREATE TABLE IF NOT EXISTS `movimiento_detalle` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cantidad_enviada` int NOT NULL,
  `item_codigo` varchar(20) NOT NULL,
  `movimiento_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqu4iv8vmju352or7esvdo5iym` (`movimiento_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `movimiento_detalle`
--

INSERT INTO `movimiento_detalle` (`id`, `cantidad_enviada`, `item_codigo`, `movimiento_id`) VALUES
(1, 10, 'ITEM-001', 1),
(2, 20, 'ITEM-002', 1),
(3, 30, 'ITEM-003', 1),
(4, 40, 'ITEM-004', 2),
(5, 25, 'ITEM-005', 2),
(6, 15, 'ITEM-006', 3),
(7, 35, 'ITEM-007', 3),
(8, 50, 'ITEM-008', 3),
(9, 5, 'ITEM-009', 4),
(10, 60, 'ITEM-010', 4),
(11, 18, 'ITEM-011', 5),
(12, 22, 'ITEM-012', 5),
(13, 7, 'ITEM-013', 6),
(14, 13, 'ITEM-014', 6),
(15, 29, 'ITEM-015', 6),
(16, 31, 'ITEM-016', 7),
(17, 21, 'ITEM-017', 7),
(18, 45, 'ITEM-018', 8),
(19, 10, 'ITEM-019', 8),
(20, 60, 'ITEM-020', 9),
(21, 5, 'ITEM-021', 9),
(22, 35, 'ITEM-022', 10),
(23, 12, 'ITEM-023', 10),
(24, 10, 'ITEM-001', 19),
(25, 10, 'ITEM-001', 20),
(26, 10, 'ITEM-001', 22),
(27, 10, 'ITEM-001', 23),
(28, 12, 'ITEM-001', 23),
(29, 3, 'ITEM-001', 2),
(30, 32, 'ITEM-001', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movimiento_detalle`
--
ALTER TABLE `movimiento_detalle`
  ADD CONSTRAINT `FKqu4iv8vmju352or7esvdo5iym` FOREIGN KEY (`movimiento_id`) REFERENCES `movimiento` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
