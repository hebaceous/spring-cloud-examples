FROM java:8
VOLUME /tmp
ADD cloud-admin-0.0.1.jar app.jar
EXPOSE 7777
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]