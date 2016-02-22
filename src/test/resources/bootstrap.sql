USE test;

CREATE TABLE users (
  name     VARCHAR(20) PRIMARY KEY,
  password VARCHAR(20)
);

INSERT INTO users VALUES ('zhangsan', '123456');
INSERT INTO users VALUES ('lisi', '666666');
