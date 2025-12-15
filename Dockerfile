FROM eclipse-temurin:21-alpine

COPY ./target/server-0.0.2.jar /

CMD ["java","-jar","server-0.0.2.jar"]
