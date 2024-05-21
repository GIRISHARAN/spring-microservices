FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM openjdk:17

RUN mkdir /deploy

COPY --from=build /app/target/netflix-eureka-service-registry.jar /deploy/netflix-eureka-service-registry.jar

WORKDIR /deploy

EXPOSE 8761

CMD ["java", "-jar", "netflix-eureka-service-registry.jar"]