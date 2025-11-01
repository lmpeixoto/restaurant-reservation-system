# the base image
FROM amazoncorretto:25

WORKDIR /app

# the JAR file path
ARG JAR_FILE=target/*.jar

# Copy the JAR file from the build context into the Docker image
COPY ${JAR_FILE} app.jar

RUN addgroup app && adduser --system --ingroup app app
USER app

EXPOSE 8080

# Set the default command to run the Java application
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "app.jar"]