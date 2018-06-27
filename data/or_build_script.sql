DROP DATABASE IF EXISTS oneroster;
CREATE DATABASE oneroster;
USE oneroster;

CREATE TABLE users (
	sourcedID INT NOT NULL AUTO_INCREMENT,
    userStatus VARCHAR(255) NOT NULL,
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    userName VARCHAR(255) NOT NULL,
    metadata VARCHAR(255) NULL,
    givenName VARCHAR(255) NOT NULL,
    familyName VARCHAR(255) NOT NULL,
    middleName VARCHAR(255) NULL,
    roleID INT NOT NULL,
    phone VARCHAR(255) NULL,
    orgs VARCHAR(1024) NULL,
    PRIMARY KEY (SourcedID)
);



insert into users (userStatus, userName, givenName, familyName, roleID, phone, orgs) 
VALUES ('active','danimaetrix','danimae','janssen', 1, '218-343-1901', 'Perficient')