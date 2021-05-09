FROM openjdk:8-jdk-alpine
COPY /target/daily-sharePrice-0.0.1-SNAPSHOT.jar sharePrice.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/sharePrice.jar"]