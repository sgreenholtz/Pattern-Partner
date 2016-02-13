USE PatternPartner;

CREATE TABLE IF NOT EXISTS Users (
    username VARCHAR(60),
    password VARCHAR(40),
    email VARCHAR(225),
    PRIMARY KEY (username),
    UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS Patterns (
    patternID INT AUTO_INCREMENT,
    username VARCHAR(60),
    title VARCHAR(225) NOT NULL,
    image LONGBLOB,
    description TEXT,
    materials TEXT,
    PRIMARY KEY (patternID)
);

CREATE TABLE IF NOT EXISTS KnitPatternRows (
    patternID INT,
    lineID INT,
    lineText TEXT,
    isActive TINYINT,
    isRepeat TINYINT,
    PRIMARY KEY (patternID, lineID)
);

CREATE TABLE IF NOT EXISTS CrochetPatternRows (
    patternID INT,
    lineID INT,
    lineText TEXT,
    isActive TINYINT,
    isRepeat TINYINT,
    PRIMARY KEY (patternID, lineID)
);