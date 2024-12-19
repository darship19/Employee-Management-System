# Employee Management API

## Description
This project is a RESTful API for managing employee records. It provides CRUD operations (Create, Read, Update, and Delete) to interact with an `employee` database table. The API is built using **Spring Boot** and uses **MySQL** as the database.

---

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Database Setup](#database-setup)
- [API Endpoints](#api-endpoints)
- [How to Run](#how-to-run)
- [Future Enhancements](#future-enhancements)

---

## Features
- Add new employees to the database.
- Retrieve all employee records or a specific employee by ID.
- Update employee details (full record or specific attributes).
- Delete employees by ID.

---

## Technologies Used
- **Java 17**
- **Spring Boot 3.0+**
- **MySQL**
- **Lombok**
- **Swagger OpenAPI**
- **Log4j**

---

## Database Setup

Run the following SQL script to create the `employee` table:

```sql
CREATE TABLE work.employee (
    id INT UNIQUE KEY AUTO_INCREMENT,
    empNo VARCHAR(10) UNIQUE NOT NULL,
    empName VARCHAR(100) NOT NULL,
    empAddressLine1 NVARCHAR(100) NOT NULL,
    empAddressLine2 NVARCHAR(100),
    empAddressLine3 NVARCHAR(100),
    empDateOfJoin DATETIME NOT NULL,
    empStatus BOOL NOT NULL,
    empImage LONGTEXT NOT NULL
);
```

---

## API Endpoints

### 1. Create Employee
- **Method**: `POST`
- **URL**: `/employees`
- **Description**: Add a new employee.
- **Request Body**:
  ```json
  {
      "empNo": "E123",
      "empName": "John Doe",
      "empAddressLine1": "123 Main St",
      "empAddressLine2": "Suite 200",
      "empAddressLine3": "Cityville",
      "empDateOfJoin": "2024-01-01T10:00:00",
      "empStatus": true,
      "empImage": "<base64-encoded-image>"
  }
  ```

### 2. Retrieve All Employees
- **Method**: `GET`
- **URL**: `/employees`
- **Description**: Fetch all employees.

### 3. Retrieve Employee by ID
- **Method**: `GET`
- **URL**: `/employees/{id}`
- **Description**: Fetch a specific employee by ID.

### 4. Update Employee
- **Method**: `PUT`
- **URL**: `/employees/{id}`
- **Description**: Update all details of an employee.
- **Request Body**: Same as in `POST`.

### 5. Patch Employee
- **Method**: `PATCH`
- **URL**: `/employees/{id}`
- **Description**: Update specific fields of an employee.
- **Request Body**: Include only the fields to update.

### 6. Delete Employee
- **Method**: `DELETE`
- **URL**: `/employees/{id}`
- **Description**: Delete an employee by ID.

---

## How to Run

### Prerequisites
1. Install **Java 17+**.
2. Install **MySQL** and create the `work` database.
3. Set up the `application.properties` file to configure the database connection:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/work
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   spring.jpa.hibernate.ddl-auto=update
   ```

### Steps
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd employee-management-api
   ```
2. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Access the API documentation at: `http://localhost:8080/swagger-ui.html`

---
