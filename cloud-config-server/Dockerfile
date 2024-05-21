FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM openjdk:17

RUN mkdir /deploy

COPY --from=build /app/target/cloud-config-server.jar /deploy/cloud-config-server.jar

WORKDIR /deploy

EXPOSE 8083

CMD ["java", "-jar", "cloud-config-server.jar"]