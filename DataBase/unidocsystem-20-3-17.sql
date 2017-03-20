-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2017 at 06:44 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `unidocsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `address_id` varchar(15) NOT NULL,
  `uid` varchar(12) NOT NULL,
  `title` varchar(10) DEFAULT NULL,
  `title_detail` varchar(250) DEFAULT NULL,
  `house_no` varchar(250) DEFAULT NULL,
  `street` varchar(250) DEFAULT NULL,
  `landmark` varchar(250) DEFAULT NULL,
  `area` varchar(250) DEFAULT NULL,
  `postoffice` varchar(250) DEFAULT NULL,
  `sub_district` varchar(100) DEFAULT NULL,
  `district` varchar(100) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `pincode` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `bank_accounts`
--

CREATE TABLE `bank_accounts` (
  `bank_account_no` varchar(15) NOT NULL,
  `uid` varchar(12) NOT NULL,
  `isverified` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `district` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`district`, `city`) VALUES
('Rajkot', 'Jetpur'),
('Rajkot', 'Gondal'),
('Rajkot', 'Morbi'),
('Surat', 'Bardoli'),
('Surat', 'Vapi'),
('Junagadh', 'Mangrol'),
('Junagadh', 'Junadadh'),
('Rajkot', 'Rajkot');

-- --------------------------------------------------------

--
-- Table structure for table `contact_email`
--

CREATE TABLE `contact_email` (
  `uid` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contact_mobile`
--

