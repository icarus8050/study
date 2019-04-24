CREATE TABLE member (
    id LONG NOT NULL,
    name VARCHAR(255),
    age INTEGER NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO member values ( 1, '대한민국', 26 );
INSERT INTO member values ( 2, '미국', 28 );
INSERT INTO member values ( 3, '프랑스', 23 );