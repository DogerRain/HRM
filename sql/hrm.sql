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
	create_date datetime  DEFAULT now(),
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
  `create_date` timestamp NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_date` timestamp NULL,
  `update_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_EMP_DEPT` (`dept_id`),
  KEY `FK_EMP_JOB` (`job_id`),
  CONSTRAINT `FK_EMP_DEPT` FOREIGN KEY (`dept_id`) REFERENCES `dept_info` (`id`),
  CONSTRAINT `FK_EMP_JOB` FOREIGN KEY (`job_id`) REFERENCES `job_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8



INSERT INTO employee_info(dept_id,job_id,`name`,card_id,address,phone,email,sex,party,birthday,race,education,remark,create_date,create_by,update_by,update_date)
VALUES (1,1,'杨磊','320211199810012522','江苏无锡','18362972966','1018824255@qq.com',0,'党员','1998-10-01 00:00:00','汉','硕士',NULL,NOW(),1,NOW(),1);


CREATE TABLE notice_info (
    id INT(11) NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    create_time datetime NOT NULL DEFAULT now(),
    user_id INT(11) DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_NOTICE_USER FOREIGN KEY (user_id) REFERENCES user_info (id)
    )ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

CREATE TABLE `document_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `filename` varchar(300) NOT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `create_by` int(11) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `update_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `t_province` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO t_province 	VALUES(NULL,'110000','北京市');
INSERT INTO t_province 	VALUES(NULL,'120000','天津市');
INSERT INTO t_province 	VALUES(NULL,'130000','河北省');
INSERT INTO t_province 	VALUES(NULL,'140000','山西省');
INSERT INTO t_province 	VALUES(NULL,'150000','内蒙古自治区');
INSERT INTO t_province 	VALUES(NULL,'210000','辽宁省');
INSERT INTO t_province 	VALUES(NULL,'220000','吉林省');
INSERT INTO t_province 	VALUES(NULL,'230000','黑龙江省');
INSERT INTO t_province 	VALUES(NULL,'310000','上海市');
INSERT INTO t_province 	VALUES(NULL,'320000','江苏省');
INSERT INTO t_province 	VALUES(NULL,'330000','浙江省');
INSERT INTO t_province 	VALUES(NULL,'340000','安徽省');
INSERT INTO t_province 	VALUES(NULL,'350000','福建省');
INSERT INTO t_province 	VALUES(NULL,'360000','江西省');
INSERT INTO t_province 	VALUES(NULL,'370000','山东省');
INSERT INTO t_province 	VALUES(NULL,'410000','河南省');
INSERT INTO t_province 	VALUES(NULL,'420000','湖北省');
INSERT INTO t_province 	VALUES(NULL,'430000','湖南省');
INSERT INTO t_province 	VALUES(NULL,'440000','广东省');
INSERT INTO t_province 	VALUES(NULL,'450000','广西壮族自治区');
INSERT INTO t_province 	VALUES(NULL,'460000','海南省');
INSERT INTO t_province 	VALUES(NULL,'500000','重庆市');
INSERT INTO t_province 	VALUES(NULL,'510000','四川省');
INSERT INTO t_province 	VALUES(NULL,'520000','贵州省');
INSERT INTO t_province 	VALUES(NULL,'530000','云南省');
INSERT INTO t_province 	VALUES(NULL,'540000','西藏自治区');
INSERT INTO t_province 	VALUES(NULL,'610000','陕西省');
INSERT INTO t_province 	VALUES(NULL,'620000','甘肃省');
INSERT INTO t_province 	VALUES(NULL,'630000','青海省');
INSERT INTO t_province 	VALUES(NULL,'640000','宁夏回族自治区');
INSERT INTO t_province 	VALUES(NULL,'650000','新疆维吾尔自治区');
INSERT INTO t_province 	VALUES(NULL,'710000','台湾省');
INSERT INTO t_province 	VALUES(NULL,'810000','香港特别行政区');
INSERT INTO t_province 	VALUES(NULL,'820000','澳门特别行政区');

