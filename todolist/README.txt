# To-Do List API

## Overview

This project is a simple To-Do List API built in IntelliJ using Spring Boot and PostgreSQL. It provides endpoints for creating, reading, updating, and deleting to-do tasks.

## Features

- Add a new task
- Get a list of all tasks
- Update a task
- Delete a task

## Technologies Used

- Java
- Spring Boot
- PostgreSQL
- Maven
- IntelliJ

## Pre-requisites

- Java 17 or above
- PostgreSQL database running on `localhost:5432`
- Maven (for building the project)

## Setup

1. Make sure your PostgreSQL database is running and accessible.

2. Update `application.properties` to match your database configuration:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
    spring.datasource.username=
    spring.datasource.password=
    ```

## Running the Application

Using the JAR File

1. Using cmd or bash, navigate to the directory where your `todolist-0.0.1-SNAPSHOT.jar` is located.

2. Run the following command:

    java -jar todolist-0.0.1-SNAPSHOT.jar

Your Spring Boot application should start, and it will be accessible at `http://localhost:8080/api/v1/todolist`.

## API Usage

Once the application is running, you can use the following endpoints:

- **Add a new task**: POST request to `http://localhost:8080/api/v1/todolist`
- **Get all tasks**: GET request to `http://localhost:8080/api/v1/todolist`
- **Update a task**: PUT request to `http://localhost:8080/api/v1/todolist/{taskId}`
- **Delete a task**: DELETE request to `http://localhost:8080/api/v1/todolist/{taskId}`

I recommend either using a more user-firendly way to interact with the API like Postman, however, here's how you can run it using cmd:

Create (POST): curl -X POST -H "Content-Type: application/json" -d "{\"task\":\"do this\", \"completed\":false}" http://localhost:8080/api/v1/todolist
Read (GET): curl http://localhost:8080/api/v1/todolist
Update (PUT): curl -X PUT -H "Content-Type: application/json" -d "{\"task\":\"do the laundry\", \"completed\":true}" http://localhost:8080/api/v1/todolist/1
Delete (DELETE): curl -X DELETE http://localhost:8080/api/v1/todolist/1

---

That should cover everything you need to know to set up and run the application!