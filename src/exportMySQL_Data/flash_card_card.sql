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
  `usercol` varchar(45) NOT NULL,
  PRIMARY KEY (`STT`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (3,'HTML new','HTML','là ngôn ngữ đánh dấu siêu văn bản','admin'),(18,'English','Table','cái bànb','admin'),(20,'English','dog','con chó','admin'),(21,'English','deploy','khai triển','admin'),(22,'English','build','xây dựng','admin'),(23,'English','fix','sửa','admin'),(24,'English','feat','kì tích','admin'),(26,'English','update','cập nhật','admin'),(27,'English','drink','uống','admin'),(28,'English','water','nước','admin'),(29,'English','user','người dùng','admin'),(30,'English','eat','ăn','admin'),(31,'English','beautiful','xinh đẹp','admin'),(32,'English','handsome','đẹp trai','admin'),(33,'English','cute','dễ thương','admin'),(34,'English','music','âm nhạc','admin'),(92,'Java','Number of primitive data types in Java are?','8','admin'),(93,'Java','What is the size of float and double in java?','32 and 64','admin'),(94,'Java','Automatic type conversion is possible in which of the possible cases?','Int to Long','admin'),(95,'Java','When an array is passed to a method, what does the method receive?','The reference of the array','admin'),(96,'Java','Arrays in java are?','Objects','admin'),(97,'Java','When is the object created with new keyword?','At rum time','admin'),(98,'Java','To which of the following does the class string belong to.','java.lang','admin'),(99,'Java','Total constructor string class have.?','13','admin'),(100,'Java','compareTo() returns','An int value','admin'),(101,'Java','Identify the corrected definition of a package?','A package is a collection of Classes and interfaces','admin'),(102,'Java','Java là gì','ko biết','admin'),(103,'Java','java á','no know','admin'),(115,'English','Computer','máy tính','admin'),(116,'English','1','1','user20'),(117,'English','2','2','user20'),(118,'English','3','3','user20'),(119,'English','4','4','user20'),(120,'English','5','5','user20'),(122,'English','7','7','user20'),(123,'English','8','8','user20'),(125,'English','meomeo','cat','user20'),(126,'English','con cún','dog','user20'),(127,'English','mùa xuân','spring','user20'),(128,'English','mùa hề','summer','user20'),(129,'English','đói thì ăn đi','eat','user20'),(130,'English','heo','pig','user20'),(131,'English','ddd','sssss','user20'),(132,'English','ề','ưdqdwefsdfwef','user20'),(133,' Hóa hữu cơ 1','vật thể','cái bàn','admin'),(134,' Hóa hữu cơ 1','c1','tư bản cố định','admin'),(135,' Hóa hữu cơ 1','kh c1+c2+v+m','giá trị thặng dư','admin'),(136,' Hóa hữu cơ 1','m1','khối lượng thặng dư dùng để tiêu dùng','admin'),(140,' Thư','Thư thích ai ','tôi chứ ai','admin'),(141,' Hóa học','Ca0','vôi sống','user20'),(142,' Hóa học','NaOH','bazo','user20'),(143,' Hóa học','HCOOH','azit ãetit','user20'),(146,'test user 12 ','www','hhhh','user12'),(155,' Thư','Lã','Thư','admin'),(156,' Thư','Lã Hoàng','Anh Thư','admin');
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

-- Dump completed on 2024-06-02 16:30:02
