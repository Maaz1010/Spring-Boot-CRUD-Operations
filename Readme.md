# Employee CRUD System Using Spring Boot and REST APIs

## Description
This project is a **Employee CRUD System** built using **Spring Boot**. It demonstrates the implementation of **CRUD (Create, Read, Update, Delete)** operations on an employee entity using **REST APIs**. The application integrates with a relational database using Spring Data JPA and allows API requests to be tested using **Postman**.

## Features
- Add new employees to the system.
- Retrieve all employees or fetch specific employee details by ID.
- Update existing employee details.
- Delete employees from the system.
- Request validation (name, phone and email) using Bean Validation.
- Global exception handling with proper HTTP status codes (201, 204, 400, 404).
- JSON responses for all endpoints.
- CORS configuration so browser-based clients can call the API.

## Tech Stack
- **Programming Language:** Java
- **Framework:** Spring Boot
- **Database:** MYSQL / H2 (or other databases configurable via `application.properties`)
- **Validation:** Spring Boot Starter Validation
- **Tools:** Postman (for testing APIs)
- **Dependency Management:** Maven

## Prerequisites
Before running the application, ensure you have the following installed:
- Java JDK (11 or above)
- Maven (for dependency management)
- IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

## Project Structure
```
├── src/main/java
│   ├── com.springBootProject
│   │   ├── Controller
│   │   │   └── EmpController.java
│   │   ├── Entity
│   │   │   └── EmployeeEntity.java
│   │   ├── Repository
│   │   │   └── EmployeeRepository.java
│   │   ├── Service
│   │   │   ├── EmployeeService.java
│   │   │   └── EmployeeServiceImpl.java
│   │   ├── Exception
│   │   │   ├── EmployeeNotFoundException.java
│   │   │   └── GlobalExceptionHandler.java
│   │   ├── Config
│   │   │   └── CorsConfig.java
│   │   └── Employee.java
│   └── DemoApplication.java
├── src/main/resources
│   ├── application.properties
├── pom.xml
└── README.md
```


## API Endpoints
Here are the available API endpoints:

### 1. Get All Employees
**GET** `/api/employees`
- **Response:** `200 OK`
  ```json
  [
    {
      "id": 1,
      "name": "John Doe",
      "phone": "9876543210",
      "email": "john.doe@example.com"
    }
  ]
  ```

### 2. Get Employee by ID
**GET** `/api/employees/{id}`
- **Path Variable:**
  - `id`: Employee ID
- **Response:** `200 OK`
  ```json
  {
    "id": 1,
    "name": "John Doe",
    "phone": "9876543210",
    "email": "john.doe@example.com"
  }
  ```
- **Error:** `404 Not Found`
  ```json
  {
    "message": "Employee with ID 99 not found"
  }
  ```

### 3. Add a New Employee
**POST** `/api/employees`
- **Request Body:**
  ```json
  {
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "phone": "9123456780"
  }
  ```
- **Response:** `201 Created`
  ```json
  {
    "id": 2,
    "name": "Jane Doe",
    "phone": "9123456780",
    "email": "jane.doe@example.com"
  }
  ```
- **Error:** `400 Bad Request` when validation fails
  ```json
  {
    "email": "Enter a valid email"
  }
  ```

### 4. Update an Employee
**PUT** `/api/employees/{id}`
- **Path Variable:**
  - `id`: Employee ID
- **Request Body:**
  ```json
  {
    "name": "Jane Smith",
    "email": "jane.smith@example.com",
    "phone": "9876543210"
  }
  ```
- **Response:** `200 OK` with the updated employee
  ```json
  {
    "id": 2,
    "name": "Jane Smith",
    "phone": "9876543210",
    "email": "jane.smith@example.com"
  }
  ```
- **Errors:** `400 Bad Request` for invalid data, `404 Not Found` if the ID does not exist

### 5. Delete an Employee
**DELETE** `/api/employees/{id}`
- **Path Variable:**
  - `id`: Employee ID
- **Response:** `204 No Content` (empty body)
- **Error:** `404 Not Found` if the ID does not exist



## Testing the APIs
- Open **Postman** and import the API collection (if provided).
- Alternatively, manually test the endpoints by sending appropriate requests to the `http://localhost:8080` URL.