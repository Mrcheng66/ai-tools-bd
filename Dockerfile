# Stage 1: Build stage
FROM maven:3.8.4-openjdk-17-slim AS build

# Set working springbootsecurity
WORKDIR /ai-tools

# Copy application source code
COPY src ./src
COPY pom.xml .

# Build the project and create the executable JAR
RUN mvn clean install -DskipTests

# Expose port 8080
EXPOSE 8080

# Set the entrypoint command for running the application
ENTRYPOINT ["java", "-jar", "ai-tools-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=pre"]
