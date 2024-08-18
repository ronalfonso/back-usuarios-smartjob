# Microservicios de Usuarios con Eureka Server y Spring Cloud Gateway

Este repositorio contiene una implementación de microservicios para gestionar usuarios, utilizando Eureka Server para el registro y descubrimiento de servicios, Spring Cloud Gateway como puerta de enlace, y una base de datos PostgreSQL para almacenar la información de los usuarios.

## Descarga del Repositorio

Para comenzar, clona este repositorio en tu máquina local:

```bash
git clone https://github.com/ronalfonso/back-usuarios-smartjob.git
cd back-usuarios-smartjob
```

## Generación del JAR y Creacion de imagen Docker

A continuación, compila y genera el archivo JAR para cada uno de los microservicios. Asegúrate de tener instalado Java y Maven; luego de crear el package construye la imagen del servicio

### 1. Eureka server
```angular2html
cd servicio-eureka-server
mvn clean package
docker build -t eureka-server:v1 .
```

### 2. Servicio de usuario
```angular2html
cd servicio-usuarios
mvn clean package
docker build -t servicio-usuarios:v1 .
```

### 3. Gateway server
```angular2html
cd servicio-gateway-server
mvn clean package
docker build -t gateway-server:v1 .
```

## Ejecución de Contenedores
Finalmente, ejecuta los contenedores Docker para cada servicio, preferiblemente con al menos 10 seg de diferencias entre servicios, para darle tiempo a los servicios para levantarse sobre todo por la base de datos:

## 1. Base de datos
```angular2html
docker-compose up -d db
```

## 2. Eureka server
```angular2html
docker-compose up -d eureka-server
```

## 3. Servicio de usuarios
```angular2html
docker-compose up -d servicio-usuarios
```

## 4. Gateway server
```angular2html
docker-compose up -d gateway-server
```

¡Listo! Ahora tus microservicios están en funcionamiento. Puedes acceder a Eureka Server en http://localhost:8761 y al gateway en http://localhost:8090.

## Uso de Endpoint's
A continuacion en la carpeta docker-compose encontrara una archivo Smart-job.postman_collection.json; exportando este archivo en postman podra tener los endpoint's creados con ejemplos ya listos para usarse

## Contacto
Si tienes alguna pregunta, sugerencia o comentario, no dudes en ponerte en contacto conmigo:

- **Nombre:** Ronald Alfonso
- **Teléfono:** +58-0424-626.67.32
- **Linkedin:** https://www.linkedin.com/in/ronald-alfonso/
- **Correo electrónico:** raalfonsoparra@gmail.com
- **Enlace al proyecto:** https://github.com/ronalfonso/back-usuarios-smartjob

![Alt text](https://avatars.githubusercontent.com/u/41694372?v=4)
