FROM openjdk:17
COPY target/Core.jar api/up.jar
WORKDIR api
ENTRYPOINT ["java","-jar","up.jar"]
