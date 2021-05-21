FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/flight-finder-rest-api.jar flight-finder-rest-api.jar
ENTRYPOINT ["sh", "-c", "java -jar /flight-finder-rest-api.jar"]