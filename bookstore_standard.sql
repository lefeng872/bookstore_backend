/*
 Navicat Premium Data Transfer

 Source Server         : mysql_database
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 23/09/2023 19:21:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` varchar(2000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `inventory` int NOT NULL,
  `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of book
-- ----------------------------
BEGIN;
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (1, '1', 'Java核心技术卷II', '编程', '凯S.霍斯特曼', 95.20, '本书是Java领域有影响力和价值的著作之一，由拥有20多年教学与研究经验的Java技术专家撰写（获Jolt大奖），与《Java编程思想》齐名，10余年全球畅销不衰，广受好评。第10版根据JavaSE8全面更新，同时修正了第9版中的不足，系统全面讲解了Java语言的核心概念、语法、重要特性和开发方法，包含大量案例，实践性强。', 898, 'http://img3m9.ddimg.cn/12/36/1546133799-1_w_1.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (2, '2', '深入理解计算机系统', '编程', '兰德尔·E·布莱恩特', 136.90, '程序员必读经典著作！理解计算机系统*书目，10万程序员共同选择。第二版销售突破100000册，第三版重磅上市！', 1194, 'http://img3m7.ddimg.cn/48/0/24106647-1_w_6.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (3, '3', 'Effective C++', '编程', '梅耶', 51.30, '大师名著纵横二十载，稳居任一荐书单三甲；称职程序员傍身绝学，通向C++精微奥妙之门。', 988, 'http://img3m6.ddimg.cn/96/25/21000966-1_u_12.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (4, '4', '小王子', '儿童文学', '圣-埃克苏佩里', 8.89, '豆瓣9.7高分推荐！旅法翻译家梅子涵之女梅思繁法文直译，舒朗大开本，央美教授高精度还原原作插画。首次收录全球舞台剧、音乐会、电影、动画片等对《小王子》的精彩诠释，通晓名作的前世今生。', 991, 'http://img3m9.ddimg.cn/75/6/25067469-1_u_2.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (5, '5', 'Java编程思想', '编程', 'Bruce Eckel', 91.20, 'Java学习必读经典,殿堂级著作！赢得了全球程序员的广泛赞誉。', 9091, 'http://img3m0.ddimg.cn/4/24/9317290-1_w_5.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (6, '6', '魔兽世界编年史套装(全三卷)', '魔幻小说', '克里斯˙梅森', 449.20, '暴雪官方历时二十年编纂而成的史料！三卷《魔兽世界编年史》将呈现大量从未公布的精美原画和插图，读者在阅读故事之余，更能享受一次视觉上的饕餮盛宴，是魔兽粉丝收藏的优选。', 100, 'http://img3m7.ddimg.cn/43/9/25352557-1_w_3.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (7, '7', '三体：全三册', '科幻小说', '刘慈欣', 50.20, '刘慈欣代表作，亚洲首部“雨果奖”获奖作品！', 14395, 'http://img3m4.ddimg.cn/32/35/23579654-1_u_3.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (8, '8', '悲惨世界（上中下）（精装版）', '世界名著', '雨果', 104.00, '《悲惨世界》是雨果在流亡期间写的长篇小说，是他的代表作，也是世界文学宝库的珍品之一。\r\n    《悲惨世界》通过冉阿让等人的悲惨遭遇以及冉阿让被卞福汝主教感化后一系列令人感动的事迹，深刻揭露和批判了19世纪法国封建专制社会的腐朽本质及其罪恶现象，对穷苦人民在封建重压下所遭受的剥削欺诈和残酷迫害表示了悲悯和同情。', 383, 'http://img3m7.ddimg.cn/13/15/27912667-1_u_1.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (9, '9', '动物农场', '社会小说', '乔治·奥威尔', 20.40, '也译“动物庄园”，是“一代人的冷峻良知”乔治·奥威尔经典的讽喻之作。虽然这一场荒诞的动物革命走向歧途，但正是因为这样我们才了解“把权力关进制度的笼子”的重要性。', 90, 'http://img3m1.ddimg.cn/82/3/25229341-1_w_2.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (10, '10', '机器学习', '编程', '周志华', 61.60, '击败AlphaGo的武林秘籍，赢得人机大战的必由之路：人工智能大牛周志华教授巨著，全面揭开机器学习的奥秘。', 2497, 'http://img3m0.ddimg.cn/20/24/23898620-1_w_3.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (11, '11', '纳尼亚传奇', '魔幻小说', '刘易斯', 86.20, '刘易斯基金会独家授权插图！翻译家吴岩，陈良廷，刘文澜经典译本！', 105, 'http://img3m7.ddimg.cn/1/32/22474387-1_u_2.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (12, '12', '老人与海', '世界名著', '海明威', 27.80, '收录诺贝尔文学奖获奖作品《老人与海》《乞力马扎罗的雪》，深深影响了马尔克斯、塞林格等文学家的创作理念。', 2411, 'http://img3m6.ddimg.cn/94/11/27891166-1_u_2.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (13, '13', '魔力的胎动', '悬疑/推理小说', '东野圭吾', 35.90, '喜欢《解忧杂货店》，就一定要读这本书。珍藏印签。有了想要守护的东西，生命就会变得有力量。悲凉的人生、千疮百孔的命运、一桩桩悲剧的发生与救赎，读来令人喟叹不已。', 1209, 'http://img3m4.ddimg.cn/68/35/28484744-2_u_6.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (14, '14', '我不怕这漫长黑夜', '青春文学', '苑子豪', 37.50, '七篇寻光故事，七种奇遇人生，送给成长路上孤独前行的你，每个人的生活都有被困在井里一样的绝望时刻，而这本书就想做点亮黑夜的那束光芒。耐心一些，保持相信，我们终会穿越漫长黑夜，抵达属于自己的黎明。', 1140, 'http://img3m0.ddimg.cn/9/18/28486170-1_u_8.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (15, '15', '永久记录', '传记文学', '爱德华·斯诺登', 56.70, '美国政府不想让全世界读到这本书，欧美上市当日作者便被美国司法部起诉！“棱镜门”主角爱德华·斯诺登首次亲自披露美国政府滥用NSA系统监控世界的真相，袒露从“爱国者”到“叛国者”的心路历程。', 123, 'http://img3m5.ddimg.cn/86/22/28475555-2_u_9.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (16, '16', '探索月球', '儿童文学', '安妮·詹克利奥维奇', 133.20, '嫦娥五号探测器系统副总设计师彭兢诚意推荐！纪念人类登月50周年，五大精妙立体机关直观呈现月球的运行轨迹，全方位揭秘人类探月登月的过程，普及基本的航天知识，与孩子一起解读月球的奥秘，种下探索宇宙的种子。', 1510, 'http://img3m4.ddimg.cn/13/30/28481224-1_w_3.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (17, '17', '高考英语 五年高考三年模拟', '中小学教辅', '曲一线', 70.80, '五年高考三年模拟，英语五三高考练习册，五三高中同步53全练全解，你值得拥有！', 12332, 'http://img3m4.ddimg.cn/62/14/27883214-1_w_2.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (18, '18', '红楼梦', '世界名著', '曹雪芹', 18.80, '中国古典小说佳作，影响整个华人世界的经典！轻松易学、国家教育部推荐读物！', 2200, 'http://img3m6.ddimg.cn/31/22/23828836-1_w_8.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (19, '19', '草房子', '儿童文学', '曹文轩', 22.50, '人民文学出版社天天出版社出品，经典作品，教师推荐，已有超过150000读者给予好评！', 1231, 'http://img3m2.ddimg.cn/32/4/23662022-1_w_9.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (20, '20', '追风筝的人', '世界名著', '卡勒德·胡赛尼', 35.30, '“许多年过去了，人们说陈年旧事可以被埋葬，然而我终于明白这是错的，因为往事会自行爬上来。回首前尘，我意识到在过去二十六年里，自己始终在窥视着那荒芜的小径。”', 14141, 'http://img3m5.ddimg.cn/26/14/25238195-1_w_3.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (21, '21', '软件工程原理', '编程', '沈备军、陈昊鹏、陈雨亭', 35.90, '从软件工程的本质出发、结合实际案例，系统全面地介绍软件过程、软件建模技术与方法及软件工程管理同时介绍一些热点新技术和新方法。', 1024, 'http://img3m6.ddimg.cn/32/30/1204489076-1_w_1.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (22, '22', '数据库系统概念', '编程', '西尔伯沙茨', 74.20, '本书内容丰富，不仅讨论了关系数据模型和关系语言、数据库设计过程、关系数据库理论、数据库应用设计和开发、数据存储结构、数据存取技术、查询优化方法、事务处理系统和并发控制、故障恢复技术、数据仓库和数据挖掘，而且对性能调整、性能评测标准、数据库应用测试和标准化等高级应用主题进行了广泛讨论。', 242, 'http://img3m2.ddimg.cn/83/5/22632572-1_w_1.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (23, '23', '算法导论', '编程', '科尔曼', 77.63, '全书选材经典、内容丰富、结构合理、逻辑清晰，对本科生的数据结构课程和研究生的算法课程都是非常实用的教材，在IT专业人员的职业生涯中，本书也是一本案头必备的参考书或工程实践手册。', 144, 'http://img3m8.ddimg.cn/89/15/1517005898-1_w_1.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (24, '24', '史记（文白对照本）', '古籍', '司马迁', 237.10, '荣获商务印书馆2019人文社科十大好书，张大可先生《史记》研究的集成之作，精细考证，廓清原书真伪；题解语译，展现著者史观，是一部人人都能读懂、人人都会爱读的文白对照本《史记》。', 4141, 'http://img3m7.ddimg.cn/14/14/27915737-1_w_3.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (25, '25', '天龙八部(全五册)', '武侠小说', '金庸', 102.30, '《天龙八部》一书以北宋、辽、西夏、大理并立的历史为宏大背景，将儒释道、琴棋书画等中国传统文化融会贯通其中，书中人物繁多，个性鲜明，情节离奇，尽显芸芸众生百态。', 74747, 'http://img3m2.ddimg.cn/84/17/23273202-1_w_1.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (26, '26', '笑傲江湖(全四册)', '武侠小说', '金庸', 80.10, '一部《辟邪剑谱》引发灭门血案，阴险狡诈，机关算尽，只为争霸武林，真相往往出人意表。酒后高歌磨剑，梦中快意恩仇，一曲《笑傲江湖》，传一段天荒地老。 ', 2518, 'http://img3m0.ddimg.cn/82/15/23273200-1_w_1.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (27, '27', '楚留香传奇(全三册)', '武侠小说', '古龙', 224.50, '《楚留香传奇》无疑乃古龙诸作中*为烩炙人口之作，此作固成就古龙之盛名，更成为武侠文学之重要里程碑。楚留香有西方007罗杰摩尔之冷静、优雅、明快及幽默，更因他没有复仇及情爱之纠葛（例如他从来不杀人）而超越007，颇有“本来无一物，何处惹尘埃”的意境。', 528, 'http://img3m4.ddimg.cn/4/22/1592963464-1_w_1.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (28, '28', '哈利波特与魔法石', '魔幻小说', 'J·K·罗琳', 30.20, '“沉湎于虚幻的梦想，而忘记现实的生活，这是毫无益处的，千万记住。”                                ——阿不思·邓布利多', 999, 'http://img3m1.ddimg.cn/88/0/25479421-1_w_1.jpg');
INSERT INTO `book` (`id`, `isbn`, `name`, `type`, `author`, `price`, `description`, `inventory`, `image`) VALUES (29, '29', '哈利·波特与死亡圣器', '魔幻小说', 'J·K·罗琳', 56.20, '两个人不能都活着，只有一个生存下来，我们中的一个将要永远离开……', 1550, 'http://img3m4.ddimg.cn/71/20/25479404-1_w_1.jpg');
COMMIT;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  PRIMARY KEY (`cartID`),
  KEY `cart_user_userid_fk` (`userID`),
  CONSTRAINT `cart_user_userid_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of cart
-- ----------------------------
BEGIN;
INSERT INTO `cart` (`cartID`, `userID`) VALUES (1, 1);
COMMIT;

-- ----------------------------
-- Table structure for cartItem
-- ----------------------------
DROP TABLE IF EXISTS `cartItem`;
CREATE TABLE `cartItem` (
  `bookAmount` int NOT NULL,
  `cartItemID` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `cartID` int NOT NULL,
  PRIMARY KEY (`cartItemID`),
  KEY `FKt0ybwcb231s8mrss65ml02noj` (`cartID`),
  CONSTRAINT `cartitem_cart_cartid_fk` FOREIGN KEY (`cartID`) REFERENCES `cart` (`cartID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of cartItem
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for orderItem
-- ----------------------------
DROP TABLE IF EXISTS `orderItem`;
CREATE TABLE `orderItem` (
  `orderItemID` int NOT NULL AUTO_INCREMENT,
  `currentPrice` int NOT NULL,
  `isbn` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `bookAmount` int NOT NULL,
  `orderID` int NOT NULL,
  PRIMARY KEY (`orderItemID`),
  KEY `orderitem_orders_orderid` (`orderID`),
  CONSTRAINT `orderitem_orders_orderid` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of orderItem
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `userID` int NOT NULL,
  `orderDate` datetime DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `order_user_userid_fk` (`userID`),
  CONSTRAINT `order_user_userid_fk` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`userID`, `username`, `password`, `type`, `email`) VALUES (1, 'wlf1', '123456', 1, 'wanglefeng@sjtu.edu.cn');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
