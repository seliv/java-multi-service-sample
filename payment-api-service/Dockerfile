FROM openjdk:17-alpine
COPY target/*.jar /
ENTRYPOINT ["java", "-Dspring.profiles.active=docker-local", "-jar", "/acme-poc-payment-api-service-0.0.1-SNAPSHOT.jar"]
