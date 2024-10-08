FROM openjdk:17-jdk-alpine

COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar

# Expose the front-end & backend ports
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]