# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="scott@mccrory.us"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9080 available to the world outside this container
EXPOSE 9080

# Add the application's jar to the container
ADD target/pi4jdemo-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=9080", "-jar","/app.jar"]
