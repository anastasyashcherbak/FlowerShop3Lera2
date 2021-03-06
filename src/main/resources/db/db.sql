CREATE DATABASE IF NOT EXISTS `flowershop`
  DEFAULT CHARACTER SET utf8;
USE `flowershop`;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `flowers`;
DROP TABLE IF EXISTS `flowerbanks`;
DROP TABLE IF EXISTS `bouquets`;
DROP TABLE IF EXISTS `holidays`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE IF NOT EXISTS `flowers` (
  `ID`        INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`     VARCHAR(50) DEFAULT NULL,
  `color`     VARCHAR(50) DEFAULT NULL
)
ENGINE =InnoDB
DEFAULT CHARSET =utf8;

CREATE TABLE IF NOT EXISTS `flowerbanks` (
  `ID`        INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `flower_id`  INT(11),
  `bouquet_id`  INT(11),
  `count`     INT(11) DEFAULT NULL
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE IF NOT EXISTS `bouquets` (
  `ID`        INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`     VARCHAR(50) DEFAULT NULL,
  `holiday_id`  INT(11)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;

CREATE TABLE IF NOT EXISTS `holidays` (
  `ID`        INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `date`     VARCHAR(50) DEFAULT NULL,
  `description`     VARCHAR(50) DEFAULT NULL,
  `user_id`  INT(11)
)
  ENGINE =InnoDB
  DEFAULT CHARSET =utf8;


ALTER TABLE `flowerbanks` ADD CONSTRAINT `fk_flowerbank_flower` FOREIGN KEY (`flower_id`) REFERENCES `flowers` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `flowerbanks` ADD CONSTRAINT `fk_bouquet_flowerBank` FOREIGN KEY (`bouquet_id`) REFERENCES `bouquets` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `bouquets` ADD CONSTRAINT `fk_holiday_bouquet` FOREIGN KEY (`holiday_id`) REFERENCES `holidays` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
ALTER TABLE `holidays` ADD CONSTRAINT `fk_user_holiday` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
###############################

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `users`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE IF NOT EXISTS users (
  `ID`        INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  role VARCHAR(45) NOT NULL
);



INSERT INTO users(username,password,enabled,role)
VALUES ('panser','panser', TRUE, 'ROLE_ADMIN');
INSERT INTO users(username,password,enabled,role)
VALUES ('lera','lera', TRUE, 'ROLE_USER');