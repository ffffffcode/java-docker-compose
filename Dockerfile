FROM openjdk:8-jre-slim
COPY target/java-docker-compose-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]