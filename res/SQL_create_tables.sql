DROP TABLE IF EXISTS `ORG_USERS`;

CREATE TABLE org_users (
    id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    username VARCHAR(30) NOT NULL,
    email2 VARCHAR(30),
    password VARCHAR(30) NOT NULL,
    mobile VARCHAR(30),
    mobile2 VARCHAR(30),  
    timezone VARCHAR(30) DEFAULT 'GMT Greenwich Mean Time',
    country VARCHAR(30)
);

DROP TABLE IF EXISTS `ORG_CONTACTS`;

CREATE TABLE org_contacts (
    id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    cfirstname VARCHAR(30) NOT NULL,
    clastname VARCHAR(30) NOT NULL,
    cemail VARCHAR(30) NOT NULL,
    cemail2 VARCHAR(30),
    cmobile VARCHAR(30),
    cmobile2 VARCHAR(30), 
    ccountry VARCHAR(30),
    user_id INTEGER UNSIGNED,
    FOREIGN KEY (user_id) REFERENCES org_users(id) 
);

DROP TABLE IF EXISTS `ORG_BUSINESS`;

CREATE TABLE org_business (
    id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    companyname VARCHAR(30),
    position VARCHAR(30),
    bemail VARCHAR(30),
    bemail2 VARCHAR(30),
    bmobile VARCHAR(30),
    bmobile2 VARCHAR(30), 
    fax VARCHAR(30),
    contacts_id INTEGER UNSIGNED,
    FOREIGN KEY (business_id) REFERENCES org_contacts(id) 
);

DROP TABLE IF EXISTS `ORG_NOTES`;

CREATE TABLE org_notes (
    id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    description VARCHAR(200),
    user_id INTEGER UNSIGNED,
    FOREIGN KEY (user_id) REFERENCES org_users(id)
);

DROP TABLE IF EXISTS `ORG_TASKS`;

CREATE TABLE org_tasks (
    id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    startTime TIMESTAMP NOT NULL,
    endTime TIMESTAMP NOT NULL,
    reocurring INTEGER UNSIGNED DEFAULT 2,
    notes_id INTEGER UNSIGNED,
    FOREIGN KEY (notes_id) REFERENCES org_notes(id) 
);

DROP TABLE IF EXISTS `ORG_EVENTS`;

CREATE TABLE org_events (
    id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    location VARCHAR(300) ,
    tasks_id INTEGER UNSIGNED,
    FOREIGN KEY (tasks_id) REFERENCES org_tasks(id) 
);

DROP TABLE IF EXISTS `ORG_PAYMENT`;

CREATE TABLE org_payment (
    id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    comming BOOLEAN,
    finished BOOLEAN,
    tasks_id INTEGER UNSIGNED,
    FOREIGN KEY (tasks_id) REFERENCES org_tasks(id) 
);

