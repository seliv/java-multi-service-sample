FROM public.ecr.aws/amazoncorretto/amazoncorretto:17
COPY target/*.jar /
ENTRYPOINT ["java", "-Dspring.profiles.active=docker-local", "-jar", "/acme-poc-payment-api-service-0.0.1-SNAPSHOT.jar"]
