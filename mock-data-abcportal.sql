CREATE DATABASE  IF NOT EXISTS `portal` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `portal`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: portal
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.38-MariaDB

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
-- Table structure for table `attachments`
--

DROP TABLE IF EXISTS `attachments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attachments` (
  `attach_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Index for attachments',
  `attach_name` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'attachment name',
  `attach_file` blob COMMENT 'space to store the attachment',
  `thr_msg_id` int(11) NOT NULL COMMENT 'foreign key from threadmessage',
  PRIMARY KEY (`attach_id`),
  KEY `attachments_ibfk_1` (`thr_msg_id`),
  CONSTRAINT `attachments_ibfk_1` FOREIGN KEY (`thr_msg_id`) REFERENCES `threadmessage` (`thr_msg_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachments`
--

LOCK TABLES `attachments` WRITE;
/*!40000 ALTER TABLE `attachments` DISABLE KEYS */;
INSERT INTO `attachments` VALUES (1,'Clint','',1),(2,'Antonie','',2),(6,'Marilyn','',6),(8,'Mattie','',8),(9,'Burlie','',9);
/*!40000 ALTER TABLE `attachments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bulkemail`
--

DROP TABLE IF EXISTS `bulkemail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bulkemail` (
  `bulk_email_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'index for bulk email',
  `sender_email` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'name of email creator',
  `email_subject` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'email subject',
  `email_message` text COLLATE utf8_bin NOT NULL COMMENT 'the message inside the email',
  `email_cc` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'email carbon copy',
  `email_bcc` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'email blind carbon copy',
  `email_recipient` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'recipient/s of the email',
  `user_id` int(11) NOT NULL COMMENT 'foreign key from table `user`',
  PRIMARY KEY (`bulk_email_id`),
  KEY `user_id` (`user_id`) USING BTREE,
  CONSTRAINT `bulkemail_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bulkemail`
--

LOCK TABLES `bulkemail` WRITE;
/*!40000 ALTER TABLE `bulkemail` DISABLE KEYS */;
INSERT INTO `bulkemail` VALUES (1,'ctupper0@techcrunch.com','core','Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.','npeterkin0@lycos.com','rodonohue0@google.it','Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.',1),(2,'tkanzler1@163.com','Versatile','Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.','lclunie1@hao123.com','acavill1@goo.ne.jp','Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue.',2),(3,'tantoney2@gizmodo.com','demand-driven','Fusce consequat. Nulla nisl. Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.','ptutt2@cocolog-nifty.com','wjones2@nsw.gov.au','Mauris lacinia sapien quis libero. Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.',3),(4,'aanstice3@bbb.org','Future-proofed','Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh.','ehugin3@imgur.com','aacomb3@weebly.com','Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.',4),(5,'nkollatsch4@columbia.edu','Centralized','In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue.','thaggerty4@feedburner.com','jgarlett4@mozilla.com','Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio.',5),(6,'emccarlich5@accuweather.com','uniform','Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.','nsimmon5@abc.net.au','rraise5@redcross.org','Fusce consequat. Nulla nisl. Nunc nisl.',6),(7,'cluce6@skype.com','even-keeled','Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.','psowood6@ft.com','lrenon6@ca.gov','Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.',7),(8,'gpalleske7@sciencedaily.com','directional','Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.','nmacshirrie7@wikimedia.org','dmcgrey7@people.com.cn','Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla.',8),(9,'brutt8@upenn.edu','software','Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor.','dbattisson8@zdnet.com','llammertz8@creativecommons.org','Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.',9),(10,'dbloan9@go.com','Reactive','Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo.','tespino9@chicagotribune.com','bdacosta9@php.net','Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum e',10);
/*!40000 ALTER TABLE `bulkemail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emailattachment`
--

DROP TABLE IF EXISTS `emailattachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `emailattachment` (
  `email_att_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'index of email attachments',
  `email_att_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'email attachment name',
  `email_att_file` blob COMMENT 'attachment file',
  `bulk_email_id` int(11) NOT NULL COMMENT 'foreign key from `bulkemail`',
  PRIMARY KEY (`email_att_id`),
  KEY `bulk_email_id` (`bulk_email_id`),
  CONSTRAINT `emailattachment_ibfk_1` FOREIGN KEY (`bulk_email_id`) REFERENCES `bulkemail` (`bulk_email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailattachment`
--

LOCK TABLES `emailattachment` WRITE;
/*!40000 ALTER TABLE `emailattachment` DISABLE KEYS */;
INSERT INTO `emailattachment` VALUES (1,'Fuzzytongue Penstemon','',1),(2,'Hackberry Beardtongue','',2),(3,'Narrowleaf Rose Gentian','',3),(4,'Dwarf Bristle Fern','',4),(5,'Slender-leaf Sandwort','',5),(6,'Simple Campion','',8),(7,'White Locoweed','',7),(8,'Cumberland Stitchwort','',6),(9,'Southern Balsampear','',9),(10,'Calla Lily','',10);
/*!40000 ALTER TABLE `emailattachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'job index',
  `job_title` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'title of job',
  `job_scope` text COLLATE utf8_bin NOT NULL COMMENT 'job description',
  `job_salary` varchar(100) COLLATE utf8_bin NOT NULL COMMENT 'indicates job salary',
  `job_availability` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'either open or closed',
  `user_id` int(11) NOT NULL COMMENT 'foreign key from table `user`',
  PRIMARY KEY (`job_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `job_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,'Testing','short description.','$1000.00','Open',1),(2,'Senior Financial Analyst','Analyse some monies','$16000','Open',2),(3,'Assistant Media Planner','Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.','$4385.90','Closed',2),(4,'Automation Specialist III','you automate some stuff','$2316.86','Closed',4),(5,'Marketing Assistant','Phasellus in felis. Donec semper sapien a libero. Nam dui.','$3628.12','Closed',5),(6,'Social Worker','Aliquam erat volutpat. In congue. Etiam justo. Etiam pretium iaculis justo.','$1884.88','Closed',6),(7,'Associate Professor','Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est. Phasellus sit amet erat. Nulla tempus.','$3436.53','Closed',7),(8,'Librarian','Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.','$2197.54','Closed',8),(10,'DXC Janitor','Sweep floor while developers develop shit','$100','Open',2);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_user`
--

DROP TABLE IF EXISTS `job_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_user` (
  `job_id` int(11) NOT NULL COMMENT 'index from job',
  `user_id` int(11) NOT NULL COMMENT 'index from user',
  KEY `job_id` (`job_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `job_user_ibfk_1` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `job_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_user`
--

LOCK TABLES `job_user` WRITE;
/*!40000 ALTER TABLE `job_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privatemessage`
--

DROP TABLE IF EXISTS `privatemessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privatemessage` (
  `priv_msg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'private message index',
  `priv_msg_sender` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'creator of the private message',
  `priv_msg_text` text COLLATE utf8_bin NOT NULL COMMENT 'content of private message',
  `priv_msg_att` blob COMMENT 'user can add attachment inside their private message',
  `user_id` int(11) NOT NULL COMMENT 'foreign key from user',
  PRIMARY KEY (`priv_msg_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `privatemessage_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privatemessage`
--

LOCK TABLES `privatemessage` WRITE;
/*!40000 ALTER TABLE `privatemessage` DISABLE KEYS */;
INSERT INTO `privatemessage` VALUES (1,'Gabrila','Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.','',1),(2,'Diena','Praesent lectus. Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.','',2),(3,'Gabie','Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.','',3),(4,'Marshal','In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat. Curabitur gravida nisi at nibh.','',4),(5,'Symon','Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.','',5),(6,'Meghann','Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus.','',6),(7,'Maddy','Proin eu mi. Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem. Duis aliquam convallis nunc.','',7),(8,'Cicely','Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus. Pellentesque eget nunc. Donec quis orci eget orci vehicula condimentum.','',8),(9,'Cassondra','Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna.','',9);
/*!40000 ALTER TABLE `privatemessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privatemessagerecipient`
--

DROP TABLE IF EXISTS `privatemessagerecipient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `privatemessagerecipient` (
  `prvi_msg_rec_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'index of private message recipient',
  `priv_msg_rec_user` text COLLATE utf8_bin NOT NULL COMMENT 'name of recipient',
  `priv_msg_id` int(11) NOT NULL COMMENT 'foreign key from privatemessage',
  PRIMARY KEY (`prvi_msg_rec_id`),
  KEY `priv_msg_id` (`priv_msg_id`),
  CONSTRAINT `privatemessagerecipient_ibfk_1` FOREIGN KEY (`priv_msg_id`) REFERENCES `privatemessage` (`priv_msg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privatemessagerecipient`
--

LOCK TABLES `privatemessagerecipient` WRITE;
/*!40000 ALTER TABLE `privatemessagerecipient` DISABLE KEYS */;
INSERT INTO `privatemessagerecipient` VALUES (1,'Crista',1),(2,'Ivonne',2),(3,'Ron',3),(4,'Ethelin',4),(5,'Enos',5),(6,'Charmine',6),(7,'Saunder',7),(8,'Ruperto',8),(9,'Becca',9);
/*!40000 ALTER TABLE `privatemessagerecipient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qualifications`
--

DROP TABLE IF EXISTS `qualifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qualifications` (
  `qual_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'qualification index',
  `qual_name` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'qualification name',
  `qual_date_achieved` date NOT NULL COMMENT 'date where qualificatio was attained',
  `qual_file_attach` blob COMMENT 'qualification file attachment',
  `user_id` int(11) NOT NULL COMMENT 'foreign key from user',
  PRIMARY KEY (`qual_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `qualifications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qualifications`
--

LOCK TABLES `qualifications` WRITE;
/*!40000 ALTER TABLE `qualifications` DISABLE KEYS */;
INSERT INTO `qualifications` VALUES (1,'Utilization','2018-05-10',NULL,1),(2,'Utilization','2018-05-10',NULL,1),(3,'Utilization','2018-05-10',NULL,1),(4,'Utilization','2018-05-10',NULL,2),(5,'Utilization','2018-05-10',NULL,7),(6,'Utilization','2018-05-10',NULL,8),(7,'Utilization','2018-05-10',NULL,8),(8,'Utilization','2018-05-10',NULL,10),(10,'Utilization','2018-05-10',NULL,1);
/*!40000 ALTER TABLE `qualifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skills`
--

DROP TABLE IF EXISTS `skills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skills` (
  `skills_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'skills index',
  `skills_name` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'name of skill',
  `skills_proficiency` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'skill level',
  `user_id` int(11) NOT NULL COMMENT 'foreign key from user',
  PRIMARY KEY (`skills_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `skills_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skills`
--

LOCK TABLES `skills` WRITE;
/*!40000 ALTER TABLE `skills` DISABLE KEYS */;
INSERT INTO `skills` VALUES (1,'CPIM','Duis mattis egestas metus.',1),(2,'Business Strategy','Quisque id justo sit amet sapien dignissim vestibu',2),(3,'CMMI Level 5','Fusce consequat.',3),(4,'Omeka','Cum sociis natoque penatibus et magnis dis parturi',4),(5,'UED','Donec diam neque, vestibulum eget, vulputate ut, u',5),(6,'TTL','Morbi non quam nec dui luctus rutrum. Nulla tellus',6),(7,'NLRB','Integer pede justo, lacinia eget, tincidunt eget, ',7),(9,'XUL','Duis at velit eu est congue elementum. In hac habi',9),(10,'Financial Accounting','Nam ultrices, libero non mattis pulvinar, nulla pe',10);
/*!40000 ALTER TABLE `skills` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thread`
--

DROP TABLE IF EXISTS `thread`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thread` (
  `thr_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'thread index',
  `thr_subject` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'subject of thread',
  `user_id` int(11) NOT NULL COMMENT 'foreign key from user',
  PRIMARY KEY (`thr_id`),
  KEY `thread_ibfk_1` (`user_id`),
  CONSTRAINT `thread_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thread`
--

LOCK TABLES `thread` WRITE;
/*!40000 ALTER TABLE `thread` DISABLE KEYS */;
INSERT INTO `thread` VALUES (1,'CSGO',1),(3,'Sbubby',3),(4,'10gag',4),(5,'kekeke',5),(6,'Stories',6),(7,'Exclusive News!',7),(8,'Chinese v2',8);
/*!40000 ALTER TABLE `thread` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `threadmessage`
--

DROP TABLE IF EXISTS `threadmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `threadmessage` (
  `thr_msg_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'thread message index',
  `thr_msg_text` text COLLATE utf8_bin COMMENT 'content of thread message',
  `thr_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`thr_msg_id`),
  KEY `ibfk_thr_id_idx` (`thr_id`),
  KEY `ibfk_user_id_idx` (`user_id`),
  CONSTRAINT `ibfk_thr_id` FOREIGN KEY (`thr_id`) REFERENCES `thread` (`thr_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ibfk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `threadmessage`
--

LOCK TABLES `threadmessage` WRITE;
/*!40000 ALTER TABLE `threadmessage` DISABLE KEYS */;
INSERT INTO `threadmessage` VALUES (1,'Sed accumsan felis. Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla. Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.',1,9),(2,'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem. Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti.',1,9),(6,'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam vel augue.',5,9),(8,'Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl. Nunc nisl.',3,9),(9,'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque. Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl.',4,9),(11,'Test Message HEre',6,9),(16,'wo shi hua ren!',8,2),(18,'oi',7,2),(21,'Huh',7,2),(38,'what',1,2),(42,'Yeehaw',7,2),(43,'I got in to DXC?!',7,2),(44,'nani!',7,2),(45,'whefasfdsa',1,22),(46,'SO WHATS NEW',1,22),(47,'gwefadsfa',7,22),(48,'wfwf',8,22),(49,'wfdsafdsa',1,22),(50,'wfdsafdsa',1,2),(51,'fdsfa',7,22),(52,'fadsfa',1,22),(53,'fdsfads',1,22),(54,'what',1,22),(56,'fd',8,2),(57,'fdsawtf',1,2),(58,'fdsa',6,2),(59,'csgo',1,2);
/*!40000 ALTER TABLE `threadmessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user index',
  `user_firstname` varchar(35) COLLATE utf8_bin NOT NULL COMMENT 'first name of user',
  `user_lastname` varchar(35) COLLATE utf8_bin NOT NULL COMMENT 'last name of user',
  `user_email` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'email of user; also used as login credentials',
  `user_password` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'password of user; used as login credentials',
  `user_birthday` date NOT NULL COMMENT 'birthday of user',
  `user_gender` varchar(7) COLLATE utf8_bin NOT NULL COMMENT 'gender of user; either male or female',
  `user_country` varchar(75) COLLATE utf8_bin NOT NULL COMMENT 'country of user',
  `user_picture` varchar(400) COLLATE utf8_bin DEFAULT NULL COMMENT 'profile picture of user',
  `user_resume` varchar(4000) COLLATE utf8_bin DEFAULT NULL COMMENT 'resume file of user',
  `user_role` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'role of user; either admin or sp',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'yong','xin','test1@gmail.com','123456','2019-08-29','male','Other',NULL,NULL,'SP'),(2,'Admin','Admin','test2@gmail.com','123456','1996-01-10','male','Singapore',NULL,NULL,'Admin'),(3,'Mikasa','Ackerman','test3@gmail.com','123456','1995-01-12','male','Japan',NULL,NULL,'Admin'),(4,'John','testdev','test4@gmail.com','123456','1995-10-01','female','Malaysia',NULL,NULL,'SP'),(5,'John','testdev','test5@gmail.com','123456','1990-01-01','male','USA',NULL,NULL,'SP'),(6,'John','testdev','test6@gmail.com','123456','2001-01-01','male','USA',NULL,NULL,'Admin'),(7,'John','testdev','test7@gmail.com','123456','1987-01-01','male','Russia',NULL,NULL,'SP'),(8,'John','testdev','test8@gmail.com','123456','1990-01-01','male','Russia',NULL,NULL,'Admin'),(9,'John','testdev','test9@gmail.com','123456','1987-01-01','male','Brazil',NULL,NULL,'SP'),(10,'John','testdev','test10@gmail.com','123456','1995-01-02','male','Sweden',NULL,NULL,'SP'),(11,'John','testdev','tester@tester.com','123456','2019-08-06','Male','Singapore',NULL,NULL,'SP'),(22,'hahaaha','hahahaha','a@a','1234','1995-01-01','Female','Malaysia',NULL,NULL,'SP'),(23,'nas','nas','nas@nas','fdsa','1995-01-01','Female','Singapore',NULL,NULL,'SP'),(24,'fdsa','fdsa','fdsa@fdsa','fdsa','1995-01-01','Female','Singapore',NULL,NULL,'SP'),(25,'adsf','adsf','fdsfs@fdsafdfafsa','asdf','1995-01-01','Female','Singapore',NULL,NULL,'SP');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `view_totaluser`
--

DROP TABLE IF EXISTS `view_totaluser`;
/*!50001 DROP VIEW IF EXISTS `view_totaluser`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_totaluser` AS SELECT 
 1 AS `COUNT(user_id)`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `view_userrolesp`
--

DROP TABLE IF EXISTS `view_userrolesp`;
/*!50001 DROP VIEW IF EXISTS `view_userrolesp`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_userrolesp` AS SELECT 
 1 AS `COUNT(user_id)`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `workexp`
--

DROP TABLE IF EXISTS `workexp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workexp` (
  `workexp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'index of work experience',
  `workexp_title` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'title of work experience',
  `workexp_desc` varchar(100) COLLATE utf8_bin NOT NULL COMMENT 'description of work experience',
  `workexp_start` date NOT NULL COMMENT 'start date of work',
  `workexp_end` date NOT NULL COMMENT 'end date of work',
  `user_id` int(11) NOT NULL COMMENT 'foreign key from user',
  PRIMARY KEY (`workexp_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `workexp_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workexp`
--

LOCK TABLES `workexp` WRITE;
/*!40000 ALTER TABLE `workexp` DISABLE KEYS */;
INSERT INTO `workexp` VALUES (1,'Staff Scientist','In quis justo.','2009-12-19','2014-07-11',1),(2,'Staff Scientist','Quisque ut erat. Curabitur gravida nisi at nibh. In hac habitasse platea dictumst.','2005-03-09','2011-06-18',2),(3,'VP Sales','Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobo','2003-03-16','2018-03-06',3),(4,'Design Engineer','Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tin','2009-03-16','2019-05-17',4),(5,'Analog Circuit Design manager','Sed vel enim sit amet nunc viverra dapibus. Nulla suscipit ligula in lacus.','2001-01-22','2014-03-02',5),(6,'Account Representative II','Ut tellus.','2006-05-01','2018-04-21',6),(7,'Data Coordiator','Pellentesque at nulla. Suspendisse potenti.','2009-04-25','2017-06-17',7),(8,'Paralegal','Phasellus in felis.','2001-09-02','2011-11-21',8),(9,'Compensation Analyst','Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rh','2008-04-16','2012-08-10',9);
/*!40000 ALTER TABLE `workexp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'portal'
--

--
-- Dumping routines for database 'portal'
--

--
-- Final view structure for view `view_totaluser`
--

/*!50001 DROP VIEW IF EXISTS `view_totaluser`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_totaluser` AS select count(`user`.`user_id`) AS `COUNT(user_id)` from `user` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_userrolesp`
--

/*!50001 DROP VIEW IF EXISTS `view_userrolesp`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_unicode_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_userrolesp` AS select count(`user`.`user_id`) AS `COUNT(user_id)` from `user` where (`user`.`user_role` = 'SP') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-26 20:08:04
