FROM eclipse-temurin:21-alpine

COPY ./target/server-1.0.1.jar /

CMD ["java","-jar","server-1.0.1.jar"]
