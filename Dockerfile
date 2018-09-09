# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="Scott McCrory <scott@mccrory.us>"

# Make ports 8001 and 9080 available to the world outside this container
EXPOSE 8001 9080

# Add the application's jar to the container
ADD target/pi4jdemo-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file and enable remote debugging (not approprite for PRODuction!)
ENTRYPOINT ["java","-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,address=8001,suspend=n", "-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=9080", "-jar","/app.jar"]
