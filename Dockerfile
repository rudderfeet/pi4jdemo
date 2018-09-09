# Start with a reasonably modest linux+java+maven image
FROM maven:3.5.4-jdk-8-alpine

# Add Maintainer Info
MAINTAINER Scott McCrory <scott@mccrory.us>

# Copy our whole project into a working directory
COPY . /usr/src/app
WORKDIR /usr/src/app

# Update the images' libraries with any latest security patches, etc.
#RUN apk update
#RUN apk upgrade

# Make ports 8001 and 9080 available to the world outside this container
EXPOSE 8001
EXPOSE 9080

# Execute "mvn spring-boot:run" to properly start up our Spring Boot app.
#   Note that this helps to overcome a limitations with Thymeleaf directories.
#   A Tomcat container running on port 8080 will be automatically started
CMD ["mvn", "spring-boot:run"]
