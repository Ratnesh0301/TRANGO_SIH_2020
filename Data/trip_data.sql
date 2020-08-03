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
-- Table structure for table `trip_data`
--

CREATE TABLE `trip_data` (
  `trip_id` int NOT NULL,
  `user_id` int NOT NULL,
  `source` varchar(1000) NOT NULL,
  `destination` varchar(1000) NOT NULL,
  `distance` float NOT NULL,
  `fare` float NOT NULL,
  `payment_mode` varchar(10) NOT NULL,
  `trip_count` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `trip_data`
--

INSERT INTO `trip_data` (`trip_id`, `user_id`, `source`, `destination`, `distance`, `fare`, `payment_mode`, `trip_count`) VALUES
(1, 101, 'AIACTR', 'IPU', 22, 150, 'online', 12),
(2, 102, 'india_gate', 'parliament_house', 10.76, 80.78, 'offline', 8),
(3, 103, 'laxmi_nagar', 'yamuna_vihar', 8.98, 50.89, 'online', 17),
(4, 102, 'nirman_vihar', 'dwarka', 25.75, 109, 'online', 16),
(5, 105, 'noida', 'gurgaon', 120.02, 400.29, 'online', 17),
(6, 108, 'janakpuri', 'nirman vihar', 34.76, 150.98, 'offline', 21),
(7, 111, 'preet vihar', 'mandi house', 12.04, 97.65, 'offline', 2),
(8, 112, 'rajiv chowk', 'kashmere gate', 14.89, 89.88, 'online', 12),
(9, 110, 'shahdara', 'pitampura', 26.76, 178.67, 'offline', 17),
(10, 107, 'welcome', 'rohini', 27.87, 180.87, 'offline', 19);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `trip_data`
--
ALTER TABLE `trip_data`
  ADD PRIMARY KEY (`trip_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `trip_data`
--
ALTER TABLE `trip_data`
  MODIFY `trip_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
