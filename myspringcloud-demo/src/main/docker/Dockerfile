FROM java:8
VOLUME /tmp
ADD myspringcloud-mall-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar"
EXPOSE 8771
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]