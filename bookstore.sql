-- MySQL dump 10.13  Distrib 8.0.32, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: SingleBookstore
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `inventory` int NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (2,'2','深入理解计算机系统','编程','兰德尔·E·布莱恩特',136.90,'程序员必读经典著作！理解计算机系统*书目，10万程序员共同选择。第二版销售突破100000册，第三版重磅上市！',1172,'http://img3m7.ddimg.cn/48/0/24106647-1_w_6.jpg'),(3,'3','Effective C++','编程','梅耶',51.30,'大师名著纵横二十载，稳居任一荐书单三甲；称职程序员傍身绝学，通向C++精微奥妙之门。',973,'http://img3m6.ddimg.cn/96/25/21000966-1_u_12.jpg'),(4,'4','小王子','儿童文学','圣-埃克苏佩里',8.89,'豆瓣9.7高分推荐！旅法翻译家梅子涵之女梅思繁法文直译，舒朗大开本，央美教授高精度还原原作插画。首次收录全球舞台剧、音乐会、电影、动画片等对《小王子》的精彩诠释，通晓名作的前世今生。',980,'http://img3m9.ddimg.cn/75/6/25067469-1_u_2.jpg'),(6,'6','魔兽世界编年史套装(全三卷)','魔幻小说','克里斯˙梅森',449.20,'暴雪官方历时二十年编纂而成的史料！三卷《魔兽世界编年史》将呈现大量从未公布的精美原画和插图，读者在阅读故事之余，更能享受一次视觉上的饕餮盛宴，是魔兽粉丝收藏的优选。',99,'http://img3m7.ddimg.cn/43/9/25352557-1_w_3.jpg'),(7,'7','三体：全三册','科幻小说','刘慈欣',50.20,'刘慈欣代表作，亚洲首部“雨果奖”获奖作品！',14394,'http://img3m4.ddimg.cn/32/35/23579654-1_u_3.jpg'),(8,'8','悲惨世界（上中下）（精装版）','世界名著','雨果',104.00,'《悲惨世界》是雨果在流亡期间写的长篇小说，是他的代表作，也是世界文学宝库的珍品之一。\r\n    《悲惨世界》通过冉阿让等人的悲惨遭遇以及冉阿让被卞福汝主教感化后一系列令人感动的事迹，深刻揭露和批判了19世纪法国封建专制社会的腐朽本质及其罪恶现象，对穷苦人民在封建重压下所遭受的剥削欺诈和残酷迫害表示了悲悯和同情。',380,'http://img3m7.ddimg.cn/13/15/27912667-1_u_1.jpg'),(9,'9','动物农场','社会小说','乔治·奥威尔',20.40,'也译“动物庄园”，是“一代人的冷峻良知”乔治·奥威尔经典的讽喻之作。虽然这一场荒诞的动物革命走向歧途，但正是因为这样我们才了解“把权力关进制度的笼子”的重要性。',88,'http://img3m1.ddimg.cn/82/3/25229341-1_w_2.jpg'),(10,'10','机器学习','编程','周志华',61.60,'击败AlphaGo的武林秘籍，赢得人机大战的必由之路：人工智能大牛周志华教授巨著，全面揭开机器学习的奥秘。',2497,'http://img3m0.ddimg.cn/20/24/23898620-1_w_3.jpg'),(11,'11','纳尼亚传奇','魔幻小说','刘易斯',86.20,'刘易斯基金会独家授权插图！翻译家吴岩，陈良廷，刘文澜经典译本！',99,'http://img3m7.ddimg.cn/1/32/22474387-1_u_2.jpg'),(12,'12','老人与海','世界名著','海明威',27.80,'收录诺贝尔文学奖获奖作品《老人与海》《乞力马扎罗的雪》，深深影响了马尔克斯、塞林格等文学家的创作理念。',2411,'http://img3m6.ddimg.cn/94/11/27891166-1_u_2.jpg'),(13,'13','魔力的胎动','悬疑/推理小说','东野圭吾',35.90,'喜欢《解忧杂货店》，就一定要读这本书。珍藏印签。有了想要守护的东西，生命就会变得有力量。悲凉的人生、千疮百孔的命运、一桩桩悲剧的发生与救赎，读来令人喟叹不已。',1209,'http://img3m4.ddimg.cn/68/35/28484744-2_u_6.jpg'),(14,'14','我不怕这漫长黑夜','青春文学','苑子豪',37.50,'七篇寻光故事，七种奇遇人生，送给成长路上孤独前行的你，每个人的生活都有被困在井里一样的绝望时刻，而这本书就想做点亮黑夜的那束光芒。耐心一些，保持相信，我们终会穿越漫长黑夜，抵达属于自己的黎明。',1138,'http://img3m0.ddimg.cn/9/18/28486170-1_u_8.jpg'),(15,'15','永久记录','传记文学','爱德华·斯诺登',56.70,'美国政府不想让全世界读到这本书，欧美上市当日作者便被美国司法部起诉！“棱镜门”主角爱德华·斯诺登首次亲自披露美国政府滥用NSA系统监控世界的真相，袒露从“爱国者”到“叛国者”的心路历程。',120,'http://img3m5.ddimg.cn/86/22/28475555-2_u_9.jpg'),(16,'16','探索月球','儿童文学','安妮·詹克利奥维奇',133.20,'嫦娥五号探测器系统副总设计师彭兢诚意推荐！纪念人类登月50周年，五大精妙立体机关直观呈现月球的运行轨迹，全方位揭秘人类探月登月的过程，普及基本的航天知识，与孩子一起解读月球的奥秘，种下探索宇宙的种子。',1504,'http://img3m4.ddimg.cn/13/30/28481224-1_w_3.jpg'),(17,'17','高考英语 五年高考三年模拟','中小学教辅','曲一线',70.80,'五年高考三年模拟，英语五三高考练习册，五三高中同步53全练全解，你值得拥有！',12275,'http://img3m4.ddimg.cn/62/14/27883214-1_w_2.jpg'),(18,'18','红楼梦','世界名著','曹雪芹',18.80,'中国古典小说佳作，影响整个华人世界的经典！轻松易学、国家教育部推荐读物！',2191,'http://img3m6.ddimg.cn/31/22/23828836-1_w_8.jpg'),(19,'19','草房子','儿童文学','曹文轩',22.50,'人民文学出版社天天出版社出品，经典作品，教师推荐，已有超过150000读者给予好评！',1226,'http://img3m2.ddimg.cn/32/4/23662022-1_w_9.jpg'),(20,'20','追风筝的人','世界名著','卡勒德·胡赛尼',35.30,'“许多年过去了，人们说陈年旧事可以被埋葬，然而我终于明白这是错的，因为往事会自行爬上来。回首前尘，我意识到在过去二十六年里，自己始终在窥视着那荒芜的小径。”',14128,'http://img3m5.ddimg.cn/26/14/25238195-1_w_3.jpg'),(21,'21','软件工程原理','编程','沈备军、陈昊鹏、陈雨亭',35.90,'从软件工程的本质出发、结合实际案例，系统全面地介绍软件过程、软件建模技术与方法及软件工程管理同时介绍一些热点新技术和新方法。',1022,'http://img3m6.ddimg.cn/32/30/1204489076-1_w_1.jpg'),(22,'22','数据库系统概念','编程','西尔伯沙茨',74.20,'本书内容丰富，不仅讨论了关系数据模型和关系语言、数据库设计过程、关系数据库理论、数据库应用设计和开发、数据存储结构、数据存取技术、查询优化方法、事务处理系统和并发控制、故障恢复技术、数据仓库和数据挖掘，而且对性能调整、性能评测标准、数据库应用测试和标准化等高级应用主题进行了广泛讨论。',239,'http://img3m2.ddimg.cn/83/5/22632572-1_w_1.jpg'),(23,'23','算法导论','编程','科尔曼',77.63,'全书选材经典、内容丰富、结构合理、逻辑清晰，对本科生的数据结构课程和研究生的算法课程都是非常实用的教材，在IT专业人员的职业生涯中，本书也是一本案头必备的参考书或工程实践手册。',142,'http://img3m8.ddimg.cn/89/15/1517005898-1_w_1.jpg'),(24,'24','史记（文白对照本）','古籍','司马迁',237.10,'荣获商务印书馆2019人文社科十大好书，张大可先生《史记》研究的集成之作，精细考证，廓清原书真伪；题解语译，展现著者史观，是一部人人都能读懂、人人都会爱读的文白对照本《史记》。',4141,'http://img3m7.ddimg.cn/14/14/27915737-1_w_3.jpg'),(25,'25','天龙八部(全五册)','武侠小说','金庸',102.30,'《天龙八部》一书以北宋、辽、西夏、大理并立的历史为宏大背景，将儒释道、琴棋书画等中国传统文化融会贯通其中，书中人物繁多，个性鲜明，情节离奇，尽显芸芸众生百态。',74747,'http://img3m2.ddimg.cn/84/17/23273202-1_w_1.jpg'),(26,'26','笑傲江湖(全四册)','武侠小说','金庸',80.10,'一部《辟邪剑谱》引发灭门血案，阴险狡诈，机关算尽，只为争霸武林，真相往往出人意表。酒后高歌磨剑，梦中快意恩仇，一曲《笑傲江湖》，传一段天荒地老。 ',2518,'http://img3m0.ddimg.cn/82/15/23273200-1_w_1.jpg'),(27,'27','楚留香传奇(全三册)','武侠小说','古龙',224.50,'《楚留香传奇》无疑乃古龙诸作中*为烩炙人口之作，此作固成就古龙之盛名，更成为武侠文学之重要里程碑。楚留香有西方007罗杰摩尔之冷静、优雅、明快及幽默，更因他没有复仇及情爱之纠葛（例如他从来不杀人）而超越007，颇有“本来无一物，何处惹尘埃”的意境。',525,'http://img3m4.ddimg.cn/4/22/1592963464-1_w_1.jpg'),(28,'28','哈利波特与魔法石','魔幻小说','J·K·罗琳',30.20,'“沉湎于虚幻的梦想，而忘记现实的生活，这是毫无益处的，千万记住。”                                ——阿不思·邓布利多',999,'http://img3m1.ddimg.cn/88/0/25479421-1_w_1.jpg'),(29,'29','哈利·波特与死亡圣器','魔幻小说','J·K·罗琳',56.20,'两个人不能都活着，只有一个生存下来，我们中的一个将要永远离开……',1550,'http://img3m4.ddimg.cn/71/20/25479404-1_w_1.jpg'),(30,'114514','name','useradd','author',114.51,'田所浩二最喜欢的一本书',114514,'image'),(33,'101101','峰爷自传','真正王者','王乐峰',999.99,'和蔼，任何作业，终将绳之以法！',114514,'https://kichiku.fandom.com/zh/wiki/%E5%90%B4%E4%BA%AC?file=%E5%90%B4%E4%BA%AC.png'),(35,'101101','峰爷自传','真正王者','王乐峰',999.99,'和蔼，任何作业，终将绳之以法！',114514,'https://kichiku.fandom.com/zh/wiki/%E5%90%B4%E4%BA%AC?file=%E5%90%B4%E4%BA%AC.png');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cartID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  PRIMARY KEY (`cartID`),
  KEY `cart_user_userid_fk` (`userID`),
  CONSTRAINT `cart_user_userid_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartItem`
