/*
SQLyog Professional v13.1.1 (64 bit)
MySQL - 8.0.20 : Database - guimei-shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`guimei-shop` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `guimei-shop`;

CREATE TABLE `Users` (
                         `UserID` int NOT NULL AUTO_INCREMENT,
                         `Username` varchar(50) NOT NULL,
                         `Password` varchar(50) NOT NULL,
                         `Email` varchar(100),
                         `Phone` varchar(20),
                         PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

INSERT INTO `Users` (`Username`, `Password`, `Email`, `Phone`) VALUES ('user1', 'pass123', 'user1@example.com', '1234567890');
INSERT INTO `Users` (`Username`, `Password`, `Email`, `Phone`) VALUES ('user2', 'pass456', 'user2@example.com', '0987654321');
INSERT INTO `Users` (`Username`, `Password`, `Email`, `Phone`) VALUES ('user3', 'pass789', 'user3@example.com', '2468013579');
INSERT INTO `Users` (`Username`, `Password`, `Email`, `Phone`) VALUES ('user4', 'passabc', 'user4@example.com', '3264591087');
INSERT INTO `Users` (`Username`, `Password`, `Email`, `Phone`) VALUES ('user5', 'passdef', 'user5@example.com', '4356789012');
INSERT INTO `Users` (`Username`, `Password`, `Email`, `Phone`) VALUES ('user6', 'passghi', 'user6@example.com', '5432167890');


CREATE TABLE `Products` (
                            `ProductID` int NOT NULL AUTO_INCREMENT,
                            `Name` varchar(20) NOT NULL,
                            `Image` varchar(100) DEFAULT NULL,
                            `Description` varchar(20) DEFAULT NULL,
                            `Seller` varchar(20) DEFAULT NULL,
                            `Category` varchar(20) DEFAULT NULL,
                            `Price` double DEFAULT NULL,
                            `NowPrice` double DEFAULT NULL,
                            `Discount` double DEFAULT NULL,
                            `ShippingCost` double DEFAULT NULL,
                            `RemainTime` varchar(20) DEFAULT NULL,
                            `SoldNumber` int DEFAULT NULL,
                            `AllSoldNumber` int DEFAULT NULL,
                            `State` varchar(20) DEFAULT NULL,
                            `NowNumber` varchar(20) DEFAULT NULL,
                            `Origin` varchar(20) DEFAULT NULL,
                            `Views` int DEFAULT NULL,
                            PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;7

INSERT INTO `Products` (`Name`, `Image`, `Description`, `Seller`, `Category`, `Price`, `NowPrice`, `Discount`, `ShippingCost`, `RemainTime`, `SoldNumber`, `AllSoldNumber`, `State`, `NowNumber`, `Origin`, `Views`) VALUES ('Product1', 'image1.jpg', 'Desc1', 'Seller1', 'Cat1', 120.00, 98.00, 0.8, 10.00, '10days', 10, 50, 'Active', '100', 'Origin1', 120);
INSERT INTO `Products` (`Name`, `Image`, `Description`, `Seller`, `Category`, `Price`, `NowPrice`, `Discount`, `ShippingCost`, `RemainTime`, `SoldNumber`, `AllSoldNumber`, `State`, `NowNumber`, `Origin`, `Views`) VALUES ('Product2', 'image2.jpg', 'Desc2', 'Seller2', 'Cat2', 250.00, 220.00, 0.9, 15.00, '5days', 20, 100, 'Active', '50', 'Origin2', 240);
INSERT INTO `Products` (`Name`, `Image`, `Description`, `Seller`, `Category`, `Price`, `NowPrice`, `Discount`, `ShippingCost`, `RemainTime`, `SoldNumber`, `AllSoldNumber`, `State`, `NowNumber`, `Origin`, `Views`) VALUES ('Product3', 'image3.jpg', 'Desc3', 'Seller3', 'Cat3', 300.00, 270.00, 0.85, 20.00, '7days', 30, 200, 'Active', '30', 'Origin3', 300);
INSERT INTO `Products` (`Name`, `Image`, `Description`, `Seller`, `Category`, `Price`, `NowPrice`, `Discount`, `ShippingCost`, `RemainTime`, `SoldNumber`, `AllSoldNumber`, `State`, `NowNumber`, `Origin`, `Views`) VALUES ('Product4', 'image4.jpg', 'Desc4', 'Seller4', 'Cat4', 450.00, 400.00, 0.95, 30.00, '3days', 40, 300, 'Active', '20', 'Origin4', 450);
INSERT INTO `Products` (`Name`, `Image`, `Description`, `Seller`, `Category`, `Price`,

CREATE TABLE `ShoppingCarts` (
  `ShoppingCartID` int NOT NULL AUTO_INCREMENT,
  `UserID` int,
  `ProductID` int,
  `Quantity` int DEFAULT 1,
  PRIMARY KEY (`ShoppingCartID`),
  FOREIGN KEY (`UserID`) REFERENCES `Users` (`UserID`),
  FOREIGN KEY (`ProductID`) REFERENCES `Products` (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

INSERT INTO `ShoppingCarts` (`UserID`, `ProductID`, `Quantity`) VALUES (1, 1, 2);
INSERT INTO `ShoppingCarts` (`UserID`, `ProductID`, `Quantity`) VALUES (2, 2, 1);
INSERT INTO `ShoppingCarts` (`UserID`, `ProductID`, `Quantity`) VALUES (3, 3, 3);
INSERT INTO `ShoppingCarts` (`UserID`, `ProductID`, `Quantity`) VALUES (4, 4, 1);
INSERT INTO `ShoppingCarts` (`UserID`, `ProductID`, `Quantity`) VALUES (5, 5, 2);
INSERT INTO `ShoppingCarts` (`UserID`, `ProductID`, `Quantity`) VALUES (6, 6, 1);

CREATE TABLE `Orders` (
                          `OrderID` int NOT NULL AUTO_INCREMENT,
                          `UserID` int,
                          `OrderDate` datetime DEFAULT CURRENT_TIMESTAMP,
                          `TotalAmount` double,
                          PRIMARY KEY (`OrderID`),
                          FOREIGN KEY (`UserID`) REFERENCES `Users` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;
INSERT INTO `Orders` (`UserID`, `TotalAmount`) VALUES (1, 190.00);
INSERT INTO `Orders` (`UserID`, `TotalAmount`) VALUES (2, 220.00);
INSERT INTO `Orders` (`UserID`, `TotalAmount`) VALUES (3, 360.00);
INSERT INTO `Orders` (`UserID`, `TotalAmount`) VALUES (4, 400.00);
INSERT INTO `Orders` (`UserID`, `TotalAmount`) VALUES (5, 250.00);
INSERT INTO `Orders` (`UserID`, `TotalAmount`) VALUES (6, 310.00);
