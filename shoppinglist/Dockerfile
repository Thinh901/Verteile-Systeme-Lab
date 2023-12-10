# Use the Java Temurin 21 image as the base image
FROM eclipse-temurin:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/shoppinglist-0.0.1-SNAPSHOT.jar app.jar

# Download and add the OpenTelemetry Java agent
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .

# Expose the port your Spring Boot application is listening on
EXPOSE 8081

# Command to run the Spring Boot application with OpenTelemetry
ENTRYPOINT ["java", "-jar", "-javaagent:./opentelemetry-javaagent.jar", "app.jar"]
