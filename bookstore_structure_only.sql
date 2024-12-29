/*
 Navicat Premium Data Transfer

 Source Server         : mysql_database
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 20/09/2023 15:07:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `inventory` int NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  PRIMARY KEY (`cartID`),
  KEY `cart_user_userid_fk` (`userID`),
  CONSTRAINT `cart_user_userid_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for cartItem
-- ----------------------------
DROP TABLE IF EXISTS `cartItem`;
CREATE TABLE `cartItem` (
  `bookAmount` int NOT NULL,
  `cartItemID` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `cartID` int NOT NULL,
  PRIMARY KEY (`cartItemID`),
  KEY `FKt0ybwcb231s8mrss65ml02noj` (`cartID`),
  CONSTRAINT `cartitem_cart_cartid_fk` FOREIGN KEY (`cartID`) REFERENCES `cart` (`cartID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for orderItem
-- ----------------------------
DROP TABLE IF EXISTS `orderItem`;
CREATE TABLE `orderItem` (
  `orderItemID` int NOT NULL AUTO_INCREMENT,
  `currentPrice` int NOT NULL,
  `isbn` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `bookAmount` int NOT NULL,
  `orderID` int NOT NULL,
  PRIMARY KEY (`orderItemID`),
  KEY `orderitem_orders_orderid` (`orderID`),
  CONSTRAINT `orderitem_orders_orderid` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `orderDate` date DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `order_user_userid_fk` (`userID`),
  CONSTRAINT `order_user_userid_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

SET FOREIGN_KEY_CHECKS = 1;
