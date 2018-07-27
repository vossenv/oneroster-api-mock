CREATE TABLE schools(
	schoolId INT NOT NULL AUTO_INCREMENT,
    sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
	metadata VARCHAR(255) NULL,
	`name` VARCHAR(255) NULL,
    identifier VARCHAR(255) NULL,
    `type` VARCHAR(255) NULL DEFAULT 'school',
    PRIMARY KEY (schoolId),
    UNIQUE (sourcedId),
    UNIQUE (identifier)
);


CREATE TABLE users (
	userId INT NOT NULL AUTO_INCREMENT,
	sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
    metadata VARCHAR(255) NULL,
    enabledUser BOOLEAN NULL DEFAULT TRUE,
    userIds VARCHAR (512) NULL,
    identifier VARCHAR(255) NULL,
    schoolId INT NULL,
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
    FOREIGN KEY (schoolId) REFERENCES schools(schoolId)
);


CREATE TABLE courses(
	courseId INT NOT NULL AUTO_INCREMENT,
	sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
	metadata VARCHAR(255) NULL,
	grade VARCHAR(255) NULL,
    title VARCHAR(255) NULL,
    schoolYear VARCHAR(512) NULL,
    courseCode VARCHAR(255) NULL,
    subjects VARCHAR(512) NULL,
    schoolId INT NULL,
    PRIMARY KEY (courseId),
    UNIQUE (sourcedId),
    FOREIGN KEY (schoolId) REFERENCES schools(schoolId)
);


CREATE TABLE classes(
	classId INT NOT NULL AUTO_INCREMENT,
    sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
	metadata VARCHAR(255) NULL,
    term VARCHAR(255) NULL,
	classCode VARCHAR(255) NULL,
    classType VARCHAR(255) NULL DEFAULT 'scheduled',
    location VARCHAR(255) NULL,
	courseId INT NULL,
    schoolId INT NULL,
    periods VARCHAR(255) NULL,
    PRIMARY KEY (classId),
    UNIQUE (sourcedId),
    FOREIGN KEY (schoolId) REFERENCES schools(schoolId),
    FOREIGN KEY (courseId) REFERENCES courses(courseId)
);


CREATE TABLE enrollments(
	enrollmentId INT NOT NULL AUTO_INCREMENT,
    sourcedId VARCHAR(512) NOT NULL,
    `status` VARCHAR(255) NULL DEFAULT 'active',
    dateLastModified DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
	metadata VARCHAR(255) NULL,
    userId INT NULL,
    classId INT NULL,
    isPrimary BOOLEAN NULL,
    beginDate DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
    endDate DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
	PRIMARY KEY (enrollmentId),
    UNIQUE (sourcedId),
    FOREIGN KEY (classId) REFERENCES classes(classId),
	FOREIGN KEY (userId) REFERENCES users(userId)
);
