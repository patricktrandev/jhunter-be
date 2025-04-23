CREATE TABLE IF NOT EXISTS `job` (
  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
   `company_id` BIGINT NOT NULL,
  `description` varchar(300) NOT NULL,
  `location` varchar(200) NOT NULL,
  `max_salary` varchar(200) NOT NULL,
  `min_salary` varchar(200) NOT NULL,
  `title` varchar(200) NOT NULL,
  `created_at` date NOT NULL,
   `created_by` varchar(20) NOT NULL,
   `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);