-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 03, 2020 at 09:39 AM
-- Server version: 8.0.21
-- PHP Version: 7.2.24-0ubuntu0.18.04.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gkltraffic`
--

-- --------------------------------------------------------

--
-- Table structure for table `Congestion_and_Social_Distancing`
--

CREATE TABLE `Congestion_and_Social_Distancing` (
  `Transport_Type` varchar(20) NOT NULL,
  `Transport_Id` varchar(10) NOT NULL,
  `Vehicle_Tag` int NOT NULL,
  `Congestion_Level` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Social_Distancing_Check` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Congestion_and_Social_Distancing`
--

INSERT INTO `Congestion_and_Social_Distancing` (`Transport_Type`, `Transport_Id`, `Vehicle_Tag`, `Congestion_Level`, `Social_Distancing_Check`) VALUES
('Bus', '703', 1, 'Low', 'Not-Violated'),
('Bus', '706', 2, 'Moderate', 'Violated'),
('Bus', '816', 3, 'High', 'Violated'),
('Bus', '740', 4, 'High', 'Not-Violated'),
('Bus', '853', 6, 'Insane', 'Violated'),
('Bus', '39', 5, 'Low', 'Violated'),
('Bus', '805A', 1, 'Moderate', 'Not-Violated'),
('Bus', '879', 3, 'Insane', 'Not-Violated'),
('Bus', '711', 2, 'High', 'Not-Violated'),
('Bus', '776', 5, 'Low', 'Violated'),
('Bus', '588', 4, 'Moderate', 'Not-Violated'),
('Bus', '534', 6, 'Insane', 'Violated');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
