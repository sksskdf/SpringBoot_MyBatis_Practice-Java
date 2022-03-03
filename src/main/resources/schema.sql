use mybatisex;

CREATE TABLE city
(
    id      INT PRIMARY KEY auto_increment,
    name    VARCHAR(20),
    state   VARCHAR(100),
    country VARCHAR(100)
);