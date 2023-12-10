# ShoppingList Application Documentation

## Overview

This GitHub project is a ShoppingList application with a React front end, Spring Boot back end, and PostgreSQL database. 
It incorporates OpenTelemetry and Jaeger for observability, allowing users to manage shopping lists through a RESTful API 
while providing insights into application performance.

## Requirements

  1. Install java 17
  2. Create a Jar File from the Backend using **mvn clean install -DskipTests**
  3. Update the **baseUrl** in **App.js** to your Backend URL.
     Example: **https://8081-thinh901-verteilesystem-j3n57xnahgr.ws-eu106.gitpod.io*
  5. Ensure the Backend Port is exposed to **public** (If working with gitpod).

## Endpoints

- **GET /shopping**: Get all shopping items
- **POST /shopping**: Create a new shopping item
- **DELETE /shopping/{id}**: Delete a shopping item by ID
- **DELETE /shopping**: Delete all shopping items
- **PUT /shopping/{id}**: Update a shopping item by ID

### Application Configuration

- Backend running on port: `8081`
- Frontend running on port: `3000`
- PostgreSQL database running on port: `5432`
- JaegerUI running on port: `16686`

### Swagger UI

- Access Swagger UI at: Your Backend *BaseUrl* 
  - Swagger JSON endpoint: `/swagger-ui/index.html`
  - Example: **https://8081-thinh901-verteilesystem-j3n57xnahgr.ws-eu106.gitpod.io/swagger-ui/index.html**

### Docker

#### Start the Application

  - **docker-compose up**

#### Stop the Application

  - **docker-compose down**




 


