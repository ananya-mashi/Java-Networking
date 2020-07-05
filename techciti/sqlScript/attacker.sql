USE `techciti` ;

CREATE TABLE IF NOT EXISTS `techciti`.`attacker` (
  `access_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int  REFERENCES `techciti`.`registration`(reg_id),
`Attack_time` varchar(200),
 `Ip_Address` varchar(200),
     `share_file` longblob null,
   `file_path` VARCHAR(500)DEFAULT NULL,
   `block_status` VARCHAR(50)DEFAULT NULL,
   
  PRIMARY KEY (`access_id`))
;
