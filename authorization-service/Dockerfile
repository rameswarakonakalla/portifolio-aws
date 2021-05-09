FROM openjdk:8-jdk-alpine
COPY ./target/authorization-service-0.0.1-SNAPSHOT.jar auth.jar
EXPOSE 9095
ENTRYPOINT ["java","-jar","/auth.jar"]