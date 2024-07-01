FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven

WORKDIR /app

COPY . .

RUN mvn clean install

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY --from=build /app/target/car-0.0.1-SNAPSHOT.jar app.jar

ENV DB_USER=${DB_USER}
ENV DB_PASS=${DB_PASS}
ENV DATABASE_URL=${DATABASE_URL}

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]