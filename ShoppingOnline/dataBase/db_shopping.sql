CREATE DATABASE  IF NOT EXISTS `db_shopping` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_shopping`;
-- MySQL dump 10.13  Distrib 5.6.11, for Win32 (x86)
--
-- Host: localhost    Database: db_shopping
-- ------------------------------------------------------
-- Server version	5.6.13

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
-- Table structure for table `tb_affiche`
--

DROP TABLE IF EXISTS `tb_affiche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_affiche` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `content` text,
  `issueTime` timestamp NULL DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_affiche`
--

LOCK TABLES `tb_affiche` WRITE;
/*!40000 ALTER TABLE `tb_affiche` DISABLE KEYS */;
INSERT INTO `tb_affiche` VALUES (1,'新年快乐','祝您新的一年新气象！','2015-01-20 03:20:00'),(2,'诚招代理','为了更好方便顾客，本店招各地代理，详情拨打1523484673','2015-01-11 03:30:00'),(3,'好消息','即日起本商城进行打折促销活动!','2015-01-11 03:29:00'),(4,'招聘业务员','需要有责任心能干的业务员若干，详情请拨打1523484673','2015-01-11 00:29:00');
/*!40000 ALTER TABLE `tb_affiche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_bigtype`
--

DROP TABLE IF EXISTS `tb_bigtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_bigtype` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bigName` varchar(50) DEFAULT NULL,
  `creaTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK_tb_bigType` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_bigtype`
--

LOCK TABLES `tb_bigtype` WRITE;
/*!40000 ALTER TABLE `tb_bigtype` DISABLE KEYS */;
INSERT INTO `tb_bigtype` VALUES (1,'家用电器','2015-01-17 01:00:35'),(2,' 衣物服饰','2015-01-17 01:05:35'),(3,'计算机','2015-01-17 01:10:35'),(4,'交通工具','2015-01-17 01:12:35'),(5,'餐具','2015-01-17 01:15:35'),(6,'玩具类','2015-01-17 01:18:35'),(7,'古玩乐器类','2015-01-17 01:21:35');
/*!40000 ALTER TABLE `tb_bigtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_goods`
--

DROP TABLE IF EXISTS `tb_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bigId` int(10) NOT NULL,
  `smallId` int(10) NOT NULL,
  `goodsName` varchar(50) DEFAULT NULL,
  `goodsFrom` varchar(50) DEFAULT NULL,
  `introduce` text,
  `creaTime` timestamp NULL DEFAULT NULL,
  `nowPrice` decimal(19,4) DEFAULT NULL,
  `freePrice` decimal(19,4) DEFAULT NULL,
  `number` int(10) DEFAULT NULL,
  `pirture` varchar(50) DEFAULT NULL,
  `mark` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK_tb_goods` (`id`),
  KEY `FK_tb_goods_tb_smallType` (`smallId`),
  CONSTRAINT `tb_goods_ibfk_1` FOREIGN KEY (`smallId`) REFERENCES `tb_smalltype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_goods`
--

LOCK TABLES `tb_goods` WRITE;
/*!40000 ALTER TABLE `tb_goods` DISABLE KEYS */;
INSERT INTO `tb_goods` VALUES (1,5,5,'中#咖啡杯','广东省潮州市四福餐具公司','该咖啡杯可以咖啡香味','2015-01-17 02:00:10',49.0000,10.0000,14,'goodsPicture/beizi.jpg',0),(2,4,6,'大#自行车','浙江省温州市自行车公司','该自行车适合西藏远行','2015-01-17 02:05:10',739.0000,499.0000,21,'goodsPicture/zixingche.jpg',0),(3,3,1,'三星液晶显示器','湖北省武汉市科技有限公司','该显示器大小为19寸','2015-01-17 02:07:10',1399.0000,999.0000,35,'goodsPicture/sanxing.jpg',0),(4,3,1,'HKC液晶显示器','湖北省武汉市科技有限公司','该显示器为17寸','2015-01-17 02:10:10',999.0000,599.0000,55,'goodsPicture/HKC.jpg',0),(5,2,2,'阿迪休闲装','上海市服装厂','保暖、轻薄适合秋天','2015-01-17 02:14:10',399.0000,299.0000,208,'goodsPicture/adi.jpg',0),(6,1,3,'海尔液晶电视','广东省广州市科技有限公司','极清4K、节能','2015-01-17 02:17:10',4899.0000,4699.0000,69,'goodsPicture/haier.jpg',0),(7,1,3,'三星家庭影院电视机','广东省广州省科技有限公司','3D蓝光、内置蓝牙','2015-01-17 02:20:10',2999.0000,2899.0000,108,'goodsPicture/yinxiang.jpg',0),(8,1,4,'海尔17岗洗衣机','吉林省长春市海尔洗衣机厂','省电、双筒超大量','2015-01-17 02:25:10',2499.0000,2199.0000,188,'goodsPicture/17xiyiji.jpg',0),(9,1,4,'海尔22岗洗衣机','吉林省长春市洗衣机厂','比较适合洗衣店使用','2015-01-17 02:29:10',2899.0000,2599.0000,251,'goodsPicture/22xiyiji.jpg',1),(10,7,9,'学生用名谣吉他','郑州天音乐器专营店','适合初学者使用','2015-01-17 02:32:10',589.0000,489.0000,157,'goodsPicture/jita.jpg',1);
/*!40000 ALTER TABLE `tb_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_link`
--

DROP TABLE IF EXISTS `tb_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_link` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `linkName` varchar(50) DEFAULT NULL,
  `linkAddress` varchar(50) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_link`
--

LOCK TABLES `tb_link` WRITE;
/*!40000 ALTER TABLE `tb_link` DISABLE KEYS */;
INSERT INTO `tb_link` VALUES (6,'京东商城','http://www.jd.com\r'),(7,'淘宝商城','http://www.taobao.com\r'),(8,'苏宁易购','http://www.suning.com\r'),(9,'天猫商城','http://www.tmall.com\r');
/*!40000 ALTER TABLE `tb_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_manager`
--

DROP TABLE IF EXISTS `tb_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_manager` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sign` int(1) DEFAULT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_manager`
--

LOCK TABLES `tb_manager` WRITE;
/*!40000 ALTER TABLE `tb_manager` DISABLE KEYS */;
INSERT INTO `tb_manager` VALUES (1,'admin','admin','admin',0),(2,'0000','0000','0000',1);
/*!40000 ALTER TABLE `tb_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_member`
--

DROP TABLE IF EXISTS `tb_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_member` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `reallyName` varchar(10) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `profession` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `question` varchar(50) DEFAULT NULL,
  `result` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`name`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `PK_tb_member` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_member`
--

LOCK TABLES `tb_member` WRITE;
/*!40000 ALTER TABLE `tb_member` DISABLE KEYS */;
INSERT INTO `tb_member` VALUES (1,'0000','0000','0000',11,'职员','df865017@163.com','你好','你好'),(2,'1111','1111','1111',21,'网站程序员','df865017@163.com','你好','你好'),(3,'2222','2222','2222',31,'职员','df865017@163.com','你好','你好'),(4,'3333','3333','3333',41,'网站程序员','df865017@163.com','你好','你好');
/*!40000 ALTER TABLE `tb_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_order`
--

DROP TABLE IF EXISTS `tb_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `number` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `reallyName` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `setMoney` varchar(50) DEFAULT NULL,
  `post` varchar(50) DEFAULT NULL,
  `bz` text,
  `sign` int(1) DEFAULT NULL,
  `creaTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`number`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `PK_tb_order` (`number`),
  KEY `FK_tb_order_tb_member` (`name`),
  CONSTRAINT `tb_order_ibfk_1` FOREIGN KEY (`name`) REFERENCES `tb_member` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_order`
--

LOCK TABLES `tb_order` WRITE;
/*!40000 ALTER TABLE `tb_order` DISABLE KEYS */;
INSERT INTO `tb_order` VALUES (1,'1196047260126','0000','0000','北京市朝阳区北三环中路213号','18810633695','银行付款','普通快递','客户很重要',1,'2014-01-18 04:15:15'),(2,'1196047260239','1111','1111','吉林省通州市359号','136989652364','现金支付','EMS','急需',1,'2014-01-18 04:20:15'),(3,'1196047260526','2222','2222','贵州省贵阳市南明区359号','15885267892','邮政支付','特快专递','商品不可以碾压',0,'2014-01-18 04:25:15'),(4,'1196047260988','3333','3333','四川省成都市青羊区469号','18725693459','银行付款','EMS','急需',0,'2014-01-18 04:30:15');
/*!40000 ALTER TABLE `tb_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_orderdetail`
--

DROP TABLE IF EXISTS `tb_orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_orderdetail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `orderNumber` varchar(50) DEFAULT NULL,
  `goodsId` int(10) NOT NULL,
  `price` float DEFAULT NULL,
  `number` int(10) DEFAULT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `FK_tb_orderDetail_tb_goods` (`goodsId`),
  KEY `FK_tb_orderDetail_tb_order` (`orderNumber`),
  CONSTRAINT `tb_orderdetail_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `tb_goods` (`id`),
  CONSTRAINT `tb_orderdetail_ibfk_2` FOREIGN KEY (`orderNumber`) REFERENCES `tb_order` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_orderdetail`
--

LOCK TABLES `tb_orderdetail` WRITE;
/*!40000 ALTER TABLE `tb_orderdetail` DISABLE KEYS */;
INSERT INTO `tb_orderdetail` VALUES (1,'1196047260126',10,509,75),(2,'1196047260126',2,499,57),(3,'1196047260239',2,499,31);
/*!40000 ALTER TABLE `tb_orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_smalltype`
--

DROP TABLE IF EXISTS `tb_smalltype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_smalltype` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `bigId` int(10) NOT NULL,
  `smallName` varchar(50) DEFAULT NULL,
  `creaTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK_tb_smallType` (`id`),
  KEY `FK_tb_smallType_tb_bigType` (`bigId`),
  CONSTRAINT `tb_smalltype_ibfk_1` FOREIGN KEY (`bigId`) REFERENCES `tb_bigtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_smalltype`
--

LOCK TABLES `tb_smalltype` WRITE;
/*!40000 ALTER TABLE `tb_smalltype` DISABLE KEYS */;
INSERT INTO `tb_smalltype` VALUES (1,3,'显示器','2015-01-17 01:25:50'),(2,2,'衣服','2015-01-17 01:28:50'),(3,1,'电视机','2015-01-17 01:32:50'),(4,1,'洗衣机','2015-01-17 01:35:50'),(5,5,'杯子','2015-01-17 01:40:50'),(6,4,'自行车','2015-01-17 01:43:50'),(7,6,'玩具手枪','2015-01-17 01:45:50'),(8,6,'遥控赛车','2015-01-17 01:47:50'),(9,7,'吉他','2015-01-17 01:51:50'),(10,7,'笛子','2015-01-17 01:55:50');
/*!40000 ALTER TABLE `tb_smalltype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-25 17:20:27
