FROM openjdk

VOLUME /tmp
ADD maven/ribbon-client.jar ribbon-client.jar
RUN sh -c 'touch /ribbon-client.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/ribbon-client.jar"]