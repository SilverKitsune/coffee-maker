CREATE TABLE IF NOT EXISTS coffeeMakers
(
    name VARCHAR(200) PRIMARY KEY ,
    coffee INTEGER NOT NULL ,
    water INTEGER NOT NULL ,
    MAX_COFFEE INTEGER NOT NULL ,
    MIN_COFFEE INTEGER NOT NULL ,
    MAX_WATER INTEGER NOT NULL ,
    MIN_WATER INTEGER NOT NULL ,
    cupsCount INTEGER NOT NULL
);