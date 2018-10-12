# Start with a slender Alpine Linus base image with OpenJDK JRE
FROM openjdk:8-jre-alpine

# Add a bash interpreter in case we want to interactively login to the container
RUN apk add --no-cache bash

# Update the images' libraries with any latest security patches, etc.
# Note that this adds build time that you may not want on a slow Pi
#RUN apk update
#RUN apk upgrade

# Add Maintainer Info
LABEL maintainer="Scott McCrory <scott@mccrory.us>"

# Add our application's jar to the container
ADD target/pi4jdemo-0.0.1-SNAPSHOT.jar app.jar

# Make port 8001 (debug) available to the world outside this container
EXPOSE 8001
# EXPOSE 9080 as well, if you end up adding Tomcat

# Run the jar file and enable remote debugging (not approprite for Production)
ENTRYPOINT ["java","-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,address=8001,suspend=n", "-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=9080", "-jar","/app.jar"]
