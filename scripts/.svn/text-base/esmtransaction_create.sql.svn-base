CREATE TABLE `esmtransaction` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `cleared` bit(1) NOT NULL,
  `content_id` int(11) default NULL,
  `date_created` datetime NOT NULL,
  `last_updated` datetime NOT NULL,
  `member_id` bigint(20) default NULL,
  `message` varchar(255) default NULL,
  `type` varchar(255) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `viewed` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK7A0B3FFB07FFC0A` (`member_id`),
  KEY `FK7A0B3FF57BA4139` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

