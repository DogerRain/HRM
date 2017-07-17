'CREATE DATABASE hrm_db DEFAULT CHARACTER SET utf8;

USE hrm_db;

CREATE TABLE dept_info (
	id INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	remark VARCHAR(300) DEFAULT  NULL,
	create_by int(11) DEFAULT  NULL,
	create_date timestamp DEFAULT  NULL,
	update_by int(11) DEFAULT  NULL,
	update_date timestamp DEFAULT  NULL,
	PRIMARY KEY (id)
	) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
	
INSERT INTO dept_info(id,`name`,remark) VALUES (1,'技术部','技术部'),(2,'运营部','运营部'),(3,'财务部','财务部'),
(5,'总裁办','总裁办'),(6,'市场部','市场部'),(7,'后勤部','后勤部');



CREATE TABLE job_info(
     id INT(11) NOT NULL AUTO_INCREMENT,
     `name` VARCHAR(50) NOT NULL,
     remark VARCHAR(300) DEFAULT NULL,
	 create_date timestamp null default null,
	 create_by int(11) default null,
	 update_date timestamp null default null,
	 update_by int(11) default null,
     PRIMARY KEY (id)
     ) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

INSERT INTO job_info(id,`name`,remark) VALUES (1,'Java工程师','Java工程师'),(2,'iOS工程师','iOS工程师'),(3,'项目经理','项目经理'),
(4,'测试工程师','测试工程师'),(5,'运营专员','运营专员');

CREATE TABLE user_info(
	id INT(11) NOT NULL AUTO_INCREMENT,
	loginname VARCHAR(20) NOT NULL,
	`password` VARCHAR(16) NOT NULL,
	`status` INT(11) NOT NULL DEFAULT 1,
	create_date datetime NOT NULL DEFAULT now(),
	username VARCHAR(20) DEFAULT NULL,
	PRIMARY KEY (id)
	)ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8; 
	
INSERT INTO user_info (id,loginname,`password`,`status`,create_date,username) VALUES (1,'admin','123456',
2,CURRENT_TIMESTAMP,'超级管理员');




CREATE TABLE `employee_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` int(11) NOT NULL,
  `job_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `card_id` varchar(18) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sex` int(11) NOT NULL DEFAULT '1',
  `party` varchar(10) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `race` varchar(100) DEFAULT NULL,
  `education` varchar(10) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by` int(11) DEFAULT NULL,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_EMP_DEPT` (`dept_id`),
  KEY `FK_EMP_JOB` (`job_id`),
  CONSTRAINT `FK_EMP_DEPT` FOREIGN KEY (`dept_id`) REFERENCES `dept_info` (`id`),
  CONSTRAINT `FK_EMP_JOB` FOREIGN KEY (`job_id`) REFERENCES `job_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8



INSERT INTO employee_info(id,dept_id,job_id,`name`,card_id,address,phone,email,sex,party,birthday,race,education,remark,create_date,create_by,update_by.update_date)
VALUES (1,1,1,'杨磊','320211199810012522','江苏无锡','18362972966','1018824255@qq.com',0,'党员','1998-10-01 00:00:00','汉','硕士',CURRENT_TIMESTAMP,1,now(),1);


CREATE TABLE notice_info (
    id INT(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    create_time datetime NOT NULL DEFAULT now(),
    user_id INT(11) DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_NOTICE_USER FOREIGN KEY (user_id) REFERENCES user_info (id)
    )ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

 CREATE TABLE document_info(
    id INT(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    filename VARCHAR(300) NOT NULL,
    remark VARCHAR(300) DEFAULT NULL,
    create_date datetime  NOT NULL DEFAULT now(),
    user_id INT(11) DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_DOCUMENT_USER FOREIGN KEY (user_id) REFERENCES user_info (id)
    )ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;