--
-- MySQL 5.5.8
-- Sun, 09 Jan 2011 07:09:03 +0000
--

CREATE TABLE `user` (
   `id` int(11) not null auto_increment,
   `username` varchar(16) not null,
   `userpass` varchar(32) not null,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312 AUTO_INCREMENT=2;

INSERT INTO `user` (`id`, `username`, `userpass`) VALUES 
('1', 'admin', '21232f297a57a5a743894a0e4a801fc3');