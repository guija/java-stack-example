Java Stack Example
===

This is an example application integration multiple commonly used java technologies to have a base skeleton for rapid and proper application development.

TODO
---

- REST APIs with versioning and either auto generating swagger / OpenAPI
- Syntax checking
- CloudFormation script for deploying to AWS

Used frameworks
---

- spring boot
- spring
- liquibase
- hibernate
- lombock
- docker
- docker-compose

Configuration files
---

Dependencies, and configuration files

    pom.xml

Database connection for spring boot application

    src/resources/application.properties

Database connection for manual maven liquibase commands

    src/resources/liquibase.properties

Folder for database migrations (using liquibase)

    src/resources/db/changelog

Build
---

Compiling

    mvn compile

Build docker image

    mvn install dockerfile:build

Build docker image without tests

    mvn install dockerfile:build -DskipTests

Run
---

Run mysql and application with docker-compose

    docker-compose up

Start only the database if you want to analyse the content

    docker-compose up db

Testing
---

Running unit and integration tests

    mvn test

Add example user (Using [httpie](https://httpie.org/))

    http POST :8080/user/add name==Johann email==johannwolfgang@goethe.de lastName==Goethe address==Weimar

Get all users (Using [httpie](https://httpie.org/))

    http :8080/user/all


Liquibase for database migrations
---

Generate a database from the database that is configured in `src/resource/liquibase.properties`.

    mvn liquibase:generateChangeLog