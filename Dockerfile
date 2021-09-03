FROM adoptopenjdk/openjdk12:latest
ENV JAVA_OPTS=-Djava.security.egd=file:/dev/./urandom
COPY ./target /micro_service
ENTRYPOINT java $JAVA_OPTS -jar /micro_service/micro-0.0.1-SNAPSHOT.jar
EXPOSE 8080