FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} goods-microservice.jar
ENTRYPOINT ["java", "-jar", "goods-microservice.jar"]