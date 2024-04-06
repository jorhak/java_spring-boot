# Proyecto de SpringBoot
Recreamos el proyecto de Lucas Moy al que sigo
en YouTube
## Requerimintos
- Java
```
$ java -version
java version "17.0.8" 2023-07-18 LTS
Java(TM) SE Runtime Environment (build 17.0.8+9-LTS-211)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.8+9-LTS-211, mixed mode, sharing)
```
- Maven
```
$ mvn -v
Apache Maven 3.9.4 (dfbb324ad4a7c8fb0bf182e6d91b0ae20e3d2dd9)
Maven home: /opt/maven
Java version: 17.0.8, vendor: Oracle Corporation, runtime: /usr/lib/jvm/jdk-17.0.8
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "6.8.0-76060800daily20240311-generic", arch: "amd64", family: "unix"
```
- IntelliJ Idea (Version Community)
```
IntelliJ IDEA 2023.2.2 (Community Edition)
Build #IC-232.9921.47, built on September 12, 2023
Runtime version: 17.0.8+7-b1000.22 amd64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
```
- Docker
```
$ docker -v
Docker version 26.0.0, build 2ae903e

$ docker compose version
Docker Compose version v2.25.0
```
## Ejecutar
Abrimos IntelliJ Idea, luego buscamos el proyecto en la ruta donde se a descargado.


En la parte derecha damos click sobre M curso, vamos a tener tres opciones
1. Lifecycle
2. Plugins
3. Dependencies

Damos click sobre Plugins para que se nos desplieguen las opciones, damos click
sobre spring-boot, luego sobre spring-boot:run

Aqui vamos a tener un error dado que no hemos levantado el servicio de la base de datos
MySQL, copiamos el docker-compose.yml de la rama base-spring, luego la ejecutamos
```
$ docker compose up -d
```

Debemos tener en cuenta que nuestra aplicacion web se esta ejecutando en localhost:9090 o tu IP:9090 y
la base de datos en localhost:3306 o tu IP:3306

## Modificar el archivo application.properties
* Modifica IP por tu IP
* Modifica db_name por el nombre de tu base de datos
* Modifica db_password por tu password de tu base de datos

Estos cambios deben ser los mismos que se deben tener en el
archivo docker-compose.yml
```
spring.datasource.url=jdbc:mysql://IP:3306/db_name
spring.datasource.dbname=db_name
spring.datasource.username=root
spring.datasource.password=db_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Ahora si damos click sobre spring-boot:run