# Spring Task API

A simple task-management REST API built with Spring Boot.

## Features

- Create tasks
- List all tasks
- Get a task by ID
- Update task completion status
- Delete tasks
- Input validation

## Run

```bash
mvn spring-boot:run
```

The API starts on `http://localhost:8080`.

## Endpoints

- `GET /api/tasks`
- `GET /api/tasks/{id}`
- `POST /api/tasks`
- `PUT /api/tasks/{id}`
- `DELETE /api/tasks/{id}`

Example request:

```json
{
  "title": "Learn Spring Boot",
  "description": "Build a REST API",
  "completed": false
}
```
