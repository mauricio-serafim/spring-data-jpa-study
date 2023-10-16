SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `kitchen`(
	`id` BIGINT NOT NULL AUTO_INCREMENT ,
	`name` VARCHAR(60) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `modified_at` DATETIME NOT NULL,
    `enabled` BIT NOT NULL,
	CONSTRAINT `pkPermission` PRIMARY KEY (`id`)
);

CREATE TABLE `restaurant` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(60) NOT NULL,
    `kitchen_id` BIGINT NOT NULL,
    `freight_rate` DECIMAL(13,2) NOT NULL,
    `created_at` DATETIME NOT NULL,
    `modified_at` DATETIME NOT NULL,
    `enabled` BIT NOT NULL,
    CONSTRAINT `pkRestaurant` PRIMARY KEY (`id`)
);

ALTER TABLE `restaurant` ADD CONSTRAINT `fkRestaurant_Kitchen` FOREIGN KEY (`kitchen_id`) REFERENCES `kitchen`(`id`);

SET FOREIGN_KEY_CHECKS=1;