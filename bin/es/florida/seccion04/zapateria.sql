-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-11-2021 a las 22:03:37
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `zapateria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zapatos`
--

CREATE TABLE `zapatos` (
  `id` int(3) NOT NULL,
  `tipo` varchar(40) NOT NULL,
  `marca` varchar(40) NOT NULL,
  `modelo` varchar(40) NOT NULL,
  `color` varchar(40) NOT NULL,
  `talla` int(11) NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `zapatos`
--

INSERT INTO `zapatos` (`id`, `tipo`, `marca`, `modelo`, `color`, `talla`, `precio`) VALUES
(1, 'Casual', 'Callahgan', '87654', 'Marron', 43, 69.99),
(2, 'Casual', 'Adidas', 'Classic', 'Blanco-Mostaza', 42, 59.99),
(3, 'Deportivo', 'Adidas', 'Verano', 'Blanco-Rojo', 45, 124.99),
(4, 'Bota', 'UGG', 'Bailey', 'Ante-Marron', 39, 159.99),
(5, 'Casual', '24h', 'dsf', 'Azul', 40, 99.99),
(6, 'Deportivo', 'Adidas', 'Space', 'Plata', 40, 49.99),
(7, 'Bota', 'Dr. Martens', 'Black_Skin', 'Negro', 43, 139.99),
(8, 'Casual', 'Puma', 'Walk', 'Blanco-Verde', 40, 49.99),
(9, 'Casual', 'Snipe', 'Brown1234', 'Marron', 45, 59.99),
(10, 'Casual', 'Nike', 'Air2', 'Blanco', 45, 99.99),
(11, 'Bota', 'Nike', 'Air2', 'Blanco', 45, 99.99),
(12, 'Chancla', 'Crocks', 'Crocokcodrilo', 'Beig', 42, 39.99),
(13, 'Chancla', 'Nike', 'PalmBeach', 'Negro', 42, 12.99),
(14, 'Tacon', 'Manolo Blani', 'Verano22', 'Rojo', 40, 599.99);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `zapatos`
--
ALTER TABLE `zapatos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `zapatos`
--
ALTER TABLE `zapatos`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
