# pi4jdemo

A simple Pi4J demonstrator using Spring Boot and Docker.

## Getting Started

This project is for Java developers who'd like to stretch out a bit and play
with "physical computing" using an inexpensive Raspberry Pi with much of the same
tools they already know.  It's additionally a way to build practice with Spring Boot and
app containerization using Docker, again building upon a stable knowledge platform
a step at a time.

Because the Pi isn't terribly fast or have a lot of memory, we stick with just a console
application at first.  However, you can work up to creating whole Spring Boot Web
applications with an embedded Tomcat server, Actuator, Thymeleaf and much more later on,
though you may need to dispense of Docker to make more memory available.

### Prerequisites

You'll want a Raspberry Pi with GPIO and SSH enabled, some circuitry to play with, loaded
with Java 8, Maven, Docker and probably also Jenkins and Portainer. An Internet connection
is pretty much mandatory to install those packages and the first time you launch your app
to allow Maven to fetch its dependencies into the Pi's local Maven repo.

### Installing

TODO...

## Running the tests

There aren't many unit tests to depend on, just a check of Spring's context loader. If/as
you build upon this for your own purposes, you'll likely need to be mindful of what can't
be run on your development PC because it lacks the Pi's GPIO, camera and any cool electronics
you end up wirings to the thing.

## Deployment

This is a typical Maven Spring Boot project at heart, so that means you can:

* Build the app and run unit tests with "mvn clean package".
* Run the application with "mvn spring-boot:run"

We've also mixed in Spotify's Docker Maven plugin, so you can even:

* Create the Docker image with "mvn dockerfile:build -DskipTests=true"

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot] (http://spring.io/projects/spring-boot) - IoC Framework
* [Docker] (https://www.docker.com/) - Container manager

## Contributing

Feel free to email scott@mccrory.us with any corrections, bugs or to make improvements!

## Versioning

I use GitHub for version control, located at https://github.com/rudderfeet/pi4jdemo.

## Authors

* **Scott McCrory** - *Initial work* - scott@mccrory.us

## License

This project is licensed under the Apache License Version 2.0, January 2004.
Please see LICENSE for details - basically, enjoy and extend without many limits.

## Acknowledgments

Sincere thanks to all the incredible engineers and hobbyists who've been pushing the envelope
to create freely available, quality software throughout the decades.  Without their work on
Linux and it's huge ecosystem of enabling software, and that of Java, Maven and Spring, and
of course the Raspberry Pi itself...!... such a lowly developer like me would have a much less
enjoyable world to play in.
