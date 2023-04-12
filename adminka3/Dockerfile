FROM openjdk:17-alpine

WORKDIR /app
COPY . /app
RUN ./mvnw package -DskipTests

COPY out/artifacts/adminka3_jar /app

ENTRYPOINT ["java","-jar","/app/adminka3.jar"]