FROM eclipse-temurin:17-jdk-alpine as build

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle gradle
COPY src src

RUN ./gradlew build --no-daemon -x test

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]