# Use an official Maven image as a base image
FROM maven:3.8.4-openjdk-11

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the shaded JAR into the container at /usr/src/app
COPY target/MyWeatherRadar-1.0-SNAPSHOT.jar .

# Specify the command to run your application
CMD ["java", "--enable-preview", "-jar", "MyWeatherRadar-1.0-SNAPSHOT.jar"]

