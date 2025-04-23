CREATE TABLE IF NOT EXISTS `reviews` (
  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
   `company_id` BIGINT NOT NULL,
  `rating` DOUBLE PRECISION NOT NULL,
  `review_description` varchar(300) NOT NULL,
  `title` varchar(200) NOT NULL,
  `created_at` date NOT NULL,
   `created_by` varchar(20) NOT NULL,
   `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);