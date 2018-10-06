# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="Scott McCrory <scott@mccrory.us>"

# The application's jar file
ARG JAR_FILE=target/pi4jdemo-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Update the images' libraries with any latest security patches, etc.
# Note that this adds build time that you may not want on a slow Pi
#RUN apk update
#RUN apk upgrade

# Make ports 9080 (app) and 8001 (debug) available to the world outside this container
EXPOSE 8001
EXPOSE 9080

# Run the jar file and enable remote debugging (not approprite for PRODuction!)
ENTRYPOINT ["java","-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,address=8001,suspend=n", "-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=9080", "-jar","/app.jar"]
