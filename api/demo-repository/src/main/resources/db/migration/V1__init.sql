CREATE TABLE TB_CLIENT (
  id            BIGINT IDENTITY PRIMARY KEY,
  name          VARCHAR(150) NOT NULL,
  credit_limit  FLOAT        NOT NULL,
  interest_rate INT          NOT NULL,
  risk          VARCHAR(10)  NOT NULL
);

INSERT INTO TB_CLIENT (name, credit_limit, interest_rate, risk) VALUES ('Chris', 10000.0, 0, 'A');