--

DROP TABLE IF EXISTS `cartItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartItem` (
  `bookAmount` int NOT NULL,
  `cartItemID` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `cartID` int NOT NULL,
  PRIMARY KEY (`cartItemID`),
  KEY `FKt0ybwcb231s8mrss65ml02noj` (`cartID`),
  CONSTRAINT `cartitem_cart_cartid_fk` FOREIGN KEY (`cartID`) REFERENCES `cart` (`cartID`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartItem`
--

LOCK TABLES `cartItem` WRITE;
/*!40000 ALTER TABLE `cartItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderItem`
--

DROP TABLE IF EXISTS `orderItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderItem` (
  `orderItemID` int NOT NULL AUTO_INCREMENT,
  `currentPrice` decimal(10,2) DEFAULT NULL,
  `isbn` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `bookAmount` int NOT NULL,
  `orderID` int NOT NULL,
  PRIMARY KEY (`orderItemID`),
  KEY `orderitem_orders_orderid` (`orderID`),
  CONSTRAINT `orderitem_orders_orderid` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderItem`
--

LOCK TABLES `orderItem` WRITE;
/*!40000 ALTER TABLE `orderItem` DISABLE KEYS */;
INSERT INTO `orderItem` VALUES (1,95.00,'1',5,1),(2,51.00,'3',5,1),(3,51.00,'3',5,2),(4,9.00,'4',5,2),(5,95.00,'1',5,3),(6,95.00,'1',3,5),(7,95.00,'1',8,7),(8,9.00,'4',3,8),(9,95.00,'1',3,9),(10,95.00,'1',3,10),(11,137.00,'2',2,11),(12,137.00,'2',5,12),(13,95.00,'1',2,13),(14,95.00,'1',7,14),(15,95.00,'1',1,15),(16,137.00,'2',15,15),(17,57.00,'15',3,16),(18,74.00,'22',2,16),(19,86.00,'11',5,17),(20,23.00,'19',5,18),(21,133.00,'16',6,18),(22,225.00,'27',3,19),(23,71.00,'17',32,20),(24,74.00,'22',1,20),(25,51.00,'3',3,21),(26,8.89,'4',3,22),(27,20.40,'9',2,22),(28,37.50,'14',2,23),(29,50.20,'7',1,24),(30,35.30,'20',13,25),(31,70.80,'17',3,26),(32,70.80,'17',3,27),(33,86.20,'11',1,27),(34,70.80,'17',5,28),(35,18.80,'18',3,28),(36,449.20,'6',1,29),(37,77.63,'23',2,30),(38,70.80,'17',3,31),(39,18.80,'18',4,31),(40,104.00,'8',3,32),(41,35.90,'21',2,32),(42,51.30,'3',2,33),(43,70.80,'17',6,33),(44,70.80,'17',3,34),(45,18.80,'18',2,34),(46,70.80,'17',2,35);
/*!40000 ALTER TABLE `orderItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `dateTime` datetime DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `order_user_userid_fk` (`userID`),
  CONSTRAINT `order_user_userid_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'2023-09-24 00:00:00',0.00),(2,1,'2023-09-24 13:51:44',0.00),(3,1,'2023-09-29 17:30:55',0.00),(5,1,'2023-10-01 11:36:26',0.00),(7,1,'2023-10-01 13:48:51',0.00),(8,1,'2023-10-01 13:52:16',0.00),(9,1,'2023-11-10 19:07:11',0.00),(10,1,'2023-11-10 19:10:08',0.00),(11,1,'2023-11-10 19:12:54',0.00),(12,1,'2023-11-11 04:02:02',0.00),(13,1,'2023-12-23 21:18:57',0.00),(14,1,'2023-12-24 06:00:53',0.00),(15,1,'2024-04-24 12:11:11',0.00),(16,1,'2024-04-24 12:18:00',0.00),(17,1,'2024-04-24 12:19:15',0.00),(18,1,'2024-04-24 13:28:01',0.00),(19,3,'2024-05-10 13:50:37',0.00),(20,3,'2024-05-10 13:51:46',0.00),(21,2,'2024-05-10 13:58:11',0.00),(22,2,'2024-05-10 16:16:34',0.00),(23,3,'2024-05-10 19:03:12',0.00),(24,3,'2024-05-10 19:11:38',0.00),(25,1,'2024-05-14 06:44:53',0.00),(26,2,'2024-05-14 06:44:59',0.00),(27,2,'2024-05-17 16:04:49',0.00),(28,3,'2024-05-18 03:38:35',0.00),(29,3,'2024-05-18 03:42:45',0.00),(30,2,'2024-06-07 18:10:02',0.00),(31,2,'2024-06-08 03:47:22',0.00),(32,2,'2024-06-26 14:13:51',0.00),(33,2,'2024-06-26 14:25:13',0.00),(34,2,'2024-06-26 14:26:51',250.00),(35,2,'2024-06-26 15:16:17',141.60);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'wlf','123456',1,'wanglefeng@sjtu.edu.cn'),(2,'zm','123456',1,'zm@cupde.edu.cn'),(3,'ypw','123456',1,'ypw@pku.edu.cn'),(4,'zyp','123456',2,'zyp@bjtu.edu.cn'),(5,'xqy',NULL,1,'xqy@su.edu.cn'),(6,'user1',NULL,1,'user1@example.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userAuth`
--

DROP TABLE IF EXISTS `userAuth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userAuth` (
  `password` varchar(255) DEFAULT NULL,
  `userID` int DEFAULT NULL,
  `authID` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`authID`),
  KEY `userAuth_user_userID_fk` (`userID`),
  CONSTRAINT `userAuth_user_userID_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userAuth`
--

LOCK TABLES `userAuth` WRITE;
/*!40000 ALTER TABLE `userAuth` DISABLE KEYS */;
INSERT INTO `userAuth` VALUES ('bookstore111',1,1),('111',2,2),('111',3,3),('111',4,4),('111',5,6),('111',6,7);
/*!40000 ALTER TABLE `userAuth` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-24 19:06:45
