/*
SQLyog Community v9.63 
MySQL - 5.5.27 : Database - studentinformation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentinformation` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `studentinformation`;

/*Table structure for table `studentinfosystem` */

DROP TABLE IF EXISTS `studentinfosystem`;

CREATE TABLE `studentinfosystem` (
  `Eno` int(11) NOT NULL,
  `Roll_number` int(11) NOT NULL,
  `Student_Name` varchar(30) DEFAULT NULL,
  `Sex` varchar(30) DEFAULT NULL,
  `Father_Name` varchar(30) DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Year` varchar(30) DEFAULT NULL,
  `Major` varchar(30) DEFAULT NULL,
  `Specialized_Subject` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Eno`,`Roll_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `studentinfosystem` */

insert  into `studentinfosystem`(`Eno`,`Roll_number`,`Student_Name`,`Sex`,`Father_Name`,`Address`,`Year`,`Major`,`Specialized_Subject`) values (2,2,'ma','female','U','yangon','second','com','business'),(3,3,'mg','mALE','b','THAI','second','com','network');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
