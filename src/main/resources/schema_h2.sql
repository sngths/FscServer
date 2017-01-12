CREATE TABLE user (
  id                    BIGINT                                              AUTO_INCREMENT,
  username              VARCHAR(64) NOT NULL,
  password              VARCHAR(32) NOT NULL,
  salt                  CHAR(32),
  userType              CHAR(10)    DEFAULT ('s'),
  modificationTimestamp BIGINT,
  creationTimestamp     BIGINT,
  email                 VARCHAR(100),
  PRIMARY KEY (id, username)
);

--班级相关
CREATE TABLE classInfo (
  id   INT AUTO_INCREMENT,
  class TINYINT NOT NULL,
  grade TINYINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  info TEXT,
  PRIMARY KEY (id)
);

--学生所在班级
CREATE TABLE studentClass (
  userID    BIGINT NOT NULL, -- 学生ID
  classID   INT    NOT NULL, -- 班级ID
  timestamp BIGINT, -- 添加时间戳
  PRIMARY KEY (userID)
);
--添加学生班级索引
CREATE INDEX studentClassIndex ON studentClass (classID);

--老师所在班级
CREATE TABLE teacherClass (
  id         INT AUTO_INCREMENT,
  userID     BIGINT NOT NULL,
  classID    INT    NOT NULL,
  courseType CHAR   NOT NULL,
  timestamp  BIGINT,
  PRIMARY KEY (id)
);
--添加老师班级索引
CREATE INDEX teacherClassIndex ON teacherClass (userID, classID);







--离线消息 保存发送给单个用户的离线消息
CREATE TABLE offlineMessage (
  username VARCHAR(64) NOT NULL,
  PASSWORD VARCHAR(32),
  email    VARCHAR(100),
  PRIMARY KEY (username)
);

--多人聊天成员 用于查找固定房间中的用户列表

CREATE TABLE mucMember (
  username VARCHAR(64) NOT NULL,
  password VARCHAR(32),
  email    VARCHAR(100),
  PRIMARY KEY (username)
);

CREATE TABLE mucRoom (
  username VARCHAR(64) NOT NULL,
  password VARCHAR(32),
  email    VARCHAR(100),
  PRIMARY KEY (username)
);

CREATE TABLE mucMessage (
  username VARCHAR(64) NOT NULL,
  password VARCHAR(32),
  email    VARCHAR(100),
  PRIMARY KEY (username),
);