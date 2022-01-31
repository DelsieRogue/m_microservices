#!/bin/sh

mvn -f auth-microservice/pom.xml clean install;
mvn -f admin-microservice/pom.xml clean install;
mvn -f goods-microservice/pom.xml clean install;

cp admin-microservice/target/*.jar admin-microservice/src/docker/admin.jar;
cp auth-microservice/target/*.jar auth-microservice/src/docker/auth.jar;
cp goods-microservice/target/*.jar goods-microservice/src/docker/goods.jar;

docker-compose build;

docker-compose up;