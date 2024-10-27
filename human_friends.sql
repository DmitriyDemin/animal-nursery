-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: human_friends
-- ------------------------------------------------------
-- Server version	8.4.2

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
-- Table structure for table `animals_group`
--

DROP TABLE IF EXISTS `animals_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animals_group` (
  `group_id` int NOT NULL AUTO_INCREMENT,
  `group_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals_group`
--

LOCK TABLES `animals_group` WRITE;
/*!40000 ALTER TABLE `animals_group` DISABLE KEYS */;
INSERT INTO `animals_group` VALUES (1,'Домашние животные'),(2,'Вьючные животные');
/*!40000 ALTER TABLE `animals_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animals_nursery`
--

DROP TABLE IF EXISTS `animals_nursery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animals_nursery` (
  `animal_id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `animal_type` int DEFAULT NULL,
  PRIMARY KEY (`animal_id`),
  KEY `animal_type` (`animal_type`),
  CONSTRAINT `animals_nursery_ibfk_1` FOREIGN KEY (`animal_type`) REFERENCES `animals_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals_nursery`
--

LOCK TABLES `animals_nursery` WRITE;
/*!40000 ALTER TABLE `animals_nursery` DISABLE KEYS */;
INSERT INTO `animals_nursery` VALUES (1,'Бакс','2017-03-13',1),(2,'Федя','2011-06-16',2),(3,'Вася','2023-04-21',2),(4,'Лорд','2022-02-13',3),(5,'Мурсик','2018-07-11',2),(6,'Ветка','2021-09-18',1),(7,'Нитка','2015-02-02',6),(8,'Ветерок','2022-08-08',4),(9,'Гром','2013-03-11',4),(11,'Байкал','2023-01-11',6),(12,'Седой','2015-05-11',1),(16,'карл','1212-12-12',1),(17,'Каркар','1212-12-12',1),(18,'апмп','1487-12-12',1),(19,'Ральф','1212-12-12',1),(20,'лор','1212-12-12',1),(21,'Проша','2011-12-13',4);
/*!40000 ALTER TABLE `animals_nursery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animals_type`
--

DROP TABLE IF EXISTS `animals_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animals_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `animals_type_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `animals_group` (`group_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals_type`
--

LOCK TABLES `animals_type` WRITE;
/*!40000 ALTER TABLE `animals_type` DISABLE KEYS */;
INSERT INTO `animals_type` VALUES (1,'Собака',1),(2,'Кошка',1),(3,'Хомяк',1),(4,'Лошадь',2),(5,'Верблюд',2),(6,'Осел',2);
/*!40000 ALTER TABLE `animals_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animals_young`
--

DROP TABLE IF EXISTS `animals_young`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animals_young` (
  `animal_id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `animal_type` int DEFAULT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`animal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals_young`
--

LOCK TABLES `animals_young` WRITE;
/*!40000 ALTER TABLE `animals_young` DISABLE KEYS */;
INSERT INTO `animals_young` VALUES (3,'Вася','2023-04-21',2,17),(4,'Лорд','2022-02-13',3,31),(8,'Ветерок','2022-08-08',4,26);
/*!40000 ALTER TABLE `animals_young` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commands`
--

DROP TABLE IF EXISTS `commands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commands` (
  `command_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`command_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commands`
--

LOCK TABLES `commands` WRITE;
/*!40000 ALTER TABLE `commands` DISABLE KEYS */;
INSERT INTO `commands` VALUES (5,'Кличка','Первая команда, которую изучает щенок — это отклик на свое имя. По сути это аналог команде «Внимание!». '),(6,'Ко мне','Одна из основных команд, предполагающая, что собака по зову хозяина подбежит к нему,'),(23,'Нельзя','Чрезвычайно важные команды, означающие, что питомцу требуется прекратить действие,'),(24,'Сидеть','Достаточно простая команда, которая бывает удобной, если собаку нужно сосредоточить,'),(25,'Лежать','Команда лежать еще более полезна активным животным, так как тренирует выдержку.'),(26,'Рядом','эта команда необходима на улице, особенно если речь идет о крупной сильной собаке. При изучении этого навыка питомец идет на коротком поводке'),(27,'Гуляй','Одна из любимых команд любого животного, означающая, что можно перестать идти рядом и отправиться на прогулку без поводка'),(28,'Барьер','питомец по команде перепрыгивает препятствие.'),(29,'Место','уходит на специальное место, предварительно обозначенное хозяином.'),(30,'Апорт','бежит за брошенным человеком предметом, приносит и возвращает его.'),(31,'Домой','питомец приучается после прогулки следовать к дому и подъезду. ');
/*!40000 ALTER TABLE `commands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_table`
--

DROP TABLE IF EXISTS `general_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `general_table` (
  `animal_id` int NOT NULL DEFAULT '0',
  `nickname` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `type_name` varchar(20) DEFAULT NULL,
  `group_name` varchar(20) DEFAULT NULL,
  `command_title` varchar(30) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_table`
--

LOCK TABLES `general_table` WRITE;
/*!40000 ALTER TABLE `general_table` DISABLE KEYS */;
INSERT INTO `general_table` VALUES (1,'Бакс','2017-03-13','Собака','Домашние животные','Кличка','Первая команда, которую изучает щенок — это отклик на свое имя. По сути это сигнал, что нужно сосредоточиться на последующих указаниях владельца, то есть аналог команде «Внимание!». '),(1,'Бакс','2017-03-13','Собака','Домашние животные','Ко мне','Одна из основных команд, предполагающая, что собака по зову хозяина подбежит к нему,'),(1,'Бакс','2017-03-13','Собака','Домашние животные','Нельзя','Чрезвычайно важные команды, означающие, что питомцу требуется прекратить действие,'),(1,'Бакс','2017-03-13','Собака','Домашние животные','Сидеть','Достаточно простая команда, которая бывает удобной, если собаку нужно сосредоточить,'),(1,'Бакс','2017-03-13','Собака','Домашние животные','Лежать','Команда лежать еще более полезна активным животным, так как тренирует выдержку.'),(6,'Ветка','2021-09-18','Собака','Домашние животные','Кличка','Первая команда, которую изучает щенок — это отклик на свое имя. По сути это сигнал, что нужно сосредоточиться на последующих указаниях владельца, то есть аналог команде «Внимание!». '),(6,'Ветка','2021-09-18','Собака','Домашние животные','Ко мне','Одна из основных команд, предполагающая, что собака по зову хозяина подбежит к нему,'),(6,'Ветка','2021-09-18','Собака','Домашние животные','Нельзя','Чрезвычайно важные команды, означающие, что питомцу требуется прекратить действие,'),(6,'Ветка','2021-09-18','Собака','Домашние животные','Сидеть','Достаточно простая команда, которая бывает удобной, если собаку нужно сосредоточить,'),(6,'Ветка','2021-09-18','Собака','Домашние животные','Лежать','Команда лежать еще более полезна активным животным, так как тренирует выдержку.'),(2,'Федя','2011-06-16','Кошка','Домашние животные','Кличка','Первая команда, которую изучает щенок — это отклик на свое имя. По сути это сигнал, что нужно сосредоточиться на последующих указаниях владельца, то есть аналог команде «Внимание!». '),(2,'Федя','2011-06-16','Кошка','Домашние животные','Домой','приучается после прогулки следовать к дому и подъезду. Команда может пригодиться в критической ситуации, когда питомца что-то напугало или он сорвался с поводка.'),(3,'Вася','2023-04-21','Кошка','Домашние животные','Кличка','Первая команда, которую изучает щенок — это отклик на свое имя. По сути это сигнал, что нужно сосредоточиться на последующих указаниях владельца, то есть аналог команде «Внимание!». '),(3,'Вася','2023-04-21','Кошка','Домашние животные','Домой','приучается после прогулки следовать к дому и подъезду. Команда может пригодиться в критической ситуации, когда питомца что-то напугало или он сорвался с поводка.'),(5,'Мурсик','2018-07-11','Кошка','Домашние животные','Кличка','Первая команда, которую изучает щенок — это отклик на свое имя. По сути это сигнал, что нужно сосредоточиться на последующих указаниях владельца, то есть аналог команде «Внимание!». '),(5,'Мурсик','2018-07-11','Кошка','Домашние животные','Домой','приучается после прогулки следовать к дому и подъезду. Команда может пригодиться в критической ситуации, когда питомца что-то напугало или он сорвался с поводка.'),(4,'Лорд','2022-02-13','Хомяк','Домашние животные','Кличка','Первая команда, которую изучает щенок — это отклик на свое имя. По сути это сигнал, что нужно сосредоточиться на последующих указаниях владельца, то есть аналог команде «Внимание!». '),(8,'Ветерок','2022-08-08','Лошадь','Вьючные животные','Сидеть','Достаточно простая команда, которая бывает удобной, если собаку нужно сосредоточить,'),(8,'Ветерок','2022-08-08','Лошадь','Вьючные животные','Лежать','Команда лежать еще более полезна активным животным, так как тренирует выдержку.'),(9,'Гром','2013-03-11','Лошадь','Вьючные животные','Сидеть','Достаточно простая команда, которая бывает удобной, если собаку нужно сосредоточить,'),(9,'Гром','2013-03-11','Лошадь','Вьючные животные','Лежать','Команда лежать еще более полезна активным животным, так как тренирует выдержку.');
/*!40000 ALTER TABLE `general_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horse_donkey`
--

DROP TABLE IF EXISTS `horse_donkey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horse_donkey` (
  `animal_id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `animal_type` int DEFAULT NULL,
  PRIMARY KEY (`animal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horse_donkey`
--

LOCK TABLES `horse_donkey` WRITE;
/*!40000 ALTER TABLE `horse_donkey` DISABLE KEYS */;
INSERT INTO `horse_donkey` VALUES (7,'Нитка','2015-02-02',6),(8,'Ветерок','2022-08-08',4),(9,'Гром','2013-03-11',4);
/*!40000 ALTER TABLE `horse_donkey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skills` (
  `animal_id` int NOT NULL,
  `command_id` int NOT NULL,
  PRIMARY KEY (`animal_id`,`command_id`),
  KEY `skills_command_id_fk2_idx` (`command_id`),
  CONSTRAINT `skills_animal_id_fk1` FOREIGN KEY (`animal_id`) REFERENCES `animals_nursery` (`animal_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `skills_command_id_fk2` FOREIGN KEY (`command_id`) REFERENCES `commands` (`command_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (1,5),(2,5),(3,5),(1,6),(2,6),(1,23),(2,23),(1,24),(4,24),(1,25),(4,25),(2,29),(4,29),(2,30),(2,31);
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-27 16:11:13
