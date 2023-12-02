Spring Boot Backend
Create a Spring Boot application with the following endpoints:

GET /shopping: Get all shopping items
POST /shopping: Create a new shopping item
DELETE /shopping/{id}: Delete a shopping item by ID
DELETE /shopping: Delete all shopping items
PUT /shopping/{id}: Update a shopping item by ID
Sample Controller code:

java
Copy code
// Insert your existing ShoppingController code here
Dockerize the Spring Boot application with the provided Dockerfile.

React Frontend
Create a React application with components to interact with the Spring Boot backend.

Configure the React app to make API requests to http://localhost:8081 (Spring Boot backend).

Dockerize the React application with the provided Dockerfile.

Running the Environment
Open a terminal and navigate to the directory containing the docker-compose.yml file.

Run the following command to start the services:

bash
Copy code
docker-compose up -d
Access the Spring Boot backend at http://localhost:8081.

Access the React frontend at http://localhost:3000.

The PostgreSQL database is available on port 5432.

Stopping the Environment
To stop the services, run:

bash
Copy code
docker-compose down
This concludes the Docker Compose setup for Spring Boot, React, and PostgreSQL.

css
Copy code

Please make sure to replace the placeholder comments in the Spring Boot section 
