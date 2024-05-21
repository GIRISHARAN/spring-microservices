FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM openjdk:17

RUN mkdir /deploy

COPY --from=build /app/target/user-service.jar /deploy/user-service.jar

WORKDIR /deploy

EXPOSE 8081

CMD ["java", "-jar", "user-service.jar"]