# Doctor-Patient API

This is a simple Spring Boot application that manages doctors and patients. The API allows for CRUD operations on patients and doctors using a relational database.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [License](#license)

## Prerequisites
- Java 17
- Maven 3.8.1+
- IDE of your choice (IntelliJ, Eclipse, etc.)

## Installation

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/doctorpatientapi.git
    cd doctorpatientapi
    ```

2. **Navigate to the project directory:**
    ```bash
    cd doctorpatientapi
    ```

3. **Build the project:**
    ```bash
    mvn clean install
    ```

## Running the Application

1. **Run the application using Maven:**
    ```bash
    mvn spring-boot:run
    ```

2. **Or, run the application using the generated JAR file:**
    ```bash
    java -jar target/doctorpatientapi-0.0.1-SNAPSHOT.jar
    ```

3. **Access the H2 database console:**
    - Navigate to `http://localhost:8080/h2-console`
    - Use the following credentials:
      - **JDBC URL:** `jdbc:h2:mem:testdb`
      - **Username:** `sa`
      - **Password:** `password`

## API Endpoints

### Patient Endpoints
- **Get all patients:**
  ```http
  GET /patients
