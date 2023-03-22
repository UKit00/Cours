-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.32-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema boutique
--

CREATE DATABASE IF NOT EXISTS boutique;
USE boutique;

--
-- Definition of table `categorie_produit`
--

DROP TABLE IF EXISTS `categorie_produit`;
CREATE TABLE `categorie_produit` (
  `code_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `nom_categorie` varchar(30) NOT NULL DEFAULT '',
  `description` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`code_categorie`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categorie_produit`
--

/*!40000 ALTER TABLE `categorie_produit` DISABLE KEYS */;
INSERT INTO `categorie_produit` (`code_categorie`,`nom_categorie`,`description`) VALUES 
 (1,'tomate ','tomate bien rouge'),
 (2,'tomate ','tomate bien rouge'),
 (3,'lait','lait en poudre'),
 (4,'savon','savon de marseille'),
 (5,'Omo','bien moussÃ©'),
 (6,'gggggggg','gttjhjjjj'),
 (7,'gggggggg','gttjhjjjj'),
 (8,'gggggggg','gttjhjjjj'),
 (9,'EEEEE','dddddddddddd'),
 (10,'eeeeeeee','QSDdffff'),
 (11,'eeeeeeee','QSDdffff');
/*!40000 ALTER TABLE `categorie_produit` ENABLE KEYS */;


--
-- Definition of table `clients`
--

DROP TABLE IF EXISTS `clients`;
CREATE TABLE `clients` (
  `code_client` int(11) NOT NULL AUTO_INCREMENT,
  `addresse` varchar(30) DEFAULT NULL,
  `num_tel` int(50) DEFAULT NULL,
  `e_mail` varchar(40) NOT NULL,
  `nom_client` varchar(30) DEFAULT NULL,
  `ville` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`code_client`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clients`
--

/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` (`code_client`,`addresse`,`num_tel`,`e_mail`,`nom_client`,`ville`) VALUES 
 (20,'lome',98567890,'miji@hotmail.fr','MIJIYAWA','adidogome');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;


--
-- Definition of table `details_vente`
--

DROP TABLE IF EXISTS `details_vente`;
CREATE TABLE `details_vente` (
  `quantite_vendu` int(11) NOT NULL,
  `reference_produit` int(11) NOT NULL,
  `num_vente` int(11) NOT NULL,
  `somme_remise` int(11) DEFAULT NULL,
  `reliquat` int(11) DEFAULT NULL,
  PRIMARY KEY (`reference_produit`,`num_vente`),
  KEY `fk_num_vente_num_vente` (`num_vente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `details_vente`
--

/*!40000 ALTER TABLE `details_vente` DISABLE KEYS */;
INSERT INTO `details_vente` (`quantite_vendu`,`reference_produit`,`num_vente`,`somme_remise`,`reliquat`) VALUES 
 (67,7,1,NULL,NULL),
 (4,7,2,NULL,NULL),
 (5,7,3,NULL,NULL),
 (6,7,4,NULL,NULL),
 (4,7,5,NULL,NULL),
 (2,7,6,NULL,NULL),
 (2,7,7,NULL,NULL),
 (2,7,8,NULL,NULL),
 (2,7,9,NULL,NULL),
 (2,7,10,NULL,NULL),
 (2,7,11,NULL,NULL),
 (2,7,12,NULL,NULL),
 (2,7,13,NULL,NULL),
 (4,7,14,NULL,NULL),
 (2,7,15,NULL,NULL),
 (4,9,16,NULL,NULL),
 (2,10,16,NULL,NULL),
 (2,13,17,NULL,NULL),
 (3,14,17,NULL,NULL),
 (4,7,18,NULL,NULL),
 (2,7,19,NULL,NULL),
 (2,8,19,NULL,NULL),
 (3,14,20,NULL,NULL),
 (2,15,20,NULL,NULL),
 (2,14,21,NULL,NULL),
 (2,15,21,NULL,NULL),
 (2,13,22,NULL,NULL),
 (2,14,22,NULL,NULL),
 (2,15,22,NULL,NULL),
 (2,13,23,NULL,NULL),
 (2,14,23,NULL,NULL),
 (2,15,23,NULL,NULL),
 (2,14,24,NULL,NULL),
 (2,15,24,NULL,NULL),
 (2,12,25,NULL,NULL),
 (3,13,25,NULL,NULL),
 (2,14,26,NULL,NULL),
 (2,15,26,NULL,NULL),
 (2,14,27,NULL,NULL),
 (2,15,27,NULL,NULL),
 (2,14,28,NULL,NULL),
 (3,15,28,NULL,NULL),
 (2,14,29,NULL,NULL),
 (2,15,29,NULL,NULL),
 (2,7,30,NULL,NULL),
 (3,8,30,NULL,NULL),
 (2,15,30,NULL,NULL),
 (2,14,32,NULL,NULL),
 (2,14,33,NULL,NULL),
 (2,15,33,NULL,NULL),
 (2,13,34,NULL,NULL),
 (2,11,35,NULL,NULL),
 (2,13,35,NULL,NULL),
 (2,14,35,NULL,NULL),
 (2,15,35,NULL,NULL),
 (2,12,36,NULL,NULL),
 (5,13,36,NULL,NULL),
 (3,14,36,NULL,NULL),
 (4,15,36,NULL,NULL),
 (2,11,36,NULL,NULL),
 (2,10,36,NULL,NULL),
 (2,12,37,NULL,NULL),
 (2,13,37,NULL,NULL),
 (2,14,37,NULL,NULL),
 (2,15,37,NULL,NULL),
 (2,11,38,NULL,NULL),
 (2,12,38,NULL,NULL),
 (2,13,38,NULL,NULL),
 (2,14,38,NULL,NULL),
 (2,15,38,NULL,NULL),
 (2,13,39,NULL,NULL),
 (2,14,39,NULL,NULL),
 (2,15,39,NULL,NULL),
 (2,12,40,NULL,NULL),
 (2,12,41,NULL,NULL),
 (2,13,41,NULL,NULL),
 (2,14,41,NULL,NULL),
 (2,15,41,NULL,NULL),
 (2,13,42,NULL,NULL),
 (2,14,42,NULL,NULL),
 (2,15,42,NULL,NULL),
 (5,10,43,NULL,NULL),
 (2,14,44,NULL,NULL),
 (2,15,44,NULL,NULL),
 (2,13,45,NULL,NULL),
 (2,14,45,NULL,NULL),
 (2,15,45,NULL,NULL),
 (2,14,46,NULL,NULL),
 (2,15,46,NULL,NULL),
 (2,14,48,NULL,NULL),
 (2,15,48,NULL,NULL),
 (2,10,49,NULL,NULL),
 (2,14,49,NULL,NULL),
 (2,15,49,NULL,NULL),
 (2,14,50,NULL,NULL),
 (2,15,50,NULL,NULL),
 (2,14,51,NULL,NULL),
 (2,15,51,NULL,NULL),
 (2,13,52,NULL,NULL),
 (2,14,52,NULL,NULL),
 (2,15,52,NULL,NULL),
 (2,13,53,NULL,NULL),
 (2,14,53,NULL,NULL),
 (2,15,53,NULL,NULL),
 (3,10,54,NULL,NULL),
 (3,11,54,NULL,NULL),
 (2,11,55,NULL,NULL),
 (2,12,55,NULL,NULL),
 (2,13,55,NULL,NULL),
 (2,14,56,NULL,NULL),
 (2,15,56,NULL,NULL),
 (2,14,57,NULL,NULL),
 (2,15,57,NULL,NULL),
 (2,13,58,NULL,NULL),
 (2,14,58,NULL,NULL),
 (2,15,58,NULL,NULL),
 (2,14,59,NULL,NULL),
 (2,15,59,NULL,NULL),
 (2,11,60,NULL,NULL),
 (2,12,60,NULL,NULL),
 (2,9,61,NULL,NULL),
 (2,10,61,NULL,NULL),
 (2,11,61,NULL,NULL),
 (2,12,61,NULL,NULL),
 (2,12,62,NULL,NULL),
 (3,13,62,NULL,NULL),
 (3,10,63,NULL,NULL),
 (3,11,63,NULL,NULL),
 (2,12,63,NULL,NULL),
 (3,13,63,NULL,NULL),
 (2,12,64,NULL,NULL),
 (2,13,64,NULL,NULL),
 (2,11,65,NULL,NULL),
 (2,12,65,NULL,NULL),
 (2,13,65,NULL,NULL),
 (2,11,66,NULL,NULL),
 (2,12,66,NULL,NULL),
 (2,10,67,NULL,NULL),
 (2,11,67,NULL,NULL),
 (2,12,67,NULL,NULL),
 (2,11,68,NULL,NULL),
 (2,12,68,NULL,NULL),
 (2,10,69,NULL,NULL),
 (2,11,69,NULL,NULL),
 (2,12,69,NULL,NULL),
 (2,9,70,NULL,NULL),
 (2,12,70,NULL,NULL),
 (2,13,70,NULL,NULL),
 (2,9,71,NULL,NULL),
 (2,10,71,NULL,NULL),
 (2,11,71,NULL,NULL),
 (2,12,71,NULL,NULL),
 (2,13,71,NULL,NULL),
 (2,11,72,NULL,NULL),
 (2,12,72,NULL,NULL),
 (2,12,73,NULL,NULL),
 (2,13,73,NULL,NULL),
 (2,11,74,NULL,NULL),
 (2,12,74,NULL,NULL),
 (2,13,74,NULL,NULL),
 (2,13,75,NULL,NULL),
 (2,14,75,NULL,NULL),
 (2,15,75,NULL,NULL),
 (2,12,76,NULL,NULL),
 (2,13,76,NULL,NULL),
 (2,14,76,NULL,NULL),
 (2,15,76,NULL,NULL),
 (2,12,77,NULL,NULL),
 (2,13,77,NULL,NULL),
 (2,11,78,NULL,NULL),
 (2,12,78,NULL,NULL),
 (2,13,78,NULL,NULL),
 (2,12,79,NULL,NULL),
 (2,13,79,NULL,NULL),
 (2,10,80,NULL,NULL),
 (2,11,80,NULL,NULL),
 (2,12,80,NULL,NULL),
 (2,13,80,NULL,NULL),
 (2,12,81,NULL,NULL),
 (2,13,81,NULL,NULL),
 (2,12,82,NULL,NULL),
 (2,13,82,NULL,NULL),
 (2,7,83,NULL,NULL),
 (2,8,83,NULL,NULL),
 (2,7,84,NULL,NULL),
 (2,8,84,NULL,NULL),
 (2,7,85,NULL,NULL),
 (2,8,85,NULL,NULL),
 (2,7,86,NULL,NULL),
 (2,8,86,NULL,NULL),
 (2,12,87,NULL,NULL),
 (2,13,87,NULL,NULL),
 (2,12,88,NULL,NULL),
 (2,13,88,NULL,NULL),
 (2,12,89,NULL,NULL),
 (2,13,89,NULL,NULL),
 (2,11,90,NULL,NULL),
 (2,12,90,NULL,NULL),
 (2,13,90,NULL,NULL),
 (2,9,91,NULL,NULL),
 (2,10,91,NULL,NULL),
 (2,8,92,NULL,NULL),
 (2,9,92,NULL,NULL),
 (2,10,92,NULL,NULL),
 (2,7,93,NULL,NULL),
 (2,8,93,NULL,NULL),
 (2,12,94,NULL,NULL),
 (2,13,94,NULL,NULL),
 (2,11,95,NULL,NULL),
 (2,12,95,NULL,NULL),
 (2,13,95,NULL,NULL),
 (2,11,96,NULL,NULL),
 (2,12,96,NULL,NULL),
 (2,11,97,NULL,NULL),
 (2,12,97,NULL,NULL),
 (2,12,98,NULL,NULL),
 (2,11,99,NULL,NULL),
 (2,12,99,NULL,NULL),
 (2,12,100,NULL,NULL),
 (2,13,100,NULL,NULL),
 (2,11,101,NULL,NULL),
 (2,12,101,NULL,NULL),
 (2,13,101,NULL,NULL),
 (2,11,102,NULL,NULL),
 (2,12,102,NULL,NULL),
 (2,12,103,NULL,NULL),
 (2,13,103,NULL,NULL),
 (2,11,104,NULL,NULL),
 (2,12,104,NULL,NULL),
 (2,13,104,NULL,NULL),
 (2,10,105,NULL,NULL),
 (2,11,105,NULL,NULL),
 (2,12,105,NULL,NULL),
 (2,13,105,NULL,NULL),
 (2,9,106,NULL,NULL),
 (2,10,106,NULL,NULL),
 (2,11,106,NULL,NULL),
 (2,12,106,NULL,NULL),
 (2,13,106,NULL,NULL),
 (2,12,108,NULL,NULL),
 (2,14,108,NULL,NULL),
 (2,15,108,NULL,NULL),
 (2,10,109,NULL,NULL),
 (2,11,109,NULL,NULL),
 (2,12,109,NULL,NULL),
 (2,14,109,NULL,NULL),
 (2,15,109,NULL,NULL),
 (2,12,110,NULL,NULL),
 (2,13,110,NULL,NULL),
 (2,10,111,NULL,NULL),
 (2,11,111,NULL,NULL),
 (2,12,111,NULL,NULL),
 (2,13,111,NULL,NULL),
 (2,11,112,NULL,NULL),
 (2,12,112,NULL,NULL),
 (2,13,112,NULL,NULL),
 (2,8,113,NULL,NULL),
 (2,9,114,NULL,NULL),
 (2,8,115,NULL,NULL),
 (2,8,116,NULL,NULL),
 (2,9,116,NULL,NULL),
 (2,11,117,NULL,NULL),
 (2,12,117,NULL,NULL),
 (2,11,118,NULL,NULL),
 (2,12,118,NULL,NULL),
 (2,10,119,NULL,NULL),
 (2,11,119,NULL,NULL),
 (2,12,119,NULL,NULL),
 (2,9,120,NULL,NULL),
 (2,10,120,NULL,NULL),
 (2,11,120,NULL,NULL),
 (2,14,121,NULL,NULL),
 (2,15,121,NULL,NULL),
 (2,13,122,NULL,NULL),
 (2,14,122,NULL,NULL),
 (2,15,122,NULL,NULL),
 (2,7,123,NULL,NULL),
 (2,8,123,NULL,NULL),
 (2,9,123,NULL,NULL),
 (2,7,124,NULL,NULL),
 (2,8,124,NULL,NULL),
 (2,9,124,NULL,NULL),
 (2,7,125,NULL,NULL),
 (2,8,125,NULL,NULL),
 (2,9,125,NULL,NULL),
 (2,10,125,NULL,NULL),
 (3,11,125,NULL,NULL),
 (2,7,126,NULL,NULL),
 (2,8,126,NULL,NULL),
 (2,9,126,NULL,NULL),
 (2,10,126,NULL,NULL),
 (3,11,126,NULL,NULL),
 (56,12,126,NULL,NULL),
 (45,13,126,NULL,NULL),
 (23,7,127,NULL,NULL),
 (3,7,128,NULL,NULL),
 (3,7,129,NULL,NULL),
 (4,8,129,NULL,NULL),
 (5,10,129,NULL,NULL),
 (2,7,130,NULL,NULL),
 (2,8,130,NULL,NULL),
 (2,7,131,NULL,NULL),
 (2,8,131,NULL,NULL),
 (2,7,132,1000,500),
 (2,8,132,1000,500),
 (2,8,133,1000,600),
 (2,10,133,1000,600),
 (2,8,134,NULL,NULL),
 (2,10,134,NULL,NULL),
 (2,8,135,NULL,NULL),
 (2,10,135,NULL,NULL),
 (2,8,136,NULL,NULL),
 (2,10,136,NULL,NULL),
 (2,8,137,NULL,NULL),
 (2,10,137,NULL,NULL),
 (800,11,137,NULL,NULL),
 (4,8,138,NULL,NULL),
 (500,13,138,NULL,NULL),
 (2,8,139,1000,500),
 (3,10,139,1000,500);
/*!40000 ALTER TABLE `details_vente` ENABLE KEYS */;


--
-- Definition of table `employe`
--

DROP TABLE IF EXISTS `employe`;
CREATE TABLE `employe` (
  `num_employe` int(11) NOT NULL AUTO_INCREMENT,
  `nom_employe` varchar(20) DEFAULT NULL,
  `prenom_employe` varchar(20) DEFAULT NULL,
  `date_naiss` date DEFAULT NULL,
  `date_embauche` date DEFAULT NULL,
  `addresse` varchar(20) DEFAULT NULL,
  `num_tel` int(50) DEFAULT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(30) DEFAULT NULL,
  `photo` varchar(400) NOT NULL,
  PRIMARY KEY (`num_employe`,`login`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employe`
--

/*!40000 ALTER TABLE `employe` DISABLE KEYS */;
INSERT INTO `employe` (`num_employe`,`nom_employe`,`prenom_employe`,`date_naiss`,`date_embauche`,`addresse`,`num_tel`,`login`,`password`,`photo`) VALUES 
 (24,'LINDA','essi','2013-01-18','2013-01-19','lome',92916717,'essi','lili','C:_Users_linda_Documents_NetBeansProjects_Boutique_src_images_User-Female.jpg'),
 (28,'KALNON','pallaye','2013-01-18','2013-01-19','lome',929163333,'pallaye','pallaye','C:_Users_linda_Documents_NetBeansProjects_Boutique_src_images_fourni.jpg'),
 (30,'WOKPO','octave','2013-01-19','2013-01-31','lome',900000000,'octave','octave','C:_Users_linda_Documents_NetBeansProjects_Boutique_src_Photo_images_031.jpeg');
/*!40000 ALTER TABLE `employe` ENABLE KEYS */;


--
-- Definition of table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE `fournisseur` (
  `code_fournisseur` int(11) NOT NULL AUTO_INCREMENT,
  `societe` varchar(25) DEFAULT NULL,
  `e_mail` varchar(25) DEFAULT NULL,
  `num_tel` int(50) DEFAULT NULL,
  `addresse` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`code_fournisseur`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fournisseur`
--

/*!40000 ALTER TABLE `fournisseur` DISABLE KEYS */;
INSERT INTO `fournisseur` (`code_fournisseur`,`societe`,`e_mail`,`num_tel`,`addresse`) VALUES 
 (2,'lome','fff@gmail.com',222027,'lome'),
 (3,'sangera','fff@gmail.com',22202794,'lome');
/*!40000 ALTER TABLE `fournisseur` ENABLE KEYS */;


--
-- Definition of table `produit`
--

DROP TABLE IF EXISTS `produit`;
CREATE TABLE `produit` (
  `reference_produit` int(11) NOT NULL AUTO_INCREMENT,
  `prix_unitaire_produit` int(11) NOT NULL,
  `quantite_par_unite` int(11) DEFAULT NULL,
  `designation` varchar(50) DEFAULT NULL,
  `code_fournisseur` int(11) DEFAULT NULL,
  `code_categorie` int(11) DEFAULT NULL,
  `unite` int(11) DEFAULT NULL,
  PRIMARY KEY (`reference_produit`),
  KEY `fk_code_fournisseur` (`code_fournisseur`),
  KEY `fk_code_categorie` (`code_categorie`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produit`
--

/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` (`reference_produit`,`prix_unitaire_produit`,`quantite_par_unite`,`designation`,`code_fournisseur`,`code_categorie`,`unite`) VALUES 
 (8,100,288,'vivalait',1,3,34),
 (10,100,291,'sosiss',1,3,69),
 (12,100,300,'stylo',1,3,69),
 (13,100,300,'crayon',1,3,69),
 (14,250,300,'spagetti',1,3,69),
 (15,400,300,'sardine',1,3,100),
 (16,222,450,'vivalit',1,1,23);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;


--
-- Definition of table `vente`
--

DROP TABLE IF EXISTS `vente`;
CREATE TABLE `vente` (
  `num_vente` int(11) NOT NULL AUTO_INCREMENT,
  `code_client` int(11) DEFAULT NULL,
  `date` date NOT NULL,
  `login` varchar(30) NOT NULL,
  PRIMARY KEY (`num_vente`) USING BTREE,
  KEY `code_client` (`code_client`),
  KEY `fk_login_login` (`login`)
) ENGINE=MyISAM AUTO_INCREMENT=140 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vente`
--

/*!40000 ALTER TABLE `vente` DISABLE KEYS */;
INSERT INTO `vente` (`num_vente`,`code_client`,`date`,`login`) VALUES 
 (1,10,'2012-12-21','VVVVVVVV'),
 (2,12,'2012-12-21','eeeee'),
 (3,10,'2012-12-14','VVVVVVVV'),
 (4,13,'2012-12-13','VVVVVVVV'),
 (5,10,'2012-12-06','VVVVVVVV'),
 (6,12,'2012-12-05','VVVVVVVV'),
 (7,10,'2012-12-06','VVVVVVVV'),
 (8,10,'2012-12-07','VVVVVVVV'),
 (9,10,'2012-12-07','VVVVVVVV'),
 (10,10,'2012-12-13','VVVVVVVV'),
 (11,10,'2012-12-22','VVVVVVVV'),
 (12,10,'2012-12-22','VVVVVVVV'),
 (13,10,'2012-12-22','VVVVVVVV'),
 (14,10,'2012-12-22','VVVVVVVV'),
 (15,10,'2012-12-22','VVVVVVVV'),
 (16,12,'2012-12-19','VVVVVVVV'),
 (17,12,'2012-12-14','VVVVVVVV'),
 (18,10,'2012-12-14','VVVVVVVV'),
 (19,10,'2012-12-14','VVVVVVVV'),
 (20,10,'2012-12-27','VVVVVVVV'),
 (21,10,'2012-12-21','eeeee'),
 (22,10,'2012-12-14','VVVVVVVV'),
 (23,10,'2012-12-19','VVVVVVVV'),
 (24,10,'2012-12-08','VVVVVVVV'),
 (25,10,'2012-12-07','VVVVVVVV'),
 (26,10,'2012-12-08','VVVVVVVV'),
 (27,10,'2012-12-08','VVVVVVVV'),
 (28,10,'2012-12-14','VVVVVVVV'),
 (29,10,'2012-12-07','VVVVVVVV'),
 (30,10,'2012-12-01','VVVVVVVV'),
 (31,10,'2012-12-14','VVVVVVVV'),
 (32,10,'2012-12-22','VVVVVVVV'),
 (33,10,'2012-12-21','VVVVVVVV'),
 (34,10,'2012-12-22','VVVVVVVV'),
 (35,10,'2012-12-22','VVVVVVVV'),
 (36,10,'2012-12-21','eeeee'),
 (37,10,'2012-12-21','VVVVVVVV'),
 (38,10,'2012-12-21','VVVVVVVV'),
 (39,10,'2012-12-07','VVVVVVVV'),
 (40,10,'2012-12-07','VVVVVVVV'),
 (41,10,'2012-12-07','VVVVVVVV'),
 (42,10,'2012-12-07','VVVVVVVV'),
 (43,10,'2012-12-07','VVVVVVVV'),
 (44,10,'2012-12-05','VVVVVVVV'),
 (45,10,'2012-12-05','VVVVVVVV'),
 (46,10,'2012-12-14','VVVVVVVV'),
 (47,10,'2012-12-14','VVVVVVVV'),
 (48,10,'2012-12-08','VVVVVVVV'),
 (49,10,'2012-12-08','eeeee'),
 (50,10,'2012-12-08','eeeee'),
 (51,10,'2012-12-15','VVVVVVVV'),
 (52,10,'2012-12-08','VVVVVVVV'),
 (53,10,'2012-12-07','VVVVVVVV'),
 (54,10,'2012-12-14','VVVVVVVV'),
 (55,10,'2012-12-07','VVVVVVVV'),
 (56,10,'2012-12-07','VVVVVVVV'),
 (57,10,'2012-12-07','VVVVVVVV'),
 (58,10,'2012-12-14','VVVVVVVV'),
 (59,10,'2012-12-07','VVVVVVVV'),
 (60,10,'2012-12-01','VVVVVVVV'),
 (61,10,'2012-12-01','VVVVVVVV'),
 (62,10,'2012-12-08','VVVVVVVV'),
 (63,10,'2012-12-08','VVVVVVVV'),
 (64,10,'2012-12-21','VVVVVVVV'),
 (65,10,'2012-12-21','VVVVVVVV'),
 (66,10,'2012-12-01','VVVVVVVV'),
 (67,10,'2012-12-01','VVVVVVVV'),
 (68,10,'2012-12-07','VVVVVVVV'),
 (69,10,'2012-12-07','VVVVVVVV'),
 (70,10,'2012-12-15','eeeee'),
 (71,10,'2012-12-15','eeeee'),
 (72,10,'2012-12-01','VVVVVVVV'),
 (73,10,'2012-12-08','VVVVVVVV'),
 (74,10,'2012-12-08','VVVVVVVV'),
 (75,10,'2012-12-13','VVVVVVVV'),
 (76,10,'2012-12-13','VVVVVVVV'),
 (77,10,'2012-12-08','VVVVVVVV'),
 (78,10,'2012-12-08','VVVVVVVV'),
 (79,10,'2012-12-07','VVVVVVVV'),
 (80,10,'2012-12-07','VVVVVVVV'),
 (81,10,'2012-12-01','VVVVVVVV'),
 (82,10,'2012-12-01','VVVVVVVV'),
 (83,10,'2012-12-02','VVVVVVVV'),
 (84,10,'2012-12-02','VVVVVVVV'),
 (85,10,'2012-12-02','VVVVVVVV'),
 (86,10,'2012-12-02','VVVVVVVV'),
 (87,10,'2012-12-02','VVVVVVVV'),
 (88,10,'2012-12-02','VVVVVVVV'),
 (89,10,'2012-12-01','VVVVVVVV'),
 (90,10,'2012-12-01','VVVVVVVV'),
 (91,10,'2012-12-01','VVVVVVVV'),
 (92,10,'2012-12-01','VVVVVVVV'),
 (93,10,'2012-12-01','VVVVVVVV'),
 (94,10,'2012-12-01','VVVVVVVV'),
 (95,10,'2012-12-01','VVVVVVVV'),
 (96,10,'2012-12-08','VVVVVVVV'),
 (97,10,'2012-12-08','VVVVVVVV'),
 (98,10,'2012-12-02','VVVVVVVV'),
 (99,10,'2012-12-02','VVVVVVVV'),
 (100,10,'2012-12-01','VVVVVVVV'),
 (101,10,'2012-12-01','VVVVVVVV'),
 (102,10,'2012-12-01','VVVVVVVV'),
 (103,10,'2012-12-08','VVVVVVVV'),
 (104,10,'2012-12-08','VVVVVVVV'),
 (105,10,'2012-12-08','VVVVVVVV'),
 (106,10,'2012-12-08','VVVVVVVV'),
 (107,10,'2012-12-08','VVVVVVVV'),
 (108,10,'2012-12-01','VVVVVVVV'),
 (109,10,'2012-12-01','VVVVVVVV'),
 (110,10,'2012-12-08','VVVVVVVV'),
 (111,10,'2012-12-08','VVVVVVVV'),
 (112,10,'2012-12-01','VVVVVVVV'),
 (113,10,'2012-12-01','VVVVVVVV'),
 (114,10,'2012-12-08','VVVVVVVV'),
 (115,10,'2012-12-07','VVVVVVVV'),
 (116,10,'2012-12-07','VVVVVVVV'),
 (117,10,'2012-12-08','VVVVVVVV'),
 (118,10,'2012-12-01','VVVVVVVV'),
 (119,10,'2012-12-01','VVVVVVVV'),
 (120,10,'2012-12-08','VVVVVVVV'),
 (121,10,'2012-12-18','VVVVVVVV'),
 (122,10,'2012-12-18','VVVVVVVV'),
 (123,12,'2012-12-18','eeeee'),
 (124,12,'2012-12-18','eeeee'),
 (125,12,'2012-12-18','eeeee'),
 (126,12,'2012-12-18','eeeee'),
 (127,10,'2012-12-29','VVVVVVVV'),
 (128,10,'2012-12-29','VVVVVVVV'),
 (129,10,'2013-01-03','essi'),
 (130,10,'2013-01-03','essi'),
 (131,10,'2013-01-03','essi'),
 (132,10,'2013-01-03','essi'),
 (133,10,'2013-01-03','essi'),
 (134,20,'2013-01-04','essi'),
 (135,20,'2013-01-04','essi'),
 (136,20,'2013-01-04','essi'),
 (137,20,'2013-01-04','essi'),
 (138,20,'2013-01-04','essi'),
 (139,20,'2013-01-04','essi');
/*!40000 ALTER TABLE `vente` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
