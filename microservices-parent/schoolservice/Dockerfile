FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/schoolservive-0.0.1-SNAPSHOT.jar schoolservice.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "schoolservice.jar"]