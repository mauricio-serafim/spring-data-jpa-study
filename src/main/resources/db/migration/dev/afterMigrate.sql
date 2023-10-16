INSERT INTO `kitchen`(`name`, `created_at`, `modified_at`, `enabled`) VALUES
    ('Brazilian', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('Korean', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE);

INSERT INTO `restaurant`(`name`, `kitchen_id`, `freight_rate`, `enabled`, `created_at`, `modified_at`) VALUES
    ('Brazilian', (SELECT id FROM `kitchen` WHERE `name` = 'Brazilian'), 12.3, TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Korean', (SELECT id FROM `kitchen` WHERE `name` = 'Korean'), 14.3, TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);