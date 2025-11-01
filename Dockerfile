# ---------- Stage 1: Build ----------
FROM maven:3.9.11-amazoncorretto-25 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn clean package -DskipTests

# ---------- Stage 2: Runtime ----------
FROM amazoncorretto:21

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

RUN addgroup app && adduser --system --ingroup app app
USER app

EXPOSE 8080

ENTRYPOINT ["java", "-Xmx2048M", "-jar", "app.jar"]