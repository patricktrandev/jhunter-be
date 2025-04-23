CREATE TABLE IF NOT EXISTS `company` (
  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
   `company_name` varchar(200) NOT NULL,
  `company_description` varchar(300) NOT NULL,
  `company_address` varchar(200) NOT NULL,
  `created_at` date NOT NULL,
   `created_by` varchar(20) NOT NULL,
   `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);