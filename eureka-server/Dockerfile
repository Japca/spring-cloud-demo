FROM openjdk:8-jdk-alpine

VOLUME /tmp
ADD maven/eureka-server.jar eureka-server.jar
RUN sh -c 'touch /eureka-server.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-server.jar"]