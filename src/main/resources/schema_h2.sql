
CREATE TABLE User (
    username              VARCHAR(64)     NOT NULL,
    password              VARCHAR(32),
    email                 VARCHAR(100),
    PRIMARY KEY (username),
);