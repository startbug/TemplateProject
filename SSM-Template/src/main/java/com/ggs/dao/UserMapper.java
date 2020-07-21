package com.ggs.dao;

import com.ggs.domain.User;

import java.util.List;

/**
 * @Author Starbug
 * @Date 2020/7/21 16:18
 */
public interface UserMapper {

    /**
     * SET NAMES utf8mb4;
     * SET FOREIGN_KEY_CHECKS = 0;
     *
     * DROP TABLE IF EXISTS `user`;
     * CREATE TABLE `user`  (
     *   `id` int(0) NOT NULL,
     *   `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   `pwd` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
     *   PRIMARY KEY (`id`) USING BTREE
     * ) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
     *
     * INSERT INTO `user` VALUES (2, 'zhangs', '123445');
     * INSERT INTO `user` VALUES (3, 'mmp', '321654');
     * INSERT INTO `user` VALUES (10, 'lucy', '123456');
     * INSERT INTO `user` VALUES (11, 'aat', '123456');
     *
     * SET FOREIGN_KEY_CHECKS = 1;
     * @return
     */

    List<User> getUserList();

}
