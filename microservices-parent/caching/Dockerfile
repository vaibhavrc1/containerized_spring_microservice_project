FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/caching-0.0.1-SNAPSHOT.jar caching-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "caching-service.jar"]