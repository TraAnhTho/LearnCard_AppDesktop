-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: flash_card
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
-- Table structure for table `list_card`
--

DROP TABLE IF EXISTS `list_card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `list_card` (
  `STT` int NOT NULL AUTO_INCREMENT,
  `List_Name` varchar(45) NOT NULL,
  `cardcol` varchar(45) NOT NULL,
  `usercol` varchar(45) NOT NULL,
  PRIMARY KEY (`STT`),
  UNIQUE KEY `cardcol` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_2` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_3` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_4` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_5` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_6` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_7` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_8` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_9` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_10` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_11` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_12` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_13` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_14` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_15` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_16` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_17` (`cardcol`,`usercol`),
  UNIQUE KEY `cardcol_18` (`cardcol`,`usercol`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_card`
--

LOCK TABLES `list_card` WRITE;
/*!40000 ALTER TABLE `list_card` DISABLE KEYS */;
INSERT INTO `list_card` VALUES (1,'Java','Java','admin'),(2,'HTML new','HTML new','admin'),(6,'English','English','admin'),(22,'php','php','admin'),(23,'python','python','admin'),(48,'English','English','user20'),(52,' Hóa hữu cơ 1',' Hóa hữu cơ 1','admin'),(56,' Hóa học',' Hóa học','user20'),(57,'test user 12 ','test user 12 ','user12'),(60,' Thư',' Thư','admin');
/*!40000 ALTER TABLE `list_card` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-02 16:30:03
