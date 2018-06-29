DROP DATABASE IF EXISTS oneroster;
CREATE DATABASE oneroster;
USE oneroster;


CREATE TABLE Orgs(
	orgId INT NOT NULL AUTO_INCREMENT,
    sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,	
	metadata VARCHAR(255) NULL,
	`name` VARCHAR(255) NULL,
    identifier VARCHAR(255) NULL,
    `type` VARCHAR(255) NULL DEFAULT 'school',
    PRIMARY KEY (orgId),
    UNIQUE (sourcedId),
    UNIQUE (identifier)
);


CREATE TABLE Users (
	userId INT NOT NULL AUTO_INCREMENT,
	sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
    metadata VARCHAR(255) NULL,
    enabledUser BOOLEAN NULL DEFAULT TRUE,
    userIds VARCHAR (512) NULL,   
    identifier VARCHAR(255) NULL,
    orgId INT NULL,    
    givenName VARCHAR(255) NULL,
    familyName VARCHAR(255) NULL,
    middleName VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    username VARCHAR(255) NULL,
    phone VARCHAR(255) NULL,
    role VARCHAR(255) NULL DEFAULT 'student',
    grades VARCHAR(255) NULL,
    `type` VARCHAR(255) NULL DEFAULT 'LDAP',
    `password` VARCHAR(512) NULL DEFAULT 'secret',
    PRIMARY KEY (userId),
    UNIQUE (sourcedId),
    UNIQUE (identifier),
    FOREIGN KEY (orgId) REFERENCES Orgs(orgId)
);


CREATE TABLE Courses(
	courseId INT NOT NULL AUTO_INCREMENT,	
	sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,	
	metadata VARCHAR(255) NULL,
    title VARCHAR(255) NULL,
    schoolYear VARCHAR(512) NULL,
    courseCode VARCHAR(255) NULL,
    grade VARCHAR(255) NULL,
    subjects VARCHAR(512) NULL,
    orgID INT NULL,
    PRIMARY KEY (courseId),
    UNIQUE (sourcedId),
    FOREIGN KEY (orgId) REFERENCES Orgs(orgId)    
);


CREATE TABLE Classes(
	classId INT NOT NULL AUTO_INCREMENT,
    sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,	
	metadata VARCHAR(255) NULL,
	classCode VARCHAR(255) NULL,
    classType VARCHAR(255) NULL DEFAULT 'scheduled',
    location VARCHAR(255) NULL,
	courseId INT NULL,
    orgId INT NULL,
    term VARCHAR(255) NULL,
    periods VARCHAR(255) NULL,
    PRIMARY KEY (classId),
    UNIQUE (sourcedId),
    FOREIGN KEY (orgId) REFERENCES Orgs(orgId),
    FOREIGN KEY (courseId) REFERENCES Courses(courseId)    
);


CREATE TABLE Enrollments(
	enrollmentId INT NOT NULL AUTO_INCREMENT,
    sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,	
	metadata VARCHAR(255) NULL,
    userId INT NULL,
    classId INT NULL,
    role VARCHAR(255) NULL DEFAULT 'student',
    `primary` BOOLEAN NULL,
    beginDate DATETIME DEFAULT CURRENT_TIMESTAMP NULL,	
    endDate DATETIME DEFAULT CURRENT_TIMESTAMP NULL,	
	PRIMARY KEY (enrollmentId),
    UNIQUE (sourcedId),
    FOREIGN KEY (classId) REFERENCES Classes(classId),
	FOREIGN KEY (userId) REFERENCES Users(userId)            
);


LOAD DATA INFILE 'D:\Repositories\\Adobe\\oneroster-api-mock\\data\\orgs.csv'
REPLACE
INTO TABLE Orgs
fields terminated BY ','
optionally enclosed by '"'
lines terminated BY '\n'
IGNORE 1 LINES;

LOAD DATA INFILE 'D:\Repositories\\Adobe\\oneroster-api-mock\\data\\users.csv'
REPLACE
INTO TABLE Users
fields terminated BY ','
optionally enclosed by '"'
lines terminated BY '\n'
IGNORE 1 LINES;