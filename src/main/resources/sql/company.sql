/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.28 : Database - company
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`company` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `actor` */

DROP TABLE IF EXISTS `actor`;

CREATE TABLE `actor` (
  `eno` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  KEY `eno` (`eno`),
  KEY `uid` (`uid`),
  CONSTRAINT `actor_ibfk_1` FOREIGN KEY (`eno`) REFERENCES `event_s` (`eno`),
  CONSTRAINT `actor_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `actor` */

insert  into `actor`(`eno`,`uid`) values (1,1),(4,1),(5,1),(6,1),(6,3),(7,2),(8,3),(9,3),(10,1),(10,2),(10,3),(10,4);

/*Table structure for table `event_record` */

DROP TABLE IF EXISTS `event_record`;

CREATE TABLE `event_record` (
  `eno` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `active` int(11) DEFAULT '0',
  `uid` int(11) DEFAULT NULL,
  KEY `eno` (`eno`),
  KEY `uid` (`uid`),
  CONSTRAINT `event_record_ibfk_1` FOREIGN KEY (`eno`) REFERENCES `event_s` (`eno`),
  CONSTRAINT `event_record_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `event_record` */

insert  into `event_record`(`eno`,`date`,`state`,`active`,`uid`) values (3,'2022-12-05 03:39:26',1,0,1),(4,'2022-12-05 04:18:54',1,0,1),(7,'2022-12-05 04:23:41',1,0,1),(3,'2022-12-05 09:38:46',1,0,2);

/*Table structure for table `event_s` */

DROP TABLE IF EXISTS `event_s`;

CREATE TABLE `event_s` (
  `eno` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `explains` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `event_s` */

insert  into `event_s`(`eno`,`ename`,`start_time`,`end_time`,`state`,`explains`) values (1,'????????????2022????????????','2022-07-09 09:30:00','2022-09-09 10:30:00',2,'??????????????????????????????????????????'),(2,'IBT??????','2022-09-09 09:30:00','2022-11-30 10:30:00',2,'?????????IBT?????????'),(3,'Java??????????????????','2022-08-10 13:30:00','2022-12-31 16:00:00',1,'?????????????????????'),(4,'????????????','2022-12-01 00:00:00','2022-12-23 00:00:00',1,'????????????'),(5,'????????????','2022-12-01 00:00:00','2022-12-23 00:00:00',1,'????????????'),(6,'??????????????????','2022-11-30 00:00:00','2023-01-18 00:00:00',1,'????????????'),(7,'????????????????????????','2022-11-26 00:00:00','2022-12-29 00:00:00',1,'?????????????????????'),(8,'???????????????','2022-12-05 00:00:00','2022-12-21 00:00:00',0,'?????????????????????'),(9,'???????????????','2022-12-01 00:00:00','2022-12-03 00:00:00',2,'?????????????????????'),(10,'dddd','2022-12-01 00:00:00','2023-01-11 00:00:00',1,'asdfasdfasdf');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(11) NOT NULL,
  `real_name` varchar(10) DEFAULT NULL,
  `account` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`uid`,`real_name`,`account`,`password`,`rank`) values (1,'??????','admin','admin',0),(2,'??????','1234','1234',1),(3,NULL,NULL,NULL,NULL),(4,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
