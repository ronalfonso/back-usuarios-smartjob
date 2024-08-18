FROM openjdk:12
LABEL authors="raalfonso"

VOLUME /tmp

ARG JAR_FILE=./target/servicio-usuarios-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} servicio-usuarios.jar

ENTRYPOINT ["java", "-jar", "/servicio-usuarios.jar"]