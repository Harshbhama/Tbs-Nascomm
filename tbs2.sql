-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 14, 2017 at 08:42 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tbs2`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbs_admin_table`
--

CREATE TABLE `tbs_admin_table` (
  `admin_id` int(5) NOT NULL,
  `admin_name` varchar(35) NOT NULL,
  `admin_phone` bigint(10) NOT NULL,
  `admin_password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbs_admin_table`
--

INSERT INTO `tbs_admin_table` (`admin_id`, `admin_name`, `admin_phone`, `admin_password`) VALUES
(1, 'Himalaya', 9818759481, '1234');

-- --------------------------------------------------------

--
-- Table structure for table `tbs_billhistory_table`
--

CREATE TABLE `tbs_billhistory_table` (
  `billhistory_custid` int(5) NOT NULL,
  `billhistory_custname` varchar(35) NOT NULL,
  `billhistory_paymentmode` varchar(20) NOT NULL,
  `billhistory_amount` float NOT NULL,
  `billhistory_date` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbs_billhistory_table`
--

INSERT INTO `tbs_billhistory_table` (`billhistory_custid`, `billhistory_custname`, `billhistory_paymentmode`, `billhistory_amount`, `billhistory_date`) VALUES
(1, 'Hemant', 'Credit Card', 350, '14/07/2017'),
(2, 'AnujKhetan', 'Credit Card', 2299.1, '14/07/2017'),
(3, 'Harsh', 'Credit Card', 3046, '14/07/2017');

-- --------------------------------------------------------

--
-- Table structure for table `tbs_bill_table`
--

CREATE TABLE `tbs_bill_table` (
  `bill_customerid` int(5) NOT NULL,
  `bill_customername` varchar(35) NOT NULL,
  `bill_invoice` int(5) NOT NULL,
  `bill_durationmin` float NOT NULL,
  `bill_datausagemb` float NOT NULL,
  `bill_totalcost` float NOT NULL,
  `bill_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbs_bill_table`
--

INSERT INTO `tbs_bill_table` (`bill_customerid`, `bill_customername`, `bill_invoice`, `bill_durationmin`, `bill_datausagemb`, `bill_totalcost`, `bill_status`) VALUES
(1, 'Hemant', 10000, 50, 50, 350, 'paid'),
(2, 'AnujKhetan', 10001, 456, 465.55, 2399.1, 'paid'),
(3, 'Harsh', 10002, 456, 789, 3046, 'paid');

-- --------------------------------------------------------

--
-- Table structure for table `tbs_customer_table`
--

CREATE TABLE `tbs_customer_table` (
  `cust_id` int(5) NOT NULL,
  `cust_name` varchar(35) NOT NULL,
  `cust_age` int(3) NOT NULL,
  `cust_doj` varchar(15) NOT NULL,
  `cust_add` varchar(75) NOT NULL,
  `cust_phone` bigint(10) NOT NULL,
  `cust_plan` varchar(20) NOT NULL,
  `cust_pass` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbs_customer_table`
--

INSERT INTO `tbs_customer_table` (`cust_id`, `cust_name`, `cust_age`, `cust_doj`, `cust_add`, `cust_phone`, `cust_plan`, `cust_pass`) VALUES
(3, 'Harsh', 22, '14/07/2017', 'ABES', 7418529635, 'basic plan', 'him1234');

-- --------------------------------------------------------

--
-- Table structure for table `tbs_plan_table`
--

CREATE TABLE `tbs_plan_table` (
  `plan_name` varchar(35) NOT NULL,
  `plan_code` bigint(10) NOT NULL,
  `plan_validity` int(5) NOT NULL,
  `cost_per_mb` float NOT NULL,
  `cost_per_min` float NOT NULL,
  `base_cost` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbs_plan_table`
--

INSERT INTO `tbs_plan_table` (`plan_name`, `plan_code`, `plan_validity`, `cost_per_mb`, `cost_per_min`, `base_cost`) VALUES
('basic plan', 261, 28, 2, 3, 100);

-- --------------------------------------------------------

--
-- Table structure for table `tbs_systemadmin_table`
--

CREATE TABLE `tbs_systemadmin_table` (
  `system_admin_id` int(5) NOT NULL,
  `system_admin_name` varchar(35) NOT NULL,
  `system_admin_phone` bigint(10) NOT NULL,
  `system_admin_password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbs_systemadmin_table`
--

INSERT INTO `tbs_systemadmin_table` (`system_admin_id`, `system_admin_name`, `system_admin_phone`, `system_admin_password`) VALUES
(123, 'Himalaya', 9818759481, '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbs_admin_table`
--
ALTER TABLE `tbs_admin_table`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `admin_phone` (`admin_phone`);

--
-- Indexes for table `tbs_billhistory_table`
--
ALTER TABLE `tbs_billhistory_table`
  ADD PRIMARY KEY (`billhistory_custid`);

--
-- Indexes for table `tbs_bill_table`
--
ALTER TABLE `tbs_bill_table`
  ADD PRIMARY KEY (`bill_customerid`),
  ADD UNIQUE KEY `bill_invoice` (`bill_invoice`);

--
-- Indexes for table `tbs_customer_table`
--
ALTER TABLE `tbs_customer_table`
  ADD PRIMARY KEY (`cust_id`),
  ADD UNIQUE KEY `customer_phone` (`cust_phone`);

--
-- Indexes for table `tbs_plan_table`
--
ALTER TABLE `tbs_plan_table`
  ADD PRIMARY KEY (`plan_code`);

--
-- Indexes for table `tbs_systemadmin_table`
--
ALTER TABLE `tbs_systemadmin_table`
  ADD PRIMARY KEY (`system_admin_id`),
  ADD UNIQUE KEY `systemadmin_phone` (`system_admin_phone`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
