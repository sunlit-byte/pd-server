CREATE TABLE `article`  (
                            `id` int(8)  NOT NULL AUTO_INCREMENT,
                            `article_id` varchar(32)  NULL DEFAULT NULL,
                            `user_id` varchar(32)  NULL DEFAULT NULL,
                            `article_name` varchar(32)  NULL DEFAULT NULL,
                            `article_introduce` varchar(64)  NULL DEFAULT NULL,
                            `create_time` datetime NULL DEFAULT NULL,
                            `update_time` datetime NULL DEFAULT NULL,
                            `delete_flag` int(2) NULL DEFAULT 0,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;

CREATE TABLE `article_info`  (
                                 `id` int(8)  NOT NULL AUTO_INCREMENT,
                                 `article_id` varchar(32)  NULL DEFAULT NULL,
                                 `user_id` varchar(32)  NULL DEFAULT NULL,
                                 `article_name` varchar(32)  NULL DEFAULT NULL,
                                 `image_id` varchar(225)  NULL DEFAULT NULL,
                                 `article_content` text  NULL,
                                 `create_time` datetime NULL DEFAULT NULL,
                                 `update_time` datetime NULL DEFAULT NULL,
                                 `delete_flag` int(2) NULL DEFAULT 0,
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;