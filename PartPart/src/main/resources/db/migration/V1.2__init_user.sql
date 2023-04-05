CREATE TABLE `user`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `image_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `create_time` datetime NULL DEFAULT NULL,
                         `update_time` datetime NULL DEFAULT NULL,
                         `delete_flag` int(2) NULL DEFAULT 0,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;

CREATE TABLE `user_token`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                         `create_time` datetime NULL DEFAULT NULL,
                         `update_time` datetime NULL DEFAULT NULL,
                         `expire_time` datetime NULL DEFAULT NULL,
                         `delete_flag` int(2) NULL DEFAULT 0,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;