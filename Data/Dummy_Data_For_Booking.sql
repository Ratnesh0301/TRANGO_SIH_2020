-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Aug 03, 2020 at 09:40 AM
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
-- Table structure for table `Dummy_Data_For_Booking`
--

CREATE TABLE `Dummy_Data_For_Booking` (
  `Transport_Type` varchar(20) NOT NULL,
  `Transport_Id` varchar(10) NOT NULL,
  `Starting_Location` varchar(40) NOT NULL,
  `Ending_Location` varchar(40) NOT NULL,
  `Kilometres_Driven` float DEFAULT NULL,
  `Facilities` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Price_per_km` float DEFAULT NULL,
  `No_of_Seats_Vacant` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Dummy_Data_For_Booking`
--

INSERT INTO `Dummy_Data_For_Booking` (`Transport_Type`, `Transport_Id`, `Starting_Location`, `Ending_Location`, `Kilometres_Driven`, `Facilities`, `Price_per_km`, `No_of_Seats_Vacant`) VALUES
('Bus', '703', 'Uttam Nagar East Terminal', 'Jheel Chowk', 30, 'Non-AC', NULL, 7),
('Bus', '816', 'Uttam Nagar west ', 'Inderlok', 10, 'Non-AC', NULL, 6),
('Bus', '706', 'Uttam Nagar East Terminal', 'Gurgaon', 35, 'AC', NULL, 6),
('Taxi', '703', 'Uttam Nagar East Terminal', 'Jheel Chowk', 25, 'AC', 10, NULL),
('Metro', '0', 'Uttam Nagar west ', 'Shastri Park', NULL, NULL, NULL, NULL),
('Metro', '0', 'Vaishali', 'Nirman Vihar', NULL, NULL, NULL, NULL),
('Taxi', '102', 'Rajiv Chowk ', 'Geeta Colony ', 12.5, 'AC', 15, NULL),
('Bus', '742', 'Uttam Nagar East Terminal', 'Laxmi Nagar', NULL, 'AC', NULL, 5),
('Bus', '753', 'Chandni_chowk', 'Sarai KAlen Khan', NULL, 'Non-AC', NULL, 8),
('Rickshaw', '1', 'Arya Samaj Road', 'Tilak NAgar', 10, NULL, 7, NULL),
('Rickshaw', '1', 'Nirman Vihar', 'AIACTR', 2.5, NULL, 10, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
