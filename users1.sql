-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 04:49 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users1`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_consum`
--

CREATE TABLE `tb_consum` (
  `id` int(10) NOT NULL,
  `acc_no` varchar(10) NOT NULL,
  `date` int(10) NOT NULL,
  `units` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_consum`
--

INSERT INTO `tb_consum` (`id`, `acc_no`, `date`, `units`) VALUES
(1, '001A', 20200105, 10),
(2, '002A', 20200205, 15),
(3, '003A', 20200305, 20),
(4, '004A', 20200405, 25),
(5, '005A', 20200505, 25),
(8, '008A', 20200705, 40),
(10, '001B', 20200805, 35),
(11, '002B', 20200905, 25);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_consum`
--
ALTER TABLE `tb_consum`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_consum`
--
ALTER TABLE `tb_consum`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
