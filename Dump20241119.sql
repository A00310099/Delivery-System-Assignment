-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: newsagent
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customer_id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES ('A22222','Jurgen Leitner','Daingean','567-890-1234','online'),('A33333','Gerry Keay','Edenderry','234-567-8901','online'),('A44444','Annabelle Cane','Croghan Hill','456-789-0123','online'),('A6666','Michael Shelley','Tullamore','123-456-7890','online'),('A99999','Gertrude Robinson','Balinagar','345-678-9012','online'),('C7676','John Doe','Claire','898-989-0343',NULL),('C98345','Sarah Smith','Derry','093-345-3234',NULL);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_areas`
--

DROP TABLE IF EXISTS `delivery_areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_areas` (
  `delivery_area_id` varchar(100) NOT NULL,
  `delivery_person_id` varchar(100) DEFAULT NULL,
  `delivery_area_number` varchar(100) DEFAULT NULL,
  `customer_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`delivery_area_id`),
  KEY `customer_id` (`customer_id`),
  KEY `delivery_person_id` (`delivery_person_id`),
  CONSTRAINT `delivery_areas_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON DELETE CASCADE,
  CONSTRAINT `delivery_areas_ibfk_2` FOREIGN KEY (`delivery_person_id`) REFERENCES `delivery_person` (`delivery_person_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_areas`
--

LOCK TABLES `delivery_areas` WRITE;
/*!40000 ALTER TABLE `delivery_areas` DISABLE KEYS */;
INSERT INTO `delivery_areas` VALUES ('G09283','DP9299','G5','A22222'),('G12121','DP1212','G1','A6666'),('G34545','DP7467','G2','A33333'),('G8659','DP2347','G3','A99999'),('G98345','DP7285','G4','A44444');
/*!40000 ALTER TABLE `delivery_areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_dockets`
--

DROP TABLE IF EXISTS `delivery_dockets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_dockets` (
  `docket_id` varchar(50) NOT NULL,
  `delivery_areas` varchar(50) DEFAULT NULL,
  `order_status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`docket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_dockets`
--

LOCK TABLES `delivery_dockets` WRITE;
/*!40000 ALTER TABLE `delivery_dockets` DISABLE KEYS */;
INSERT INTO `delivery_dockets` VALUES ('D1111','Galway','active'),('D2222','Galway','active'),('D3333','Galway','active'),('D4444','Galway','active'),('D5555','Galway','active');
/*!40000 ALTER TABLE `delivery_dockets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_person`
--

DROP TABLE IF EXISTS `delivery_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_person` (
  `delivery_person_id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`delivery_person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_person`
--

LOCK TABLES `delivery_person` WRITE;
/*!40000 ALTER TABLE `delivery_person` DISABLE KEYS */;
INSERT INTO `delivery_person` VALUES ('DP1212','Joshua Gillespie','987-789-9090'),('DP2347','Jonah Magnus','656-777-9002'),('DP7285','Robert Montauk','787-232-0902'),('DP7467','Peter Lukas','212-343-3555'),('DP9299','Edwin Burroughs','788-909-3421');
/*!40000 ALTER TABLE `delivery_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoices`
--

DROP TABLE IF EXISTS `invoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoices` (
  `invoice_id` varchar(50) NOT NULL,
  `customer_id` varchar(50) DEFAULT NULL,
  `total_cost` varchar(50) DEFAULT NULL,
  `reminder` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `invoices_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoices`
--

LOCK TABLES `invoices` WRITE;
/*!40000 ALTER TABLE `invoices` DISABLE KEYS */;
INSERT INTO `invoices` VALUES ('C1111','A6666','20','1 week','online'),('C2222','A33333','20','1 week','online'),('C3333','A99999','20','1 week','online'),('C4444','A44444','20','1 week','online'),('C5555','A22222','20','1 week','online');
/*!40000 ALTER TABLE `invoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` varchar(50) NOT NULL,
  `delivery_area` varchar(100) DEFAULT NULL,
  `customer_id` varchar(50) DEFAULT NULL,
  `publication_id` varchar(50) DEFAULT NULL,
  `week_day` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `customer_id` (`customer_id`),
  KEY `publication_id` (`publication_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON DELETE CASCADE,
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`publication_id`) REFERENCES `publications` (`publication_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('B1111','Galway','A6666','P1111','Monday'),('B22222','Galway','A33333','P2222','Tuesday'),('B33333','Galway','A99999','P3333','Wednesday'),('B4444','Galway','A44444','P4444','Thursday'),('B5555','Galway','A22222','P5555','Friday'),('B9878','Cavan','C98345','P1111','Tuesday');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publications`
--

DROP TABLE IF EXISTS `publications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publications` (
  `publication_id` varchar(50) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `frequency` varchar(20) DEFAULT NULL,
  `stock` varchar(50) DEFAULT NULL,
  `cost` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`publication_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publications`
--

LOCK TABLES `publications` WRITE;
/*!40000 ALTER TABLE `publications` DISABLE KEYS */;
INSERT INTO `publications` VALUES ('P1111','Daily Mail','newspaper','daily','200','1.50'),('P2222','Irish Times','newspaper','bi-weekly','100','2.10'),('P3333','RTE','newspaper','daily','200','2.20'),('P4444','National Geographic','magazine','weekly','100','3.20'),('P5555','Home','magazine','weekly','100','2.30'),('P9999','New York Times','Newspaper','Daily','600','3.5');
/*!40000 ALTER TABLE `publications` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-19  3:29:31
