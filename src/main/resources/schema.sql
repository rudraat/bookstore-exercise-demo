CREATE TABLE IF NOT EXISTS `book` (
  `book_id` bigint NOT NULL AUTO_INCREMENT,
  `price` int DEFAULT NULL,
  `qty` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `book_order` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `customer_customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKoubuxiusqijm6eq10jaoc7vqa` (`customer_customer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `book_order_books` (
  `order_order_id` bigint NOT NULL,
  `books_book_id` bigint NOT NULL,
  PRIMARY KEY (`order_order_id`,`books_book_id`),
  UNIQUE KEY `UK_fpsua4j7dk2gj7psiogimidq2` (`books_book_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;