#FROM ubuntu:latest
#LABEL authors="DELL USER"
#
#ENTRYPOINT ["top", "-b"]

# Stage 1: Build the application
FROM maven:3.8.7 AS build
WORKDIR /app
COPY rmis/pom.xml .
# Download dependencies first, useful for caching
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage
FROM openjdk:21
WORKDIR /app
# Copy the executable JAR from the build stage
COPY --from=build /app/target/*.jar rmis.jar

# Set environment variables

ENV PORT=${PORT}

# Expose the port
EXPOSE ${PORT}

# Entry point to run the application
ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}","rmis.jar"]