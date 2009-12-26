CREATE DATABASE `proverbworld`;

DROP TABLE IF EXISTS `proverbworld`.`user`;

CREATE TABLE  `proverbworld`.`user` (
  `user_id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `password` varchar(100),
  `place` varchar(100),
  PRIMARY KEY  (`user_id`)
);

DROP TABLE IF EXISTS `proverbworld`.`proverb`;

CREATE TABLE  `proverbworld`.`proverb` (
  `proverb_id` int(10) unsigned NOT NULL auto_increment,
  `proverb` varchar(2000) NOT NULL,
  `description` varchar(5000),
  `approved` tinyint(1) NOT NULL default '0',
  `user_id` int(10) unsigned  NOT NULL, 
  PRIMARY KEY  (`proverb_id`),
  FOREIGN KEY (`user_id`) REFERENCES `proverbworld`.`user`(`user_id`)
);