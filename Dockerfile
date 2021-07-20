FROM adoptopenjdk/openjdk12:latest
ENV JAVA_OPTS=-Djava.security.egd=file:/dev/./urandom
COPY ./target /cwi
ENTRYPOINT java $JAVA_OPTS -jar /produto/senior-0.0.1-SNAPSHOT.jar
EXPOSE 8080