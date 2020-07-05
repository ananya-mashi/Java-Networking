USE `techciti` ;

CREATE TABLE IF NOT EXISTS `techciti`.`loginInfo` (
`login_id` int(20) auto_increment Not Null,

  `name` varchar(200) ,
   `Access_time` VARCHAR(255) DEFAULT NULL,
     `login_status` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`login_id`))
;
