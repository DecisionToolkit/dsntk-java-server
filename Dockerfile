FROM eclipse-temurin:25-jdk-alpine-3.23

COPY ./target/server-1.0.3.jar /

CMD ["java","-jar","server-1.0.3.jar"]
