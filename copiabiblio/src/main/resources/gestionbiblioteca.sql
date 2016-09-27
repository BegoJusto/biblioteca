-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-09-2016 a las 18:19:38
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gestionbiblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE IF NOT EXISTS `ejemplar` (
  `codEjemplar` int(11) NOT NULL,
  `editorial` varchar(200) DEFAULT NULL,
  `numPaginas` int(11) DEFAULT NULL,
  `codLibro` int(11) NOT NULL,
  PRIMARY KEY (`codEjemplar`,`codLibro`),
  KEY `fk_ejemplar_libro1` (`codLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE IF NOT EXISTS `libro` (
  `codLibro` int(11) NOT NULL,
  `titulo` varchar(200) DEFAULT NULL,
  `autor` varchar(200) DEFAULT NULL,
  `isbn` varchar(200) DEFAULT NULL,
  `numeroEjemplares` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`codLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE IF NOT EXISTS `prestamo` (
  `codPrestamo` int(11) NOT NULL AUTO_INCREMENT,
  `fechaRecogida` date DEFAULT NULL,
  `fechaDevoPrevista` date DEFAULT NULL,
  `fechaDevolucionReal` date DEFAULT NULL,
  `codUsuario` int(11) NOT NULL,
  `codEjemplar` int(11) NOT NULL,
  PRIMARY KEY (`codPrestamo`,`codUsuario`,`codEjemplar`),
  KEY `fk_prestamo_usuario` (`codUsuario`),
  KEY `fk_prestamo_ejemplar1` (`codEjemplar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `codUsuario` int(11) NOT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `apellidos` varchar(200) DEFAULT NULL,
  `fNacimiento` date DEFAULT NULL,
  `mail` varchar(200) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`codUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `fk_ejemplar_libro1` FOREIGN KEY (`codLibro`) REFERENCES `libro` (`codLibro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `fk_prestamo_usuario` FOREIGN KEY (`codUsuario`) REFERENCES `usuario` (`codUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_prestamo_ejemplar1` FOREIGN KEY (`codEjemplar`) REFERENCES `ejemplar` (`codEjemplar`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