DROP TABLE IF EXISTS t_province_city;
CREATE TABLE IF NOT EXISTS t_province_city (
  id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  province_code VARCHAR(10) NOT NULL,
  province_name VARCHAR(10) NOT NULL,
  city_code VARCHAR(10) NOT NULL,
  city_name VARCHAR(20) NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO t_province_city VALUES ('1', '110000', '北京市', '110100', '市辖区');
INSERT INTO t_province_city VALUES ('3', '120000', '天津市', '120100', '市辖区');
INSERT INTO t_province_city VALUES ('5', '130000', '河北省', '130100', '石家庄市');
INSERT INTO t_province_city VALUES ('7', '130000', '河北省', '130200', '唐山市');
INSERT INTO t_province_city VALUES ('9', '130000', '河北省', '130300', '秦皇岛市');
INSERT INTO t_province_city VALUES ('11', '130000', '河北省', '130400', '邯郸市');
INSERT INTO t_province_city VALUES ('13', '130000', '河北省', '130500', '邢台市');
INSERT INTO t_province_city VALUES ('15', '130000', '河北省', '130600', '保定市');
INSERT INTO t_province_city VALUES ('17', '130000', '河北省', '130700', '张家口市');
INSERT INTO t_province_city VALUES ('19', '130000', '河北省', '130800', '承德市');
INSERT INTO t_province_city VALUES ('21', '130000', '河北省', '130900', '沧州市');
INSERT INTO t_province_city VALUES ('23', '130000', '河北省', '131000', '廊坊市');
INSERT INTO t_province_city VALUES ('25', '130000', '河北省', '131100', '衡水市');
INSERT INTO t_province_city VALUES ('27', '130000', '河北省', '139000', '省直辖县级行政区划');
INSERT INTO t_province_city VALUES ('29', '140000', '山西省', '140100', '太原市');
INSERT INTO t_province_city VALUES ('31', '140000', '山西省', '140200', '大同市');
INSERT INTO t_province_city VALUES ('33', '140000', '山西省', '140300', '阳泉市');
INSERT INTO t_province_city VALUES ('35', '140000', '山西省', '140400', '长治市');
INSERT INTO t_province_city VALUES ('37', '140000', '山西省', '140500', '晋城市');
INSERT INTO t_province_city VALUES ('39', '140000', '山西省', '140600', '朔州市');
INSERT INTO t_province_city VALUES ('41', '140000', '山西省', '140700', '晋中市');
INSERT INTO t_province_city VALUES ('43', '140000', '山西省', '140800', '运城市');
INSERT INTO t_province_city VALUES ('45', '140000', '山西省', '140900', '忻州市');
INSERT INTO t_province_city VALUES ('47', '140000', '山西省', '141000', '临汾市');
INSERT INTO t_province_city VALUES ('49', '140000', '山西省', '141100', '吕梁市');
INSERT INTO t_province_city VALUES ('51', '150000', '内蒙古自治区', '150100', '呼和浩特市');
INSERT INTO t_province_city VALUES ('53', '150000', '内蒙古自治区', '150200', '包头市');
INSERT INTO t_province_city VALUES ('55', '150000', '内蒙古自治区', '150300', '乌海市');
INSERT INTO t_province_city VALUES ('57', '150000', '内蒙古自治区', '150400', '赤峰市');
INSERT INTO t_province_city VALUES ('59', '150000', '内蒙古自治区', '150500', '通辽市');
INSERT INTO t_province_city VALUES ('61', '150000', '内蒙古自治区', '150600', '鄂尔多斯市');
INSERT INTO t_province_city VALUES ('63', '150000', '内蒙古自治区', '150700', '呼伦贝尔市');
INSERT INTO t_province_city VALUES ('65', '150000', '内蒙古自治区', '150800', '巴彦淖尔市');
INSERT INTO t_province_city VALUES ('67', '150000', '内蒙古自治区', '150900', '乌兰察布市');
INSERT INTO t_province_city VALUES ('69', '150000', '内蒙古自治区', '152200', '兴安盟');
INSERT INTO t_province_city VALUES ('71', '150000', '内蒙古自治区', '152500', '锡林郭勒盟');
INSERT INTO t_province_city VALUES ('73', '150000', '内蒙古自治区', '152900', '阿拉善盟');
INSERT INTO t_province_city VALUES ('75', '210000', '辽宁省', '210100', '沈阳市');
INSERT INTO t_province_city VALUES ('77', '210000', '辽宁省', '210200', '大连市');
INSERT INTO t_province_city VALUES ('79', '210000', '辽宁省', '210300', '鞍山市');
INSERT INTO t_province_city VALUES ('81', '210000', '辽宁省', '210400', '抚顺市');
INSERT INTO t_province_city VALUES ('83', '210000', '辽宁省', '210500', '本溪市');
INSERT INTO t_province_city VALUES ('85', '210000', '辽宁省', '210600', '丹东市');
INSERT INTO t_province_city VALUES ('87', '210000', '辽宁省', '210700', '锦州市');
INSERT INTO t_province_city VALUES ('89', '210000', '辽宁省', '210800', '营口市');
INSERT INTO t_province_city VALUES ('91', '210000', '辽宁省', '210900', '阜新市');
INSERT INTO t_province_city VALUES ('93', '210000', '辽宁省', '211000', '辽阳市');
INSERT INTO t_province_city VALUES ('95', '210000', '辽宁省', '211100', '盘锦市');
INSERT INTO t_province_city VALUES ('97', '210000', '辽宁省', '211200', '铁岭市');
INSERT INTO t_province_city VALUES ('99', '210000', '辽宁省', '211300', '朝阳市');
INSERT INTO t_province_city VALUES ('101', '210000', '辽宁省', '211400', '葫芦岛市');
INSERT INTO t_province_city VALUES ('103', '220000', '吉林省', '220100', '长春市');
INSERT INTO t_province_city VALUES ('105', '220000', '吉林省', '220200', '吉林市');
INSERT INTO t_province_city VALUES ('107', '220000', '吉林省', '220300', '四平市');
INSERT INTO t_province_city VALUES ('109', '220000', '吉林省', '220400', '辽源市');
INSERT INTO t_province_city VALUES ('111', '220000', '吉林省', '220500', '通化市');
INSERT INTO t_province_city VALUES ('113', '220000', '吉林省', '220600', '白山市');
INSERT INTO t_province_city VALUES ('115', '220000', '吉林省', '220700', '松原市');
INSERT INTO t_province_city VALUES ('117', '220000', '吉林省', '220800', '白城市');
INSERT INTO t_province_city VALUES ('119', '220000', '吉林省', '222400', '延边朝鲜族自治州');
INSERT INTO t_province_city VALUES ('121', '230000', '黑龙江省', '230100', '哈尔滨市');
INSERT INTO t_province_city VALUES ('123', '230000', '黑龙江省', '230200', '齐齐哈尔市');
INSERT INTO t_province_city VALUES ('125', '230000', '黑龙江省', '230300', '鸡西市');
INSERT INTO t_province_city VALUES ('127', '230000', '黑龙江省', '230400', '鹤岗市');
INSERT INTO t_province_city VALUES ('129', '230000', '黑龙江省', '230500', '双鸭山市');
INSERT INTO t_province_city VALUES ('131', '230000', '黑龙江省', '230600', '大庆市');
INSERT INTO t_province_city VALUES ('133', '230000', '黑龙江省', '230700', '伊春市');
INSERT INTO t_province_city VALUES ('135', '230000', '黑龙江省', '230800', '佳木斯市');
INSERT INTO t_province_city VALUES ('137', '230000', '黑龙江省', '230900', '七台河市');
INSERT INTO t_province_city VALUES ('139', '230000', '黑龙江省', '231000', '牡丹江市');
INSERT INTO t_province_city VALUES ('141', '230000', '黑龙江省', '231100', '黑河市');
INSERT INTO t_province_city VALUES ('143', '230000', '黑龙江省', '231200', '绥化市');
INSERT INTO t_province_city VALUES ('145', '230000', '黑龙江省', '232700', '大兴安岭地区');
INSERT INTO t_province_city VALUES ('147', '310000', '上海市', '310100', '市辖区');
INSERT INTO t_province_city VALUES ('149', '320000', '江苏省', '320100', '南京市');
INSERT INTO t_province_city VALUES ('151', '320000', '江苏省', '320200', '无锡市');
INSERT INTO t_province_city VALUES ('153', '320000', '江苏省', '320300', '徐州市');
INSERT INTO t_province_city VALUES ('155', '320000', '江苏省', '320400', '常州市');
INSERT INTO t_province_city VALUES ('157', '320000', '江苏省', '320500', '苏州市');
INSERT INTO t_province_city VALUES ('159', '320000', '江苏省', '320600', '南通市');
INSERT INTO t_province_city VALUES ('161', '320000', '江苏省', '320700', '连云港市');
INSERT INTO t_province_city VALUES ('163', '320000', '江苏省', '320800', '淮安市');
INSERT INTO t_province_city VALUES ('165', '320000', '江苏省', '320900', '盐城市');
INSERT INTO t_province_city VALUES ('167', '320000', '江苏省', '321000', '扬州市');
INSERT INTO t_province_city VALUES ('169', '320000', '江苏省', '321100', '镇江市');
INSERT INTO t_province_city VALUES ('171', '320000', '江苏省', '321200', '泰州市');
INSERT INTO t_province_city VALUES ('173', '320000', '江苏省', '321300', '宿迁市');
INSERT INTO t_province_city VALUES ('175', '330000', '浙江省', '330100', '杭州市');
INSERT INTO t_province_city VALUES ('177', '330000', '浙江省', '330200', '宁波市');
INSERT INTO t_province_city VALUES ('179', '330000', '浙江省', '330300', '温州市');
INSERT INTO t_province_city VALUES ('181', '330000', '浙江省', '330400', '嘉兴市');
INSERT INTO t_province_city VALUES ('183', '330000', '浙江省', '330500', '湖州市');
INSERT INTO t_province_city VALUES ('185', '330000', '浙江省', '330600', '绍兴市');
INSERT INTO t_province_city VALUES ('187', '330000', '浙江省', '330700', '金华市');
INSERT INTO t_province_city VALUES ('189', '330000', '浙江省', '330800', '衢州市');
INSERT INTO t_province_city VALUES ('191', '330000', '浙江省', '330900', '舟山市');
INSERT INTO t_province_city VALUES ('193', '330000', '浙江省', '331000', '台州市');
INSERT INTO t_province_city VALUES ('195', '330000', '浙江省', '331100', '丽水市');
INSERT INTO t_province_city VALUES ('197', '340000', '安徽省', '340100', '合肥市');
INSERT INTO t_province_city VALUES ('199', '340000', '安徽省', '340200', '芜湖市');
INSERT INTO t_province_city VALUES ('201', '340000', '安徽省', '340300', '蚌埠市');
INSERT INTO t_province_city VALUES ('203', '340000', '安徽省', '340400', '淮南市');
INSERT INTO t_province_city VALUES ('205', '340000', '安徽省', '340500', '马鞍山市');
INSERT INTO t_province_city VALUES ('207', '340000', '安徽省', '340600', '淮北市');
INSERT INTO t_province_city VALUES ('209', '340000', '安徽省', '340700', '铜陵市');
INSERT INTO t_province_city VALUES ('211', '340000', '安徽省', '340800', '安庆市');
INSERT INTO t_province_city VALUES ('213', '340000', '安徽省', '341000', '黄山市');
INSERT INTO t_province_city VALUES ('215', '340000', '安徽省', '341100', '滁州市');
INSERT INTO t_province_city VALUES ('217', '340000', '安徽省', '341200', '阜阳市');
INSERT INTO t_province_city VALUES ('219', '340000', '安徽省', '341300', '宿州市');
INSERT INTO t_province_city VALUES ('221', '340000', '安徽省', '341500', '六安市');
INSERT INTO t_province_city VALUES ('223', '340000', '安徽省', '341600', '亳州市');
INSERT INTO t_province_city VALUES ('225', '340000', '安徽省', '341700', '池州市');
INSERT INTO t_province_city VALUES ('227', '340000', '安徽省', '341800', '宣城市');
INSERT INTO t_province_city VALUES ('229', '350000', '福建省', '350100', '福州市');
INSERT INTO t_province_city VALUES ('231', '350000', '福建省', '350200', '厦门市');
INSERT INTO t_province_city VALUES ('233', '350000', '福建省', '350300', '莆田市');
INSERT INTO t_province_city VALUES ('235', '350000', '福建省', '350400', '三明市');
INSERT INTO t_province_city VALUES ('237', '350000', '福建省', '350500', '泉州市');
INSERT INTO t_province_city VALUES ('239', '350000', '福建省', '350600', '漳州市');
INSERT INTO t_province_city VALUES ('241', '350000', '福建省', '350700', '南平市');
INSERT INTO t_province_city VALUES ('243', '350000', '福建省', '350800', '龙岩市');
INSERT INTO t_province_city VALUES ('245', '350000', '福建省', '350900', '宁德市');
INSERT INTO t_province_city VALUES ('247', '360000', '江西省', '360100', '南昌市');
INSERT INTO t_province_city VALUES ('249', '360000', '江西省', '360200', '景德镇市');
INSERT INTO t_province_city VALUES ('251', '360000', '江西省', '360300', '萍乡市');
INSERT INTO t_province_city VALUES ('253', '360000', '江西省', '360400', '九江市');
INSERT INTO t_province_city VALUES ('255', '360000', '江西省', '360500', '新余市');
INSERT INTO t_province_city VALUES ('257', '360000', '江西省', '360600', '鹰潭市');
INSERT INTO t_province_city VALUES ('259', '360000', '江西省', '360700', '赣州市');
INSERT INTO t_province_city VALUES ('261', '360000', '江西省', '360800', '吉安市');
INSERT INTO t_province_city VALUES ('263', '360000', '江西省', '360900', '宜春市');
INSERT INTO t_province_city VALUES ('265', '360000', '江西省', '361000', '抚州市');
INSERT INTO t_province_city VALUES ('267', '360000', '江西省', '361100', '上饶市');
INSERT INTO t_province_city VALUES ('269', '370000', '山东省', '370100', '济南市');
INSERT INTO t_province_city VALUES ('271', '370000', '山东省', '370200', '青岛市');
INSERT INTO t_province_city VALUES ('273', '370000', '山东省', '370300', '淄博市');
INSERT INTO t_province_city VALUES ('275', '370000', '山东省', '370400', '枣庄市');
INSERT INTO t_province_city VALUES ('277', '370000', '山东省', '370500', '东营市');
INSERT INTO t_province_city VALUES ('279', '370000', '山东省', '370600', '烟台市');
INSERT INTO t_province_city VALUES ('281', '370000', '山东省', '370700', '潍坊市');
INSERT INTO t_province_city VALUES ('283', '370000', '山东省', '370800', '济宁市');
INSERT INTO t_province_city VALUES ('285', '370000', '山东省', '370900', '泰安市');
INSERT INTO t_province_city VALUES ('287', '370000', '山东省', '371000', '威海市');
INSERT INTO t_province_city VALUES ('289', '370000', '山东省', '371100', '日照市');
INSERT INTO t_province_city VALUES ('291', '370000', '山东省', '371200', '莱芜市');
INSERT INTO t_province_city VALUES ('293', '370000', '山东省', '371300', '临沂市');
INSERT INTO t_province_city VALUES ('295', '370000', '山东省', '371400', '德州市');
INSERT INTO t_province_city VALUES ('297', '370000', '山东省', '371500', '聊城市');
INSERT INTO t_province_city VALUES ('299', '370000', '山东省', '371600', '滨州市');
INSERT INTO t_province_city VALUES ('301', '370000', '山东省', '371700', '菏泽市');
INSERT INTO t_province_city VALUES ('303', '410000', '河南省', '410100', '郑州市');
INSERT INTO t_province_city VALUES ('305', '410000', '河南省', '410200', '开封市');
INSERT INTO t_province_city VALUES ('307', '410000', '河南省', '410300', '洛阳市');
INSERT INTO t_province_city VALUES ('309', '410000', '河南省', '410400', '平顶山市');
INSERT INTO t_province_city VALUES ('311', '410000', '河南省', '410500', '安阳市');
INSERT INTO t_province_city VALUES ('313', '410000', '河南省', '410600', '鹤壁市');
INSERT INTO t_province_city VALUES ('315', '410000', '河南省', '410700', '新乡市');
INSERT INTO t_province_city VALUES ('317', '410000', '河南省', '410800', '焦作市');
INSERT INTO t_province_city VALUES ('319', '410000', '河南省', '410900', '濮阳市');
INSERT INTO t_province_city VALUES ('321', '410000', '河南省', '411000', '许昌市');
INSERT INTO t_province_city VALUES ('323', '410000', '河南省', '411100', '漯河市');
INSERT INTO t_province_city VALUES ('325', '410000', '河南省', '411200', '三门峡市');
INSERT INTO t_province_city VALUES ('327', '410000', '河南省', '411300', '南阳市');
INSERT INTO t_province_city VALUES ('329', '410000', '河南省', '411400', '商丘市');
INSERT INTO t_province_city VALUES ('331', '410000', '河南省', '411500', '信阳市');
INSERT INTO t_province_city VALUES ('333', '410000', '河南省', '411600', '周口市');
INSERT INTO t_province_city VALUES ('335', '410000', '河南省', '411700', '驻马店市');
INSERT INTO t_province_city VALUES ('337', '410000', '河南省', '419000', '省直辖县级行政区划');
INSERT INTO t_province_city VALUES ('339', '420000', '湖北省', '420100', '武汉市');
INSERT INTO t_province_city VALUES ('341', '420000', '湖北省', '420200', '黄石市');
INSERT INTO t_province_city VALUES ('343', '420000', '湖北省', '420300', '十堰市');
INSERT INTO t_province_city VALUES ('345', '420000', '湖北省', '420500', '宜昌市');
INSERT INTO t_province_city VALUES ('347', '420000', '湖北省', '420600', '襄阳市');
INSERT INTO t_province_city VALUES ('349', '420000', '湖北省', '420700', '鄂州市');
INSERT INTO t_province_city VALUES ('351', '420000', '湖北省', '420800', '荆门市');
INSERT INTO t_province_city VALUES ('353', '420000', '湖北省', '420900', '孝感市');
INSERT INTO t_province_city VALUES ('355', '420000', '湖北省', '421000', '荆州市');
INSERT INTO t_province_city VALUES ('357', '420000', '湖北省', '421100', '黄冈市');
INSERT INTO t_province_city VALUES ('359', '420000', '湖北省', '421200', '咸宁市');
INSERT INTO t_province_city VALUES ('361', '420000', '湖北省', '421300', '随州市');
INSERT INTO t_province_city VALUES ('363', '420000', '湖北省', '422800', '恩施土家族苗族自治州');
INSERT INTO t_province_city VALUES ('365', '420000', '湖北省', '429000', '省直辖县级行政区划');
INSERT INTO t_province_city VALUES ('367', '430000', '湖南省', '430100', '长沙市');
INSERT INTO t_province_city VALUES ('369', '430000', '湖南省', '430200', '株洲市');
INSERT INTO t_province_city VALUES ('371', '430000', '湖南省', '430300', '湘潭市');
INSERT INTO t_province_city VALUES ('373', '430000', '湖南省', '430400', '衡阳市');
INSERT INTO t_province_city VALUES ('375', '430000', '湖南省', '430500', '邵阳市');
INSERT INTO t_province_city VALUES ('377', '430000', '湖南省', '430600', '岳阳市');
INSERT INTO t_province_city VALUES ('379', '430000', '湖南省', '430700', '常德市');
INSERT INTO t_province_city VALUES ('381', '430000', '湖南省', '430800', '张家界市');
INSERT INTO t_province_city VALUES ('383', '430000', '湖南省', '430900', '益阳市');
INSERT INTO t_province_city VALUES ('385', '430000', '湖南省', '431000', '郴州市');
INSERT INTO t_province_city VALUES ('387', '430000', '湖南省', '431100', '永州市');
INSERT INTO t_province_city VALUES ('389', '430000', '湖南省', '431200', '怀化市');
INSERT INTO t_province_city VALUES ('391', '430000', '湖南省', '431300', '娄底市');
INSERT INTO t_province_city VALUES ('393', '430000', '湖南省', '433100', '湘西土家族苗族自治州');
INSERT INTO t_province_city VALUES ('395', '440000', '广东省', '440100', '广州市');
INSERT INTO t_province_city VALUES ('397', '440000', '广东省', '440200', '韶关市');
INSERT INTO t_province_city VALUES ('399', '440000', '广东省', '440300', '深圳市');
INSERT INTO t_province_city VALUES ('401', '440000', '广东省', '440400', '珠海市');
INSERT INTO t_province_city VALUES ('403', '440000', '广东省', '440500', '汕头市');
INSERT INTO t_province_city VALUES ('405', '440000', '广东省', '440600', '佛山市');
INSERT INTO t_province_city VALUES ('407', '440000', '广东省', '440700', '江门市');
INSERT INTO t_province_city VALUES ('409', '440000', '广东省', '440800', '湛江市');
INSERT INTO t_province_city VALUES ('411', '440000', '广东省', '440900', '茂名市');
INSERT INTO t_province_city VALUES ('413', '440000', '广东省', '441200', '肇庆市');
INSERT INTO t_province_city VALUES ('415', '440000', '广东省', '441300', '惠州市');
INSERT INTO t_province_city VALUES ('417', '440000', '广东省', '441400', '梅州市');
INSERT INTO t_province_city VALUES ('419', '440000', '广东省', '441500', '汕尾市');
INSERT INTO t_province_city VALUES ('421', '440000', '广东省', '441600', '河源市');
INSERT INTO t_province_city VALUES ('423', '440000', '广东省', '441700', '阳江市');
INSERT INTO t_province_city VALUES ('425', '440000', '广东省', '441800', '清远市');
INSERT INTO t_province_city VALUES ('427', '440000', '广东省', '441900', '东莞市');
INSERT INTO t_province_city VALUES ('429', '440000', '广东省', '442000', '中山市');
INSERT INTO t_province_city VALUES ('431', '440000', '广东省', '445100', '潮州市');
INSERT INTO t_province_city VALUES ('433', '440000', '广东省', '445200', '揭阳市');
INSERT INTO t_province_city VALUES ('435', '440000', '广东省', '445300', '云浮市');
INSERT INTO t_province_city VALUES ('437', '450000', '广西壮族自治区', '450100', '南宁市');
INSERT INTO t_province_city VALUES ('439', '450000', '广西壮族自治区', '450200', '柳州市');
INSERT INTO t_province_city VALUES ('441', '450000', '广西壮族自治区', '450300', '桂林市');
INSERT INTO t_province_city VALUES ('443', '450000', '广西壮族自治区', '450400', '梧州市');
INSERT INTO t_province_city VALUES ('445', '450000', '广西壮族自治区', '450500', '北海市');
INSERT INTO t_province_city VALUES ('447', '450000', '广西壮族自治区', '450600', '防城港市');
INSERT INTO t_province_city VALUES ('449', '450000', '广西壮族自治区', '450700', '钦州市');
INSERT INTO t_province_city VALUES ('451', '450000', '广西壮族自治区', '450800', '贵港市');
INSERT INTO t_province_city VALUES ('453', '450000', '广西壮族自治区', '450900', '玉林市');
INSERT INTO t_province_city VALUES ('455', '450000', '广西壮族自治区', '451000', '百色市');
INSERT INTO t_province_city VALUES ('457', '450000', '广西壮族自治区', '451100', '贺州市');
INSERT INTO t_province_city VALUES ('459', '450000', '广西壮族自治区', '451200', '河池市');
INSERT INTO t_province_city VALUES ('461', '450000', '广西壮族自治区', '451300', '来宾市');
INSERT INTO t_province_city VALUES ('463', '450000', '广西壮族自治区', '451400', '崇左市');
INSERT INTO t_province_city VALUES ('465', '460000', '海南省', '460100', '海口市');
INSERT INTO t_province_city VALUES ('467', '460000', '海南省', '460200', '三亚市');
INSERT INTO t_province_city VALUES ('469', '460000', '海南省', '460300', '三沙市');
INSERT INTO t_province_city VALUES ('471', '460000', '海南省', '460400', '儋州市');
INSERT INTO t_province_city VALUES ('473', '460000', '海南省', '469000', '省直辖县级行政区划');
INSERT INTO t_province_city VALUES ('475', '500000', '重庆市', '500100', '市辖区');
INSERT INTO t_province_city VALUES ('477', '500000', '重庆市', '500200', '县');
INSERT INTO t_province_city VALUES ('479', '510000', '四川省', '510100', '成都市');
INSERT INTO t_province_city VALUES ('481', '510000', '四川省', '510300', '自贡市');
INSERT INTO t_province_city VALUES ('483', '510000', '四川省', '510400', '攀枝花市');
INSERT INTO t_province_city VALUES ('485', '510000', '四川省', '510500', '泸州市');
INSERT INTO t_province_city VALUES ('487', '510000', '四川省', '510600', '德阳市');
INSERT INTO t_province_city VALUES ('489', '510000', '四川省', '510700', '绵阳市');
INSERT INTO t_province_city VALUES ('491', '510000', '四川省', '510800', '广元市');
INSERT INTO t_province_city VALUES ('493', '510000', '四川省', '510900', '遂宁市');
INSERT INTO t_province_city VALUES ('495', '510000', '四川省', '511000', '内江市');
INSERT INTO t_province_city VALUES ('497', '510000', '四川省', '511100', '乐山市');
INSERT INTO t_province_city VALUES ('499', '510000', '四川省', '511300', '南充市');
INSERT INTO t_province_city VALUES ('501', '510000', '四川省', '511400', '眉山市');
INSERT INTO t_province_city VALUES ('503', '510000', '四川省', '511500', '宜宾市');
INSERT INTO t_province_city VALUES ('505', '510000', '四川省', '511600', '广安市');
INSERT INTO t_province_city VALUES ('507', '510000', '四川省', '511700', '达州市');
INSERT INTO t_province_city VALUES ('509', '510000', '四川省', '511800', '雅安市');
INSERT INTO t_province_city VALUES ('511', '510000', '四川省', '511900', '巴中市');
INSERT INTO t_province_city VALUES ('513', '510000', '四川省', '512000', '资阳市');
INSERT INTO t_province_city VALUES ('515', '510000', '四川省', '513200', '阿坝藏族羌族自治州');
INSERT INTO t_province_city VALUES ('517', '510000', '四川省', '513300', '甘孜藏族自治州');
INSERT INTO t_province_city VALUES ('519', '510000', '四川省', '513400', '凉山彝族自治州');
INSERT INTO t_province_city VALUES ('521', '520000', '贵州省', '520100', '贵阳市');
INSERT INTO t_province_city VALUES ('523', '520000', '贵州省', '520200', '六盘水市');
INSERT INTO t_province_city VALUES ('525', '520000', '贵州省', '520300', '遵义市');
INSERT INTO t_province_city VALUES ('527', '520000', '贵州省', '520400', '安顺市');
INSERT INTO t_province_city VALUES ('529', '520000', '贵州省', '520500', '毕节市');
INSERT INTO t_province_city VALUES ('531', '520000', '贵州省', '520600', '铜仁市');
INSERT INTO t_province_city VALUES ('533', '520000', '贵州省', '522300', '黔西南布依族苗族自治州');
INSERT INTO t_province_city VALUES ('535', '520000', '贵州省', '522600', '黔东南苗族侗族自治州');
INSERT INTO t_province_city VALUES ('537', '520000', '贵州省', '522700', '黔南布依族苗族自治州');
INSERT INTO t_province_city VALUES ('539', '530000', '云南省', '530100', '昆明市');
INSERT INTO t_province_city VALUES ('541', '530000', '云南省', '530300', '曲靖市');
INSERT INTO t_province_city VALUES ('543', '530000', '云南省', '530400', '玉溪市');
INSERT INTO t_province_city VALUES ('545', '530000', '云南省', '530500', '保山市');
INSERT INTO t_province_city VALUES ('547', '530000', '云南省', '530600', '昭通市');
INSERT INTO t_province_city VALUES ('549', '530000', '云南省', '530700', '丽江市');
INSERT INTO t_province_city VALUES ('551', '530000', '云南省', '530800', '普洱市');
INSERT INTO t_province_city VALUES ('553', '530000', '云南省', '530900', '临沧市');
INSERT INTO t_province_city VALUES ('555', '530000', '云南省', '532300', '楚雄彝族自治州');
INSERT INTO t_province_city VALUES ('557', '530000', '云南省', '532500', '红河哈尼族彝族自治州');
INSERT INTO t_province_city VALUES ('559', '530000', '云南省', '532600', '文山壮族苗族自治州');
INSERT INTO t_province_city VALUES ('561', '530000', '云南省', '532800', '西双版纳傣族自治州');
INSERT INTO t_province_city VALUES ('563', '530000', '云南省', '532900', '大理白族自治州');
INSERT INTO t_province_city VALUES ('565', '530000', '云南省', '533100', '德宏傣族景颇族自治州');
INSERT INTO t_province_city VALUES ('567', '530000', '云南省', '533300', '怒江傈僳族自治州');
INSERT INTO t_province_city VALUES ('569', '530000', '云南省', '533400', '迪庆藏族自治州');
INSERT INTO t_province_city VALUES ('571', '540000', '西藏自治区', '540100', '拉萨市');
INSERT INTO t_province_city VALUES ('573', '540000', '西藏自治区', '540200', '日喀则市');
INSERT INTO t_province_city VALUES ('575', '540000', '西藏自治区', '540300', '昌都市');
INSERT INTO t_province_city VALUES ('577', '540000', '西藏自治区', '540400', '林芝市');
INSERT INTO t_province_city VALUES ('579', '540000', '西藏自治区', '540500', '山南市');
INSERT INTO t_province_city VALUES ('581', '540000', '西藏自治区', '542400', '那曲地区');
INSERT INTO t_province_city VALUES ('583', '540000', '西藏自治区', '542500', '阿里地区');
INSERT INTO t_province_city VALUES ('585', '610000', '陕西省', '610100', '西安市');
INSERT INTO t_province_city VALUES ('587', '610000', '陕西省', '610200', '铜川市');
INSERT INTO t_province_city VALUES ('589', '610000', '陕西省', '610300', '宝鸡市');
INSERT INTO t_province_city VALUES ('591', '610000', '陕西省', '610400', '咸阳市');
INSERT INTO t_province_city VALUES ('593', '610000', '陕西省', '610500', '渭南市');
INSERT INTO t_province_city VALUES ('595', '610000', '陕西省', '610600', '延安市');
INSERT INTO t_province_city VALUES ('597', '610000', '陕西省', '610700', '汉中市');
INSERT INTO t_province_city VALUES ('599', '610000', '陕西省', '610800', '榆林市');
INSERT INTO t_province_city VALUES ('601', '610000', '陕西省', '610900', '安康市');
INSERT INTO t_province_city VALUES ('603', '610000', '陕西省', '611000', '商洛市');
INSERT INTO t_province_city VALUES ('605', '620000', '甘肃省', '620100', '兰州市');
INSERT INTO t_province_city VALUES ('607', '620000', '甘肃省', '620200', '嘉峪关市');
INSERT INTO t_province_city VALUES ('609', '620000', '甘肃省', '620300', '金昌市');
INSERT INTO t_province_city VALUES ('611', '620000', '甘肃省', '620400', '白银市');
INSERT INTO t_province_city VALUES ('613', '620000', '甘肃省', '620500', '天水市');
INSERT INTO t_province_city VALUES ('615', '620000', '甘肃省', '620600', '武威市');
INSERT INTO t_province_city VALUES ('617', '620000', '甘肃省', '620700', '张掖市');
INSERT INTO t_province_city VALUES ('619', '620000', '甘肃省', '620800', '平凉市');
INSERT INTO t_province_city VALUES ('621', '620000', '甘肃省', '620900', '酒泉市');
INSERT INTO t_province_city VALUES ('623', '620000', '甘肃省', '621000', '庆阳市');
INSERT INTO t_province_city VALUES ('625', '620000', '甘肃省', '621100', '定西市');
INSERT INTO t_province_city VALUES ('627', '620000', '甘肃省', '621200', '陇南市');
INSERT INTO t_province_city VALUES ('629', '620000', '甘肃省', '622900', '临夏回族自治州');
INSERT INTO t_province_city VALUES ('631', '620000', '甘肃省', '623000', '甘南藏族自治州');
INSERT INTO t_province_city VALUES ('633', '630000', '青海省', '630100', '西宁市');
INSERT INTO t_province_city VALUES ('635', '630000', '青海省', '630200', '海东市');
INSERT INTO t_province_city VALUES ('637', '630000', '青海省', '632200', '海北藏族自治州');
INSERT INTO t_province_city VALUES ('639', '630000', '青海省', '632300', '黄南藏族自治州');
INSERT INTO t_province_city VALUES ('641', '630000', '青海省', '632500', '海南藏族自治州');
INSERT INTO t_province_city VALUES ('643', '630000', '青海省', '632600', '果洛藏族自治州');
INSERT INTO t_province_city VALUES ('645', '630000', '青海省', '632700', '玉树藏族自治州');
INSERT INTO t_province_city VALUES ('647', '630000', '青海省', '632800', '海西蒙古族藏族自治州');
INSERT INTO t_province_city VALUES ('649', '640000', '宁夏回族自治区', '640100', '银川市');
INSERT INTO t_province_city VALUES ('651', '640000', '宁夏回族自治区', '640200', '石嘴山市');
INSERT INTO t_province_city VALUES ('653', '640000', '宁夏回族自治区', '640300', '吴忠市');
INSERT INTO t_province_city VALUES ('655', '640000', '宁夏回族自治区', '640400', '固原市');
INSERT INTO t_province_city VALUES ('657', '640000', '宁夏回族自治区', '640500', '中卫市');
INSERT INTO t_province_city VALUES ('659', '650000', '新疆维吾尔自治区', '650100', '乌鲁木齐市');
INSERT INTO t_province_city VALUES ('661', '650000', '新疆维吾尔自治区', '650200', '克拉玛依市');
INSERT INTO t_province_city VALUES ('663', '650000', '新疆维吾尔自治区', '650400', '吐鲁番市');
INSERT INTO t_province_city VALUES ('665', '650000', '新疆维吾尔自治区', '650500', '哈密市');
INSERT INTO t_province_city VALUES ('667', '650000', '新疆维吾尔自治区', '652300', '昌吉回族自治州');
INSERT INTO t_province_city VALUES ('669', '650000', '新疆维吾尔自治区', '652700', '博尔塔拉蒙古自治州');
INSERT INTO t_province_city VALUES ('671', '650000', '新疆维吾尔自治区', '652800', '巴音郭楞蒙古自治州');
INSERT INTO t_province_city VALUES ('673', '650000', '新疆维吾尔自治区', '652900', '阿克苏地区');
INSERT INTO t_province_city VALUES ('675', '650000', '新疆维吾尔自治区', '653000', '克孜勒苏柯尔克孜自治州');
INSERT INTO t_province_city VALUES ('677', '650000', '新疆维吾尔自治区', '653100', '喀什地区');
INSERT INTO t_province_city VALUES ('679', '650000', '新疆维吾尔自治区', '653200', '和田地区');
INSERT INTO t_province_city VALUES ('681', '650000', '新疆维吾尔自治区', '654000', '伊犁哈萨克自治州');
INSERT INTO t_province_city VALUES ('683', '650000', '新疆维吾尔自治区', '654200', '塔城地区');
INSERT INTO t_province_city VALUES ('685', '650000', '新疆维吾尔自治区', '654300', '阿勒泰地区');
INSERT INTO t_province_city VALUES ('687', '650000', '新疆维吾尔自治区', '659000', '自治区直辖县级行政区划');

