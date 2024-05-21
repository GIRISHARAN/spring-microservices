FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM openjdk:17

RUN mkdir /deploy

COPY --from=build /app/target/cloud-api-gateway.jar /deploy/cloud-api-gateway.jar

WORKDIR /deploy

EXPOSE 8082

CMD ["java", "-jar", "cloud-api-gateway.jar"]