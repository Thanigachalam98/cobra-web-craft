# Start from OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy project files
COPY . .

# Grant permission to mvnw
RUN chmod +x mvnw

# Package the Spring Boot app
RUN ./mvnw clean package -DskipTests

# Expose default port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/*.jar"]
