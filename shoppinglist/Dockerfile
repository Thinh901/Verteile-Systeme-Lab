# Use the Java Temurin 21 image as the base image
FROM eclipse-temurin:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application is listening on
EXPOSE 8080
EXPOSE 8081
EXPOSE 5432

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]