USE `techciti` ;

CREATE TABLE IF NOT EXISTS `techciti`.`count` (
`count_id`int(20) NOT NULL AUTO_INCREMENT,

  `user_id` int  REFERENCES `techciti`.`registration`(reg_id),
     `Ip_Address` varchar(200),
     `count` int(20) null,
      PRIMARY KEY (`count_id`)
 )
;
