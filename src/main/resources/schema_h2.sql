CREATE TABLE user (
  id           BIGINT AUTO_INCREMENT,
  username     VARCHAR(64) NOT NULL, --用户名
  password     VARCHAR(32) NOT NULL ,
  salt         CHAR(32),
  --timestamp    BIGINT      NOT NULL,
  --creationDate BIGINT      NOT NULL,
  email        VARCHAR(100),
  PRIMARY KEY (username),
);

--离线消息 保存发送给单个用户的离线消息
CREATE TABLE offlineMessage (
  username VARCHAR(64) NOT NULL,
  password VARCHAR(32),
  email    VARCHAR(100),
  PRIMARY KEY (username),
);

--多人聊天成员 用于查找固定房间中的用户列表

CREATE TABLE mucMember (
  username VARCHAR(64) NOT NULL,
  password VARCHAR(32),
  email    VARCHAR(100),
  PRIMARY KEY (username),
);

CREATE TABLE mucRoom (
  username VARCHAR(64) NOT NULL,
  password VARCHAR(32),
  email    VARCHAR(100),
  PRIMARY KEY (username),
);

CREATE TABLE mucMessage (
  username VARCHAR(64) NOT NULL,
  password VARCHAR(32),
  email    VARCHAR(100),
  PRIMARY KEY (username),
);