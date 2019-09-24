SET MODE PostgreSQL;

CREATE TABLE IF EXISTS departments (
department_id int PRIMARY KEY serial,
department_name VARCHAR,
description VARCHAR);


CREATE TABLE IF EXISTS users (
employee_id int PRIMARY KEY serial,
 fname VARCHAR,
  lname VARCHAR,
   position VARCHAR,
    employee_role VARCHAR,
     department VARCHAR
     );

CREATE TABLE IF EXISTS news (
news_id int PRIMARY KEY auto_increment,
 posted_by VARCHAR,
  department VARCHAR,
   news_content VARCHAR,
    posted_on DATE
    );
