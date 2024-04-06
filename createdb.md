```
DROP DATABASE IF EXISTS employeedata;
CREATE DATABASE employeedata CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE employeedata;

CREATE TABLE employee_en (
 id INT AUTO_INCREMENT PRIMARY KEY,
 first_name VARCHAR(50),
 last_name VARCHAR(50),
 email VARCHAR(100)
);

CREATE TABLE employee_fa (
 id INT AUTO_INCREMENT PRIMARY KEY,
 first_name VARCHAR(50)CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
 last_name VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
 email VARCHAR(100)
);

CREATE TABLE employee_ja (
 id INT AUTO_INCREMENT PRIMARY KEY,
 first_name VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
 last_name VARCHAR(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci,
 email VARCHAR(100)
);
```