USE `techciti` ;

CREATE TABLE IF NOT EXISTS `techciti`.`file_share` (
  `share_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int  REFERENCES `techciti`.`registration`(reg_id),
  `share_member_name` VARCHAR(255) DEFAULT NULL,
    `file_title` VARCHAR(455) DEFAULT NULL,
     `share_file` longblob null,
   `file_path` VARCHAR(500)DEFAULT NULL,
   
  PRIMARY KEY (`share_id`))
;
