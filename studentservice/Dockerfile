FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/studentservice-0.0.1-SNAPSHOT.jar student-service.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "student-service.jar"]