FROM openjdk:12
LABEL authors="raalfonso"

VOLUME /tmp

EXPOSE 8761

ARG JAR_FILE=./target/servicio-eureka-server-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} eureka-server.jar

ENTRYPOINT ["java", "-jar", "/eureka-server.jar"]