SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
department_id int PRIMARY KEY AUTO_INCREMENT,
department_name VARCHAR,
description VARCHAR);


CREATE TABLE IF NOT EXISTS users (
employee_id int PRIMARY KEY AUTO_INCREMENT,
 fname VARCHAR,
  lname VARCHAR,
   position VARCHAR,
    employee_role VARCHAR,
     department_id int
     );

CREATE TABLE IF NOT EXISTS news (
news_id int PRIMARY KEY AUTO_INCREMENT,
 posted_by VARCHAR,
  department_id VARCHAR,
   news_content VARCHAR
    );

/*

INSERT INTO news (posted_by,department_id,news_content) VALUES ('Admin',1,'Meeting Tomorrow at 8:30am');
INSERT INTO users (fname,lname,position,employee_role,department) values ('Admin','Admin','Admin','Admin Stuff','1');*/
