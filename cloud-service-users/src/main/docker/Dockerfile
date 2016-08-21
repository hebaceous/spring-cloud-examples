FROM java:8
VOLUME /tmp
ADD cloud-service-users-0.0.1.jar app.jar
EXPOSE 8001
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]