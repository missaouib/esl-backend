-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eladmin
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `pid` bigint DEFAULT NULL COMMENT '上级菜单ID',
  `sub_count` int DEFAULT '0' COMMENT '子菜单数目',
  `type` int DEFAULT NULL COMMENT '菜单类型',
  `title` varchar(255) DEFAULT NULL COMMENT '菜单标题',
  `name` varchar(255) DEFAULT NULL COMMENT '组件名称',
  `component` varchar(255) DEFAULT NULL COMMENT '组件',
  `menu_sort` int DEFAULT NULL COMMENT '排序',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `path` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `i_frame` bit(1) DEFAULT NULL COMMENT '是否外链',
  `cache` bit(1) DEFAULT b'0' COMMENT '缓存',
  `hidden` bit(1) DEFAULT b'0' COMMENT '隐藏',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) DEFAULT NULL COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`menu_id`) USING BTREE,
  UNIQUE KEY `uniq_title` (`title`),
  UNIQUE KEY `uniq_name` (`name`),
  KEY `inx_pid` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='系统菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,NULL,7,0,'系统管理',NULL,NULL,1,'system','system',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2018-12-18 15:11:29',NULL),(2,1,3,1,'用户管理','User','system/user/index',2,'peoples','user',_binary '\0',_binary '\0',_binary '\0','user:list',NULL,NULL,'2018-12-18 15:14:44',NULL),(3,1,3,1,'角色管理','Role','system/role/index',3,'role','role',_binary '\0',_binary '\0',_binary '\0','roles:list',NULL,NULL,'2018-12-18 15:16:07',NULL),(5,1,3,1,'菜单管理','Menu','system/menu/index',5,'menu','menu',_binary '\0',_binary '\0',_binary '\0','menu:list',NULL,NULL,'2018-12-18 15:17:28',NULL),(6,NULL,5,0,'系统监控',NULL,NULL,10,'monitor','monitor',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2018-12-18 15:17:48',NULL),(7,6,0,1,'操作日志','Log','monitor/log/index',11,'log','logs',_binary '\0',_binary '',_binary '\0',NULL,NULL,'admin','2018-12-18 15:18:26','2020-06-06 13:11:57'),(9,6,0,1,'SQL监控','Sql','monitor/sql/index',18,'sqlMonitor','druid',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2018-12-18 15:19:34',NULL),(10,NULL,5,0,'组件管理',NULL,NULL,50,'zujian','components',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2018-12-19 13:38:16',NULL),(11,10,0,1,'图标库','Icons','components/icons/index',51,'icon','icon',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2018-12-19 13:38:49',NULL),(14,36,0,1,'邮件工具','Email','tools/email/index',35,'email','email',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2018-12-27 10:13:09',NULL),(15,10,0,1,'富文本','Editor','components/Editor',52,'fwb','tinymce',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2018-12-27 11:58:25',NULL),(19,36,0,1,'支付宝工具','AliPay','tools/aliPay/index',37,'alipay','aliPay',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2018-12-31 14:52:38',NULL),(21,NULL,2,0,'多级菜单',NULL,'',900,'menu','nested',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,'admin','2019-01-04 16:22:03','2020-06-21 17:27:35'),(22,21,2,0,'二级菜单1',NULL,'',999,'menu','menu1',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,'admin','2019-01-04 16:23:29','2020-06-21 17:27:20'),(23,21,0,1,'二级菜单2',NULL,'nested/menu2/index',999,'menu','menu2',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-01-04 16:23:57',NULL),(24,22,0,1,'三级菜单1','Test','nested/menu1/menu1-1',999,'menu','menu1-1',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-01-04 16:24:48',NULL),(27,22,0,1,'三级菜单2',NULL,'nested/menu1/menu1-2',999,'menu','menu1-2',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-01-07 17:27:32',NULL),(28,1,3,1,'任务调度','Timing','system/timing/index',999,'timing','timing',_binary '\0',_binary '\0',_binary '\0','timing:list',NULL,NULL,'2019-01-07 20:34:40',NULL),(30,36,0,1,'代码生成','GeneratorIndex','generator/index',32,'dev','generator',_binary '\0',_binary '',_binary '\0',NULL,NULL,NULL,'2019-01-11 15:45:55',NULL),(32,6,0,1,'异常日志','ErrorLog','monitor/log/errorLog',12,'error','errorLog',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-01-13 13:49:03',NULL),(33,10,0,1,'Markdown','Markdown','components/MarkDown',53,'markdown','markdown',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-03-08 13:46:44',NULL),(34,10,0,1,'Yaml编辑器','YamlEdit','components/YamlEdit',54,'dev','yaml',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-03-08 15:49:40',NULL),(35,1,3,1,'部门管理','Dept','system/dept/index',6,'dept','dept',_binary '\0',_binary '\0',_binary '\0','dept:list',NULL,NULL,'2019-03-25 09:46:00',NULL),(36,NULL,7,0,'系统工具',NULL,'',30,'sys-tools','sys-tools',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-03-29 10:57:35',NULL),(37,1,3,1,'岗位管理','Job','system/job/index',7,'Steve-Jobs','job',_binary '\0',_binary '\0',_binary '\0','job:list',NULL,NULL,'2019-03-29 13:51:18',NULL),(38,36,0,1,'接口文档','Swagger','tools/swagger/index',36,'swagger','swagger2',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-03-29 19:57:53',NULL),(39,1,3,1,'字典管理','Dict','system/dict/index',8,'dictionary','dict',_binary '\0',_binary '\0',_binary '\0','dict:list',NULL,NULL,'2019-04-10 11:49:04',NULL),(41,6,0,1,'在线用户','OnlineUser','monitor/online/index',10,'Steve-Jobs','online',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-10-26 22:08:43',NULL),(44,2,0,2,'用户新增',NULL,'',2,'','',_binary '\0',_binary '\0',_binary '\0','user:add',NULL,NULL,'2019-10-29 10:59:46',NULL),(45,2,0,2,'用户编辑',NULL,'',3,'','',_binary '\0',_binary '\0',_binary '\0','user:edit',NULL,NULL,'2019-10-29 11:00:08',NULL),(46,2,0,2,'用户删除',NULL,'',4,'','',_binary '\0',_binary '\0',_binary '\0','user:del',NULL,NULL,'2019-10-29 11:00:23',NULL),(48,3,0,2,'角色创建',NULL,'',2,'','',_binary '\0',_binary '\0',_binary '\0','roles:add',NULL,NULL,'2019-10-29 12:45:34',NULL),(49,3,0,2,'角色修改',NULL,'',3,'','',_binary '\0',_binary '\0',_binary '\0','roles:edit',NULL,NULL,'2019-10-29 12:46:16',NULL),(50,3,0,2,'角色删除',NULL,'',4,'','',_binary '\0',_binary '\0',_binary '\0','roles:del',NULL,NULL,'2019-10-29 12:46:51',NULL),(52,5,0,2,'菜单新增',NULL,'',2,'','',_binary '\0',_binary '\0',_binary '\0','menu:add',NULL,NULL,'2019-10-29 12:55:07',NULL),(53,5,0,2,'菜单编辑',NULL,'',3,'','',_binary '\0',_binary '\0',_binary '\0','menu:edit',NULL,NULL,'2019-10-29 12:55:40',NULL),(54,5,0,2,'菜单删除',NULL,'',4,'','',_binary '\0',_binary '\0',_binary '\0','menu:del',NULL,NULL,'2019-10-29 12:56:00',NULL),(56,35,0,2,'部门新增',NULL,'',2,'','',_binary '\0',_binary '\0',_binary '\0','dept:add',NULL,NULL,'2019-10-29 12:57:09',NULL),(57,35,0,2,'部门编辑',NULL,'',3,'','',_binary '\0',_binary '\0',_binary '\0','dept:edit',NULL,NULL,'2019-10-29 12:57:27',NULL),(58,35,0,2,'部门删除',NULL,'',4,'','',_binary '\0',_binary '\0',_binary '\0','dept:del',NULL,NULL,'2019-10-29 12:57:41',NULL),(60,37,0,2,'岗位新增',NULL,'',2,'','',_binary '\0',_binary '\0',_binary '\0','job:add',NULL,NULL,'2019-10-29 12:58:27',NULL),(61,37,0,2,'岗位编辑',NULL,'',3,'','',_binary '\0',_binary '\0',_binary '\0','job:edit',NULL,NULL,'2019-10-29 12:58:45',NULL),(62,37,0,2,'岗位删除',NULL,'',4,'','',_binary '\0',_binary '\0',_binary '\0','job:del',NULL,NULL,'2019-10-29 12:59:04',NULL),(64,39,0,2,'字典新增',NULL,'',2,'','',_binary '\0',_binary '\0',_binary '\0','dict:add',NULL,NULL,'2019-10-29 13:00:17',NULL),(65,39,0,2,'字典编辑',NULL,'',3,'','',_binary '\0',_binary '\0',_binary '\0','dict:edit',NULL,NULL,'2019-10-29 13:00:42',NULL),(66,39,0,2,'字典删除',NULL,'',4,'','',_binary '\0',_binary '\0',_binary '\0','dict:del',NULL,NULL,'2019-10-29 13:00:59',NULL),(73,28,0,2,'任务新增',NULL,'',2,'','',_binary '\0',_binary '\0',_binary '\0','timing:add',NULL,NULL,'2019-10-29 13:07:28',NULL),(74,28,0,2,'任务编辑',NULL,'',3,'','',_binary '\0',_binary '\0',_binary '\0','timing:edit',NULL,NULL,'2019-10-29 13:07:41',NULL),(75,28,0,2,'任务删除',NULL,'',4,'','',_binary '\0',_binary '\0',_binary '\0','timing:del',NULL,NULL,'2019-10-29 13:07:54',NULL),(77,18,0,2,'上传文件',NULL,'',2,'','',_binary '\0',_binary '\0',_binary '\0','storage:add',NULL,NULL,'2019-10-29 13:09:09',NULL),(78,18,0,2,'文件编辑',NULL,'',3,'','',_binary '\0',_binary '\0',_binary '\0','storage:edit',NULL,NULL,'2019-10-29 13:09:22',NULL),(79,18,0,2,'文件删除',NULL,'',4,'','',_binary '\0',_binary '\0',_binary '\0','storage:del',NULL,NULL,'2019-10-29 13:09:34',NULL),(80,6,0,1,'服务监控','ServerMonitor','monitor/server/index',14,'codeConsole','server',_binary '\0',_binary '\0',_binary '\0','monitor:list',NULL,'admin','2019-11-07 13:06:39','2020-05-04 18:20:50'),(82,36,0,1,'生成配置','GeneratorConfig','generator/config',33,'dev','generator/config/:tableName',_binary '\0',_binary '',_binary '','',NULL,NULL,'2019-11-17 20:08:56',NULL),(83,10,0,1,'图表库','Echarts','components/Echarts',50,'chart','echarts',_binary '\0',_binary '',_binary '\0','',NULL,NULL,'2019-11-21 09:04:32',NULL),(90,NULL,5,1,'运维管理','Mnt','',20,'mnt','mnt',_binary '\0',_binary '\0',_binary '\0',NULL,NULL,NULL,'2019-11-09 10:31:08',NULL),(92,90,3,1,'服务器','ServerDeploy','mnt/server/index',22,'server','mnt/serverDeploy',_binary '\0',_binary '\0',_binary '\0','serverDeploy:list',NULL,NULL,'2019-11-10 10:29:25',NULL),(93,90,3,1,'应用管理','App','mnt/app/index',23,'app','mnt/app',_binary '\0',_binary '\0',_binary '\0','app:list',NULL,NULL,'2019-11-10 11:05:16',NULL),(94,90,3,1,'部署管理','Deploy','mnt/deploy/index',24,'deploy','mnt/deploy',_binary '\0',_binary '\0',_binary '\0','deploy:list',NULL,NULL,'2019-11-10 15:56:55',NULL),(97,90,1,1,'部署备份','DeployHistory','mnt/deployHistory/index',25,'backup','mnt/deployHistory',_binary '\0',_binary '\0',_binary '\0','deployHistory:list',NULL,NULL,'2019-11-10 16:49:44',NULL),(98,90,3,1,'数据库管理','Database','mnt/database/index',26,'database','mnt/database',_binary '\0',_binary '\0',_binary '\0','database:list',NULL,NULL,'2019-11-10 20:40:04',NULL),(102,97,0,2,'删除',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','deployHistory:del',NULL,NULL,'2019-11-17 09:32:48',NULL),(103,92,0,2,'服务器新增',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','serverDeploy:add',NULL,NULL,'2019-11-17 11:08:33',NULL),(104,92,0,2,'服务器编辑',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','serverDeploy:edit',NULL,NULL,'2019-11-17 11:08:57',NULL),(105,92,0,2,'服务器删除',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','serverDeploy:del',NULL,NULL,'2019-11-17 11:09:15',NULL),(106,93,0,2,'应用新增',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','app:add',NULL,NULL,'2019-11-17 11:10:03',NULL),(107,93,0,2,'应用编辑',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','app:edit',NULL,NULL,'2019-11-17 11:10:28',NULL),(108,93,0,2,'应用删除',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','app:del',NULL,NULL,'2019-11-17 11:10:55',NULL),(109,94,0,2,'部署新增',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','deploy:add',NULL,NULL,'2019-11-17 11:11:22',NULL),(110,94,0,2,'部署编辑',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','deploy:edit',NULL,NULL,'2019-11-17 11:11:41',NULL),(111,94,0,2,'部署删除',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','deploy:del',NULL,NULL,'2019-11-17 11:12:01',NULL),(112,98,0,2,'数据库新增',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','database:add',NULL,NULL,'2019-11-17 11:12:43',NULL),(113,98,0,2,'数据库编辑',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','database:edit',NULL,NULL,'2019-11-17 11:12:58',NULL),(114,98,0,2,'数据库删除',NULL,'',999,'','',_binary '\0',_binary '\0',_binary '\0','database:del',NULL,NULL,'2019-11-17 11:13:14',NULL),(116,36,0,1,'生成预览','Preview','generator/preview',999,'java','generator/preview/:tableName',_binary '\0',_binary '',_binary '',NULL,NULL,NULL,'2019-11-26 14:54:36',NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-23 14:41:31
