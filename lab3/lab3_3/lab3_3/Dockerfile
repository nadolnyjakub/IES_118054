# Use the official OpenJDK 17 base image
FROM adoptopenjdk/openjdk17:jre-17.0.0.35_1-openj9

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/lab3_3-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
