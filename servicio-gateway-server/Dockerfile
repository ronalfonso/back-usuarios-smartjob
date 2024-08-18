FROM openjdk:12
LABEL authors="raalfonso"

VOLUME /tmp

EXPOSE 8090

ARG JAR_FILE=./target/servicio-gateway-server-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} gateway-server.jar

ENTRYPOINT ["java", "-jar", "/gateway-server.jar"]