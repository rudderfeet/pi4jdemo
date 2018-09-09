# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Start with a reasonably modest linux+java8+maven image
#FROM maven:3.5.4-jdk-8-alpine

# Add Maintainer Info
MAINTAINER Scott McCrory <scott@mccrory.us>

# Add the application's jar to the container
ADD target/pi4jdemo-0.0.1-SNAPSHOT.jar app.jar

# Update the images' libraries with any latest security patches, etc.
#RUN apk update
#RUN apk upgrade

# Make ports 8001 and 9080 available to the world outside this container
EXPOSE 8001
EXPOSE 9080

# Execute "mvn spring-boot:run" to properly start up our Spring Boot app.
#   Note that this helps to overcome a limitations with Thymeleaf directories.
#   A Tomcat container running on port 8080 will be automatically started
#CMD ["mvn", "spring-boot:run"]

# Run the jar file and enable remote debugging (not approprite for PRODuction!)
ENTRYPOINT ["java","-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,address=8001,suspend=n", "-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=9080", "-jar","/app.jar"]
