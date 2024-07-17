CREATE DATABASE  IF NOT EXISTS `torino_teatro` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `torino_teatro`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: torino_teatro
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `biglietti`
--

DROP TABLE IF EXISTS `biglietti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `biglietti` (
  `id_operazione` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int DEFAULT NULL,
  `id_replica` int DEFAULT NULL,
  `data_ora` datetime DEFAULT NULL,
  `tipo_pagamento` varchar(20) DEFAULT NULL,
  `quantita` int DEFAULT NULL,
  PRIMARY KEY (`id_operazione`),
  KEY `id_cliente_idx` (`id_cliente`),
  KEY `id_replica_idx` (`id_replica`),
  CONSTRAINT `id_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clienti` (`id_cliente`),
  CONSTRAINT `id_replica` FOREIGN KEY (`id_replica`) REFERENCES `repliche` (`id_replica`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biglietti`
--

LOCK TABLES `biglietti` WRITE;
/*!40000 ALTER TABLE `biglietti` DISABLE KEYS */;
INSERT INTO `biglietti` VALUES (2,NULL,NULL,NULL,NULL,4),(3,NULL,NULL,NULL,'MasterCard',4),(4,NULL,NULL,NULL,'MasterCard',5);
/*!40000 ALTER TABLE `biglietti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienti` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `cognome` varchar(20) DEFAULT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `telefono` varchar(14) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `login` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES (11,'carlo','Rossi','3342347','null','null','null'),(12,'Mass','Rossi','334234567','rossi.marco90@gmail.com','Marco45','hyyfh73');
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repliche`
--

DROP TABLE IF EXISTS `repliche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repliche` (
  `id_replica` int NOT NULL AUTO_INCREMENT,
  `id_spettacolo` int DEFAULT NULL,
  `data_replica` date DEFAULT NULL,
  PRIMARY KEY (`id_replica`),
  KEY `id_spettacolo_idx` (`id_spettacolo`),
  CONSTRAINT `id_spettacolo` FOREIGN KEY (`id_spettacolo`) REFERENCES `spettacoli` (`id_spettacolo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repliche`
--

LOCK TABLES `repliche` WRITE;
/*!40000 ALTER TABLE `repliche` DISABLE KEYS */;
/*!40000 ALTER TABLE `repliche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spettacoli`
--

DROP TABLE IF EXISTS `spettacoli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spettacoli` (
  `id_spettacolo` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(40) DEFAULT NULL,
  `autore` varchar(25) DEFAULT NULL,
  `regista` varchar(25) DEFAULT NULL,
  `prezzo` decimal(4,2) DEFAULT NULL,
  `id_teatro` int DEFAULT NULL,
  PRIMARY KEY (`id_spettacolo`),
  KEY `id_teatro_idx` (`id_teatro`),
  CONSTRAINT `id_teatro` FOREIGN KEY (`id_teatro`) REFERENCES `teatri` (`id_teatro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spettacoli`
--

LOCK TABLES `spettacoli` WRITE;
/*!40000 ALTER TABLE `spettacoli` DISABLE KEYS */;
INSERT INTO `spettacoli` VALUES (1,'Personaggi','Rossi','Solari',14.00,NULL);
/*!40000 ALTER TABLE `spettacoli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teatri`
--

DROP TABLE IF EXISTS `teatri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teatri` (
  `id_teatro` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) DEFAULT NULL,
  `indirizzo` varchar(30) DEFAULT NULL,
  `citta` varchar(25) DEFAULT NULL,
  `provincia` varchar(2) DEFAULT NULL,
  `telefono` varchar(14) DEFAULT NULL,
  `posti` int DEFAULT NULL,
  PRIMARY KEY (`id_teatro`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teatri`
--

LOCK TABLES `teatri` WRITE;
/*!40000 ALTER TABLE `teatri` DISABLE KEYS */;
INSERT INTO `teatri` VALUES (1,'Bianchi','corso novare','Roma','RO','33423455647',1);
/*!40000 ALTER TABLE `teatri` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-16 16:52:42
