FROM openjdk:8-jdk-alpine

VOLUME /tmp
ADD maven/receiver-service.jar receiver-service.jar
RUN sh -c 'touch /eureka.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/receiver-service.jar"]