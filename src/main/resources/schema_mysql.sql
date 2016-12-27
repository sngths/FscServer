# 持久层MySQL数据库表创建
#


# ##################
# 用户 包括学生和老师用户
#
#
# #################
CREATE TABLE User (
    username              VARCHAR(64)     NOT NULL,
    plainPassword         VARCHAR(32),
    encryptedPassword     VARCHAR(255),
    name                  VARCHAR(100),
    email                 VARCHAR(100),
    creationDate          CHAR(15)        NOT NULL,
    modificationDate      CHAR(15)        NOT NULL,
    PRIMARY KEY (username),
    INDEX ofUser_cDate_idx (creationDate)
);


# 班级列表











CREATE TABLE IF NOT EXISTS `Users` (
    `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
    `id` varchar(200) NOT NULL,
    PRIMARY KEY (`user_id`)
);

