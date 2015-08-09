CREATE DATABASE  IF NOT EXISTS `client` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `client`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: client
-- ------------------------------------------------------
-- Server version	5.6.14-log

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
-- Table structure for table `atribytofinquiry`
--

DROP TABLE IF EXISTS `atribytofinquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atribytofinquiry` (
  `idAtribyt` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAtribyt`),
  UNIQUE KEY `idAtribyt_UNIQUE` (`idAtribyt`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atribytofinquiry`
--

LOCK TABLES `atribytofinquiry` WRITE;
/*!40000 ALTER TABLE `atribytofinquiry` DISABLE KEYS */;
INSERT INTO `atribytofinquiry` VALUES (1,'Сбой сети'),(2,'Помехи'),(3,'Шум'),(4,'Не работает связь');
/*!40000 ALTER TABLE `atribytofinquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquiry`
--

DROP TABLE IF EXISTS `inquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inquiry` (
  `idInquiry` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `createDate` date NOT NULL,
  `customerName` varchar(45) DEFAULT NULL,
  `Topic_idTopic` int(10) unsigned NOT NULL,
  `AtribytOfInquiry_idAtribyt` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idInquiry`),
  UNIQUE KEY `idInquiry_UNIQUE` (`idInquiry`),
  UNIQUE KEY `createDate_UNIQUE` (`createDate`),
  KEY `fk_Inquiry_Topic_idx` (`Topic_idTopic`),
  KEY `fk_Inquiry_AtribytOfInquiry1_idx` (`AtribytOfInquiry_idAtribyt`),
  CONSTRAINT `fk_Inquiry_AtribytOfInquiry1` FOREIGN KEY (`AtribytOfInquiry_idAtribyt`) REFERENCES `atribytofinquiry` (`idAtribyt`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inquiry_Topic` FOREIGN KEY (`Topic_idTopic`) REFERENCES `topic` (`idTopic`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquiry`
--

LOCK TABLES `inquiry` WRITE;
/*!40000 ALTER TABLE `inquiry` DISABLE KEYS */;
INSERT INTO `inquiry` VALUES (1,'Проверить соединение','2012-12-20','Петров АА',1,1),(2,'Позвонить в call центр','2011-11-20','Иванов АА',2,2);
/*!40000 ALTER TABLE `inquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `idTopic` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nameTopic` varchar(45) DEFAULT NULL,
  `adress` varchar(45) DEFAULT NULL,
  `model_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTopic`),
  UNIQUE KEY `idTopic_UNIQUE` (`idTopic`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'Не работает связь','Скрыганова 4-4','D-link DSL-2500U'),(2,'Сбой сети','Ангарская 65-89','TP-LINK TD-8817');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-09 23:27:00
