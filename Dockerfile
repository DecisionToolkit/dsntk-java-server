FROM openjdk:17-slim

COPY ./target/server-0.0.1.jar /

CMD ["java","-jar","server-0.0.1.jar"]