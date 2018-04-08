FROM openjdk:8-jdk-alpine

VOLUME /tmp
ADD maven/feign-client.jar feign-client.jar
RUN sh -c 'touch /feign-client.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/feign-client.jar"]