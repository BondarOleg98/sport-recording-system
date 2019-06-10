FROM openjdk:8-jdk-alpine
COPY ./target/server-0.0.1-SNAPSHOT.jar /usr/src/server/
WORKDIR /usr/src/server
EXPOSE 8762
CMD sleep 5 && java -jar server-0.0.1-SNAPSHOT.jar