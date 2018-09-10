# Start with a base image containing Java runtime
FROM hypriot/rpi-java

# Add Maintainer Info
MAINTAINER Scott McCrory <scott@mccrory.us>

# Add the application's jar to the container
ADD target/pi4jdemo-0.0.1-SNAPSHOT.jar app.jar

# Update the images' libraries with any latest security patches, etc.
RUN apk update
RUN apk upgrade

# Make ports 8001 and 9080 available to the world outside this container
EXPOSE 8001
EXPOSE 9080

# Run the jar file and enable remote debugging (not approprite for PRODuction!)
ENTRYPOINT ["java","-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,address=8001,suspend=n", "-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=9080", "-jar","/app.jar"]
