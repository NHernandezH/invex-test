
FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/employees-0.0.1-SNAPSHOT.jar employees-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "employees-0.0.1-SNAPSHOT.jar"]