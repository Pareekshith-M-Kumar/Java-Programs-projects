# Complaint Management System (Java Servlet + JSP)

This project is developed as part of **College Java PBL Activity**.

It is a simple web-based application where users can:

* Register & Login
* Submit complaints
* View dashboard
* Admin can manage complaints

---

## Tech Stack

* Java (Servlet & JSP)
* Apache Tomcat
* MySQL
* JDBC
* HTML, CSS

---

## Project Structure

```
ComplaintSys/
│
├── WEB-INF/
│   ├── classes/
│   │   └── com/project/servlet/
│   └── web.xml
│
├── login.html
├── register.html
├── dashboard.jsp
├── complaint.jsp
├── admin.jsp
├── style.css
```

---

## Setup Instructions (Commands Only)

### 1. Clone Project

```
git clone <your-repo-link>
cd ComplaintSys
```

---

### 2. Setup Database (MySQL)

```
CREATE DATABASE complaintdb;
USE complaintdb;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE complaints (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    category VARCHAR(100),
    description TEXT,
    status VARCHAR(50) DEFAULT 'Pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

---

### 3. Add MySQL Connector

Download:

```
mysql-connector-j-x.x.x.jar
```

Copy to:

```
tomcat/webapps/ComplaintSys/WEB-INF/lib/
```

---

### 4. Compile Java Files

```
javac -d WEB-INF/classes src/com/project/servlet/*.java
javac -d WEB-INF/classes src/com/project/util/*.java
```

---

### 5. Start Tomcat

```
cd C:\tomcat\bin
startup.bat
```

---

### 6. Run Project in Browser

```
http://localhost:8080/ComplaintSys/login.html
```

---

## Features

* User Registration & Login
* Complaint Submission
* Dashboard UI
* Admin Login
* Complaint Status Update

---

## Notes

* Ensure MySQL is running before starting Tomcat
* Update DB credentials in `DBConnection.java`
* Place `.class` files correctly inside `WEB-INF/classes`

---

## Author

Developed for **Java PBL Activity**

---