CREATE TABLE `contact_mobile` (
  `mobile` varchar(16) NOT NULL,
  `uid` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contact_other`
--

CREATE TABLE `contact_other` (
  `contact_id` varchar(12) NOT NULL,
  `contact_type` varchar(50) DEFAULT NULL,
  `contact_detail` varchar(255) DEFAULT NULL,
  `uid` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `state` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`state`, `district`) VALUES
('Gujarat', 'Rajkot'),
('Gujarat', 'Surat'),
('Gujarat', 'Porbandar'),
('Gujarat', 'Junagadh'),
('Gujarat', 'Morbi'),
('Manipur', 'Birla'),
('Manipur', 'Zansi'),
('Manipur', 'Sarkira'),
('Rajasthan', 'Abu'),
('Rajasthan', 'Jaipur');

-- --------------------------------------------------------

--
-- Table structure for table `driving_licence`
--

CREATE TABLE `driving_licence` (
  `dl_no` varchar(15) NOT NULL,
  `uid` varchar(12) NOT NULL,
  `cdoi` date NOT NULL,
  `doi` date NOT NULL,
  `exp_date` date NOT NULL,
  `isverified` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `eci_id`
--

CREATE TABLE `eci_id` (
  `Eci_card_no` varchar(10) NOT NULL,
  `uid` varchar(12) NOT NULL,
  `isverified` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `isalive`
--

CREATE TABLE `isalive` (
  `uid` varchar(12) NOT NULL,
  `IsAlive` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `newregistereddata`
--

CREATE TABLE `newregistereddata` (
  `firstname` varchar(99) NOT NULL,
  `middlename` varchar(99) NOT NULL,
  `lastname` varchar(99) NOT NULL,
  `fullname` varchar(99) NOT NULL,
  `gender` varchar(15) NOT NULL,
  `dob` date NOT NULL,
  `regbase` varchar(20) NOT NULL,
  `uidmother` varchar(12) NOT NULL,
  `uidfather` varchar(12) NOT NULL,
  `uidgaurdian` varchar(12) NOT NULL,
  `uidother` varchar(12) NOT NULL,
  `mstatus` varchar(20) NOT NULL,
  `uidpartner` varchar(12) NOT NULL,
  `title` varchar(250) NOT NULL,
  `uidtakefrom` varchar(12) NOT NULL,
  `house` varchar(250) NOT NULL,
  `street` varchar(250) NOT NULL,
  `area` varchar(250) NOT NULL,
  `village` varchar(250) NOT NULL,
  `pincode` varchar(10) NOT NULL,
  `city` varchar(50) NOT NULL,
  `district` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `poi` varchar(250) NOT NULL,
  `poin` int(50) NOT NULL,
  `pob` varchar(250) NOT NULL,
  `pobn` varchar(50) NOT NULL,
  `poa` varchar(250) NOT NULL,
  `poan` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pan_number`
--

CREATE TABLE `pan_number` (
  `pan_number` varchar(10) NOT NULL,
  `uid` varchar(12) NOT NULL,
  `isverified` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `parents`
--

CREATE TABLE `parents` (
  `uid` varchar(12) NOT NULL,
  `mother_uid` varchar(12) DEFAULT NULL,
  `father_uid` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `registrarlogin`
--

CREATE TABLE `registrarlogin` (
  `uid` varchar(12) NOT NULL,
  `passwd` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `resident`
--

CREATE TABLE `resident` (
  `uid` varchar(12) NOT NULL,
  `full_name` varchar(99) DEFAULT NULL,
  `first_name` varchar(99) DEFAULT NULL,
  `middle_name` varchar(99) DEFAULT NULL,
  `last_name` varchar(99) DEFAULT NULL,
  `gender` varchar(15) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `photo` blob,
  `sign` blob,
  `pre_enroll` varchar(27) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `resident_address`
--

CREATE TABLE `resident_address` (
  `uid` varchar(12) NOT NULL,
  `address_id` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `school`
--

CREATE TABLE `school` (
  `addmission_number` varchar(16) NOT NULL,
  `uid` varchar(12) NOT NULL,
  `school_id` varchar(10) NOT NULL,
  `joine_date` date NOT NULL,
  `leave_date` date NOT NULL,
  `study_detail` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `state`
--

CREATE TABLE `state` (
  `country` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `state`
--

INSERT INTO `state` (`country`, `state`) VALUES
('India', 'Gujarat'),
('India', 'Maharatra'),
('India', 'Rajasthan'),
('India', 'Manipur');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`),
  ADD UNIQUE KEY `uid` (`uid`);

--
-- Indexes for table `bank_accounts`
--
ALTER TABLE `bank_accounts`
  ADD PRIMARY KEY (`bank_account_no`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `contact_email`
--
ALTER TABLE `contact_email`
  ADD PRIMARY KEY (`email`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `contact_mobile`
--
ALTER TABLE `contact_mobile`
  ADD PRIMARY KEY (`mobile`),
  ADD KEY `mobile` (`mobile`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `contact_other`
--
ALTER TABLE `contact_other`
  ADD PRIMARY KEY (`contact_id`),
  ADD KEY `contact_id` (`contact_id`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `driving_licence`
--
ALTER TABLE `driving_licence`
  ADD PRIMARY KEY (`dl_no`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `eci_id`
--
ALTER TABLE `eci_id`
  ADD PRIMARY KEY (`Eci_card_no`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `isalive`
--
ALTER TABLE `isalive`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `pan_number`
--
ALTER TABLE `pan_number`
  ADD PRIMARY KEY (`pan_number`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `parents`
--
ALTER TABLE `parents`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `mother_uid` (`mother_uid`),
  ADD KEY `father_uid` (`father_uid`);

--
-- Indexes for table `registrarlogin`
--
ALTER TABLE `registrarlogin`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `resident`
--
ALTER TABLE `resident`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `pre_enroll` (`pre_enroll`);

--
-- Indexes for table `resident_address`
--
ALTER TABLE `resident_address`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `address_id` (`address_id`);

--
-- Indexes for table `school`
--
ALTER TABLE `school`
  ADD PRIMARY KEY (`addmission_number`),
  ADD KEY `uid` (`uid`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bank_accounts`
--
ALTER TABLE `bank_accounts`
  ADD CONSTRAINT `bank_accounts_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `contact_email`
--
ALTER TABLE `contact_email`
  ADD CONSTRAINT `contact_email_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `contact_mobile`
--
ALTER TABLE `contact_mobile`
  ADD CONSTRAINT `contact_mobile_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `contact_other`
--
ALTER TABLE `contact_other`
  ADD CONSTRAINT `contact_other_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `driving_licence`
--
ALTER TABLE `driving_licence`
  ADD CONSTRAINT `driving_licence_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `eci_id`
--
ALTER TABLE `eci_id`
  ADD CONSTRAINT `eci_id_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `isalive`
--
ALTER TABLE `isalive`
  ADD CONSTRAINT `isalive_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `pan_number`
--
ALTER TABLE `pan_number`
  ADD CONSTRAINT `pan_number_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `parents`
--
ALTER TABLE `parents`
  ADD CONSTRAINT `parents_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`),
  ADD CONSTRAINT `parents_ibfk_2` FOREIGN KEY (`mother_uid`) REFERENCES `resident` (`uid`),
  ADD CONSTRAINT `parents_ibfk_3` FOREIGN KEY (`father_uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `registrarlogin`
--
ALTER TABLE `registrarlogin`
  ADD CONSTRAINT `registrarlogin_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

--
-- Constraints for table `resident_address`
--
ALTER TABLE `resident_address`
  ADD CONSTRAINT `resident_address_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`),
  ADD CONSTRAINT `resident_address_ibfk_2` FOREIGN KEY (`address_id`) REFERENCES `address` (`address_id`);

--
-- Constraints for table `school`
--
ALTER TABLE `school`
  ADD CONSTRAINT `school_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `resident` (`uid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
