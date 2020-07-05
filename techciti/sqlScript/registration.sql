
DROP SCHEMA IF EXISTS `techciti`;

CREATE SCHEMA `techciti`;
USE `techciti` ;

CREATE TABLE IF NOT EXISTS `techciti`.`registration` (
  `reg_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
    `email` VARCHAR(255) DEFAULT NULL,
     `file` VARCHAR(255) NULL DEFAULT NULL,
    `image` mediumblob DEFAULT NULL,
    `password` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`reg_id`))
;
