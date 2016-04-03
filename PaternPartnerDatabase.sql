CREATE DATABASE PatternPartner;

USE PatternPartner;

CREATE TABLE IF NOT EXISTS Users (
    username VARCHAR(60),
    password VARCHAR(40),
    email VARCHAR(225),
    first_name VARCHAR(80),
    last_name VARCHAR(100),
    PRIMARY KEY (username),
    UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS Patterns (
    patternID INT AUTO_INCREMENT,
    username VARCHAR(60),
    title VARCHAR(225) NOT NULL,
    image LONGBLOB,
    description TEXT,
    knitOrCrochet VARCHAR(1),
    PRIMARY KEY (patternID)
);

CREATE TABLE IF NOT EXISTS PatternRows (
    patternID INT,
    lineID INT,
    lineText TEXT,
    isActive TINYINT,
    isRepeat TINYINT,
    PRIMARY KEY (patternID, lineID)
);

CREATE TABLE IF NOT EXISTS Materials (
    patternID INT,
    materialID INT,
    material TEXT,
    PRIMARY KEY (materialID, patternID)
);

CREATE TABLE IF NOT EXISTS Comments (
    commentID INT AUTO_INCREMENT,
    name VARCHAR(225),
    email VARCHAR(225),
    comment TEXT,
    PRIMARY KEY (commentID);
)