-- 持久层MySQL数据库表创建




-- 用户 包括学生和老师用户

CREATE TABLE user (
  id                    BIGINT AUTO_INCREMENT,
  username              VARCHAR(64)     NOT NULL, -- 用户名
  password              VARCHAR(32)     NOT NULL,
  salt                  CHAR(32),
  userType              ENUM ('t', 's') NOT NULL,
  modificationTimestamp BIGINT,
  creationTimestamp     BIGINT,
  email                 VARCHAR(100),
  PRIMARY KEY (id, username)
);

-- 班级列表











CREATE TABLE IF NOT EXISTS `Users` (
  `user_id` BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `id`      VARCHAR(200) NOT NULL,
  PRIMARY KEY (`user_id`)
);

