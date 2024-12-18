# Employee CRUD System Using Spring Boot and REST APIs

## Description
This project is a basic **Employee CRUD System** built using **Spring Boot**. It demonstrates the implementation of **CRUD (Create, Read, Update, Delete)** operations on an employee entity using **REST APIs**. The application integrates with a relational database using Spring Data JPA and allows API requests to be tested using **Postman**.

## Features
- Add new employees to the system.
- Retrieve all employees or fetch specific employee details by ID.
- Update existing employee details.
- Delete employees from the system.
- Error handling for invalid requests.

## Tech Stack
- **Programming Language:** Java
- **Framework:** Spring Boot
- **Database:** H2 (or other databases configurable via `application.properties`)
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
│   │   └── Employee.java
│   └── DemoApplication.java
├── src/main/resources
│   ├── application.properties
│   └── data.sql (optional for seeding data)
├── pom.xml
└── README.md
```


## API Endpoints
Here are the available API endpoints:

### 1. Get All Employees
**GET** `/employees`
- **Response:**
  ```json
  [
    {
      "id": 1,
      "name": "John Doe",
      "email": "john.doe@example.com"
    }
  ]
  ```

### 2. Get Employee by ID
**GET** `/employees/{id}`
- **Path Variable:**
  - `id`: Employee ID
- **Response:**
  ```json
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com"
  }
  ```

### 3. Add a New Employee
**POST** `/employees`
- **Request Body:**
  ```json
  {
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "phone": "1234567890"
  }
  ```
- **Response:**
  ```json
  "Saved Successfully"
  ```

### 4. Update an Employee
**PUT** `/employees/{id}`
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
- **Response:**
  ```json
  "Updated"
  ```

### 5. Delete an Employee
**DELETE** `/employees/{id}`
- **Path Variable:**
  - `id`: Employee ID
- **Response:**
  ```json
  "Deleted Successfully"
  ```



## Testing the APIs
- Open **Postman** and import the API collection (if provided).
- Alternatively, manually test the endpoints by sending appropriate requests to the `http://localhost:8080` URL.

## Future Enhancements
- Add validation for request payloads using Hibernate Validator.
- Introduce Swagger for API documentation.
- Use a front-end framework like Angular or React for a user interface.
- Add authentication and authorization using Spring Security.

