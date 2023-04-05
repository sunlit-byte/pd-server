CREATE TABLE `score`  (
                               `id` int(8) NOT NULL AUTO_INCREMENT,
                               `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                               `create_time` datetime NULL DEFAULT NULL,
                               `update_time` datetime NULL DEFAULT NULL,
                               `delete_flag` int(2) NULL DEFAULT 0,
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;

CREATE TABLE `score_record`  (
                          `id` int(8) NOT NULL AUTO_INCREMENT,
                          `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `operate` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                          `create_time` datetime NULL DEFAULT NULL,
                          `update_time` datetime NULL DEFAULT NULL,
                          `delete_flag` int(2) NULL DEFAULT 0,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;