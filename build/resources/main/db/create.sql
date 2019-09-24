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
     department VARCHAR
     );

CREATE TABLE IF NOT EXISTS news (
news_id int PRIMARY KEY AUTO_INCREMENT,
 posted_by VARCHAR,
  department VARCHAR,
   news_content VARCHAR,
    posted_on DATE
    );


INSERT INTO users (fname,lname,position,employee_role,department) values ('Admin','Admin','Admin','Admin Stuff','1');