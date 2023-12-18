# Use the Java Temurin 21 image as the base image
FROM eclipse-temurin:21

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/shoppinglist-0.0.1-SNAPSHOT.jar app.jar

# Download and add the OpenTelemetry Java agent
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .

# Expose the port your Spring Boot application is listening on
# Example for Port Binding
EXPOSE 8081

# Example for dynamic configuration - I like it!
ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"

# Command to run the Spring Boot application with OpenTelemetry
CMD ["java", "-jar", "app.jar"]
