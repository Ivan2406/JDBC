-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 06. Nov 2013 um 18:51
-- Server Version: 5.5.32
-- PHP-Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `jdbceinfach`
--
CREATE DATABASE IF NOT EXISTS `jdbceinfach` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jdbceinfach`;

-- --------------------------------------------------------

--
-- 

-- Tabellenstruktur fÃ¼r Tabelle `abteilung`
--


CREATE TABLE IF NOT EXISTS `abteilung` (
  `name` varchar(30) NOT NULL,
 
					 PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Daten fÃ¼r Tabelle `abteilung`

--

INSERT INTO `abteilung` (`name`) VALUES
('Marketing'),
('Geschäftsleitung'),
('Personalabteilung');

--
-- --------------------------------------------------------

--
-- 
-- Tabellenstruktur fÃ¼r Tabelle `mitarbeiter`
--


CREATE TABLE IF NOT EXISTS `mitarbeiter` (

`id` int(11) NOT NULL,
  
`vorname` varchar(20) DEFAULT NULL,
  
`nachname` varchar(20) DEFAULT NULL,
  
`abteilung` varchar(5) DEFAULT NULL,
  
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Daten fÃ¼r Tabelle `mitarbeiter`
--


INSERT INTO `mitarbeiter` (`id`, `vorname`, `nachname`, `abteilung`) VALUES

(1, 'Max', 'Mustermann', 'Marketing'),

(2, 'Franz', 'Gustav', 'Geschäftsleitung'),

(3, 'Thomas', 'Müller', 'Personalabteilung');


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
