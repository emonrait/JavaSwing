CREATE DATABASE  IF NOT EXISTS `fastway` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fastway`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: fastway
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `user_id` varchar(10) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `rank` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('aman33','aman123','Amanullah Khan','Dhanmondi, Dhaka','0189756412','Admin'),('nazmul22','654321','Nazmul Hasan','Mohakhali, Dhaka','01856492322','Admin'),('reaz11','123456','Reaz Uddin Samrat','Baridhara, Dhaka','01917155864','Admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domestic_rate`
--

DROP TABLE IF EXISTS `domestic_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domestic_rate` (
  `zone` int(11) NOT NULL,
  `district_from` varchar(45) DEFAULT NULL,
  `district_to` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `ship_option` varchar(45) DEFAULT NULL,
  `ship_value` double DEFAULT NULL,
  PRIMARY KEY (`zone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domestic_rate`
--

LOCK TABLES `domestic_rate` WRITE;
/*!40000 ALTER TABLE `domestic_rate` DISABLE KEYS */;
INSERT INTO `domestic_rate` VALUES (1,'Dhaka','Rajshahi, Syhlet, Khulna, Barisal','per kg','Express',30),(2,'Dhaka','Dhaka, Rajshahi, Syhlet, Khulna, Barisal','per kg','General',20),(3,'Dhaka','Dhaka, Rajshahi, Syhlet, Khulna, Barisal','per kg (above 5 kg)','Express',22),(4,'Dhaka','Dhaka, Rajshahi, Syhlet, Khulna, Barisal','per kg (above 5 kg)','General',12),(5,'Rajshahi, Syhlet, Khulna, Barisal','Dhaka, Rajshahi, Syhlet, Khulna, Barisal','per kg','Express',35),(6,'Rajshahi, Syhlet, Khulna, Barisal','Dhaka, Rajshahi, Syhlet, Khulna, Barisal','per kg','General',22),(7,'Rajshahi, Syhlet, Khulna, Barisal','Dhaka, Rajshahi, Syhlet, Khulna, Barisal','per kg (above 5 kg)','Express',22),(8,'Rajshahi, Syhlet, Khulna, Barisal','Dhaka, Rajshahi, Syhlet, Khulna, Barisal','per kg (above 5 kg)','General',14);
/*!40000 ALTER TABLE `domestic_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domestic_ship`
--

DROP TABLE IF EXISTS `domestic_ship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domestic_ship` (
  `track_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_name` varchar(45) DEFAULT NULL,
  `from_district` varchar(45) DEFAULT NULL,
  `from_address` varchar(120) DEFAULT NULL,
  `to_name` varchar(45) DEFAULT NULL,
  `to_district` varchar(45) DEFAULT NULL,
  `to_address` varchar(120) DEFAULT NULL,
  `pname` varchar(65) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `piece` int(11) DEFAULT NULL,
  `packag` varchar(80) DEFAULT NULL,
  `product_value` double DEFAULT NULL,
  `ship_time` date DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `reaching_time` varchar(45) DEFAULT NULL,
  `ship_value` double DEFAULT NULL,
  `employee_name` varchar(45) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `revenue` double DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `payment_by` varchar(45) DEFAULT NULL,
  `last_update` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`track_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domestic_ship`
--

LOCK TABLES `domestic_ship` WRITE;
/*!40000 ALTER TABLE `domestic_ship` DISABLE KEYS */;
INSERT INTO `domestic_ship` VALUES (29,'Sahidur','Dhaka','1236, Gulshan, Banani','Mosaidul','Khulna','2589, Halisohor, Rupsha','Books',10,15,'Medium Box',5000,'2018-12-12','General','Dec 15, 2018',3750,'Sagor Hosen',1500,2250,'Shiped','Credit Card',NULL),(30,'Sazzad','Dhaka','1212, Gulshan, Vatara','Abdullah','Rajshahi','1564, Hathazari, College','Rice',50,1,'Medium Box',2000,'2018-12-12','Expressed','Dec 13, 2018',2000,'Sarif Uddin',800,1200,'On Way','Credit Card','Sarif Uddin');
/*!40000 ALTER TABLE `domestic_ship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `user_id` varchar(10) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `rank` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('imran40','imran123','Imran Hosen Sekh','Rajshahi, Bangladesh','018756423','Employee'),('nasir10','nasir123','Nasir Ahmed Khan','Khilkhet, Dhaka','01856479811','employee'),('sagor20','sagor123','Sagor Hosen','Mohammadpur, Dhaka','012354897','employee'),('sarif30','sarif123','Sarif Uddin','Mirpur, Dhaka','0123456887','employee');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `international_rate`
--

DROP TABLE IF EXISTS `international_rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `international_rate` (
  `Zone` int(11) NOT NULL,
  `country_from` varchar(45) DEFAULT NULL,
  `country_to` varchar(45) DEFAULT NULL,
  `weight` varchar(15) DEFAULT NULL,
  `ship_option` varchar(45) DEFAULT NULL,
  `ship_value` double DEFAULT NULL,
  PRIMARY KEY (`Zone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `international_rate`
--

LOCK TABLES `international_rate` WRITE;
/*!40000 ALTER TABLE `international_rate` DISABLE KEYS */;
INSERT INTO `international_rate` VALUES (1,'Australia','Bangladesh','per kg','Express',5),(2,'Australia','Bangladesh','per kg','General',3),(3,'Australia','Canada','per kg','Express',7),(4,'Australia','Canada','per kg','General',4),(5,'Australia','England','per kg','Express',6),(6,'Australia','England','per kg','General',3.5),(7,'Australia','Africa','per kg','Express',5),(8,'Australia','Africa','per kg','General',3),(9,'Bangladesh','Australia','per kg','Express',5),(10,'Bangladesh','Australia','per kg','General',3),(11,'Bangladesh','Canada','per kg','Express',6),(12,'Bangladesh','Canada','per kg','General',4),(13,'Bangladesh','England','per kg','Express',6),(14,'Bangladesh','England','per kg','General',4),(15,'Bangladesh','Africa','per kg','Express',4),(16,'Bangladesh','Africa','per kg','General',2.5),(17,'Canada','Australia','per kg','Express',8),(18,'Canada','Australia','per kg','General',5.5),(19,'Canada','Bangladesh','per kg','Express',7),(20,'Canada','Bangladesh','per kg','General',4.5),(21,'Canada','England','per kg','Express',2),(22,'Canada','England','per kg','General',1),(23,'Canada','Africa','per kg','Express',4),(24,'Canada','Africa','per kg','General',2.5),(25,'Africa','Australia','per kg','Express',6),(26,'Africa','Australia','per kg','General',4),(27,'Africa','Bangladesh','per kg','Express',5),(28,'Africa','Bangladesh','per kg','General',3),(29,'Africa','Canada','per kg','Express',4),(30,'Africa','Canada','per kg','General',2.5),(31,'Africa','England','per kg','Express',3),(32,'Africa','England','per kg','Gereral',1.8);
/*!40000 ALTER TABLE `international_rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `international_ship`
--

DROP TABLE IF EXISTS `international_ship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `international_ship` (
  `track_id` int(11) NOT NULL AUTO_INCREMENT,
  `from_name` varchar(45) DEFAULT NULL,
  `from_country` varchar(45) DEFAULT NULL,
  `from_address` varchar(120) DEFAULT NULL,
  `to_name` varchar(45) DEFAULT NULL,
  `to_country` varchar(45) DEFAULT NULL,
  `to_address` varchar(120) DEFAULT NULL,
  `pname` varchar(45) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `piece` int(11) DEFAULT NULL,
  `packag` varchar(45) DEFAULT NULL,
  `product_value` double DEFAULT NULL,
  `ship_time` date DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `reaching_time` varchar(80) DEFAULT NULL,
  `ship_value` double DEFAULT NULL,
  `employee_name` varchar(45) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  `revenue` double DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `payment_by` varchar(45) DEFAULT NULL,
  `last_update` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`track_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `international_ship`
--

LOCK TABLES `international_ship` WRITE;
/*!40000 ALTER TABLE `international_ship` DISABLE KEYS */;
INSERT INTO `international_ship` VALUES (2,'Ms Olivia','Canada','33224, Manitoba, 520 Manitoba lane','Mr Babuls','England','4412, London, 101 London avenue','Cloth',3,5,'Medium Box',3000,'2018-12-17','General','Dec 22, 2018',60,'Sarif Uddin',33,27,'Shiped','Credit Card','Sarif Uddin'),(3,'Mr Cameroon','England','11556, Cambridge, 520 Cambridge road','Mr Jemes','Africa','448, Durban, 101 Durban avenue','Tshirt',1,12,'Small Box',120,'2018-12-18','Expressed','Dec 20, 2018',84,'Sarif Uddin',46.2,37.8,'Shiped','Credit Card','Sarif Uddin'),(4,'Mr Jackman','Australia','8855, Perth, 203 Perth road','Jesica','Africa','8855, Johannesburg, 101 Johannesburg avenue','Vintag Goods',2,20,'Medium Box',1700,'2018-12-17','General','Dec 22, 2018',160,'Sarif Uddin',88,72,'Shiped','Cash','Sarif Uddin'),(5,'Mr Abbia','England','11223, Birmingham, 458 Birmingham Road','Mr Ronojit','Bangladesh','1212, Dhaka, 101 baddanogor lane','Mobile',0.5,3,'Small Box',1000,'2018-12-18','Expressed','Dec 20, 2018',10.5,'Sagor Hosen',5.775,4.725,'On Way','Credit Card','Sagor Hosen'),(6,'Mr Fahinan','Africa','4784, Cairo, Cairo Sqiuare','Mr Akuras','Australia','2258, Sydney, Sydney Road 221','Light',2,10,'Small Box',5000,'2018-12-18','Expressed','Dec 20, 2018',140,'Nasir Ahmed Khan',77,63,'Deleveried','Credit Card','Sarif Uddin');
/*!40000 ALTER TABLE `international_ship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_info`
--

DROP TABLE IF EXISTS `member_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_info` (
  `mid` varchar(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `ship_option` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_info`
--

LOCK TABLES `member_info` WRITE;
/*!40000 ALTER TABLE `member_info` DISABLE KEYS */;
INSERT INTO `member_info` VALUES ('M1001','Saddam Hosen','Manikgang, Dhaka','saddam10@gmail.com','saddam','Export'),('M1002','Atikur Rahman','Old Dhaka, Dhaka-1000','atik10@gmail.com','atik123','Export, Import'),('M1003','Taibur Rahman','New Dhaka, Dhaka-1200','taib10@gmail.com','taib123','Import'),('M1004','Ridoy Khan','Mirour, Dhaka','ridoy10@gmail.com','ridoy123','Import');
/*!40000 ALTER TABLE `member_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fastway'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-17 12:20:05
