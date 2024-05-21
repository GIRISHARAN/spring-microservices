FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM openjdk:17

RUN mkdir /deploy

COPY --from=build /app/target/department-service.jar /deploy/department-service.jar

WORKDIR /deploy

EXPOSE 8080

CMD ["java", "-jar", "department-service.jar"]