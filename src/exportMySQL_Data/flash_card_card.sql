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
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `card` (
  `STT` int NOT NULL AUTO_INCREMENT,
  `cardcol` varchar(45) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Dinh_Nghia` varchar(100) NOT NULL,
  PRIMARY KEY (`Name`),
  UNIQUE KEY `STT_UNIQUE` (`STT`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (96,'Java','Arrays in java are?','Objects'),(94,'Java','Automatic type conversion is possible in which of the possible cases?','Int to Long'),(31,'English','beautiful','xinh đẹp'),(22,'English','build','xây dựng'),(19,'English','cat','con mèo'),(100,'Java','compareTo() returns','An int value'),(115,'English','Computer','mays tinhs'),(4,'CSS','CSS là gì','ai biết '),(33,'English','cute','dễ thương'),(21,'English','deploy','khai triển'),(20,'English','dog','con chó'),(27,'English','drink','uống'),(30,'English','eat','ăn'),(24,'English','feat','kì tích'),(23,'English','fix','sửa'),(32,'English','handsome','đẹp trai'),(3,'HTML','HTML','là ngôn ngữ đánh dấu siêu văn bản'),(101,'Java','Identify the corrected definition of a package?','A package is a collection of Classes and interfaces'),(103,'Java','java á','ok'),(102,'Java','Java là gì','ko biết'),(34,'English','music','âm nhạc'),(92,'Java','Number of primitive data types in Java are?','8'),(18,'English','Table','cái bàn'),(105,'tho','tho','tra anh tho'),(98,'Java','To which of the following does the class string belong to.','java.lang'),(99,'Java','Total constructor string class have.?','13'),(26,'English','update','cập nhật'),(29,'English','user','người dùng'),(28,'English','water','nước'),(93,'Java','What is the size of float and double in java?','32 and 64'),(95,'Java','When an array is passed to a method, what does the method receive?','The reference of the array'),(97,'Java','When is the object created with new keyword?','At rum time');
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-29 11:24:33
