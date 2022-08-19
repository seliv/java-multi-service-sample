USE acme_plan_service;

-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: acme_plan_service
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan` (
  `id` bigint NOT NULL,
  `code` varchar(50) NOT NULL,
  `description` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6jenoap3aq7hiikqf7t0g6mqa` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,'starter','Starter plan'),(2,'regular','Regular plan'),(3,'gold','Gold plan for valued customers'),(4,'vip','VIP limited edition');
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_leg`
--

DROP TABLE IF EXISTS `plan_leg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_leg` (
  `id` bigint NOT NULL,
  `code` varchar(50) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `percent` int NOT NULL,
  `plan_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_plan_leg_id_code` (`id`,`code`),
  KEY `FK_plan_leg_plan` (`plan_id`),
  CONSTRAINT `FK_plan_leg_plan` FOREIGN KEY (`plan_id`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_leg`
--

LOCK TABLES `plan_leg` WRITE;
/*!40000 ALTER TABLE `plan_leg` DISABLE KEYS */;
INSERT INTO `plan_leg` VALUES (101,'processing_fee','Payment processing fee',3,1),(102,'service_share','Commission for service usage',17,1),(103,'client_share','Client\'s share of the payment',80,1),(201,'processing_fee','Payment processing fee',3,2),(202,'service_share','Commission for service usage',20,2),(203,'client_share','Client\'s share of the payment',70,2),(204,'additional_fee','Additional fees for no reason just because',7,2),(301,'processing_fee','Payment processing fee',1,3),(302,'service_share','Commission for service usage',14,3),(303,'client_share','Client\'s share of the payment',85,3),(401,'service_share','Commission for service usage',5,4),(402,'client_share','Client\'s share of the payment',95,4);
/*!40000 ALTER TABLE `plan_leg` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-19 17:16:31
