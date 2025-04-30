# Use a stable JDK base image
FROM eclipse-temurin:17-jdk-jammy

# Create app directory
WORKDIR /app

# Copy Maven wrapper and make it executable
COPY . .
COPY mvnw mvnw
COPY .mvn .mvn
RUN chmod +x mvnw

# Copy Maven files and build app
COPY pom.xml pom.xml
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw clean package -DskipTests

# Run the app
CMD ["java", "-jar", "target/*.jar"]
