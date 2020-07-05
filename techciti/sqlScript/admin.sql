
USE `techciti` ;

CREATE TABLE IF NOT EXISTS `techciti`.`admin` (
  `admin_id` int(20) NOT NULL AUTO_INCREMENT,

  `admin_name` VARCHAR(255) DEFAULT NULL,
    `password` VARCHAR(455) DEFAULT NULL,
  
  PRIMARY KEY (`admin_id`))
;
