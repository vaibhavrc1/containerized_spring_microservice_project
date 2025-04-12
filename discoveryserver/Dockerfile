FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/discoveryserver-0.0.1-SNAPSHOT.jar discovery-server.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "discovery-server.jar"]