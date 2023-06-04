FROM openjdk:17-alpine

WORKDIR /app
COPY . /app
#RUN ./mvnw package -DskipTests

COPY out/artifacts/WebApplication_jar2 /app

ENTRYPOINT ["java","-jar","/app/WebApplication.jar"]