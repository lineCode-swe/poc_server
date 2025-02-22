FROM openjdk:13-jdk-alpine

COPY target/jersey-grizzly-reference-*-jar-with-dependencies.jar /start.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/start.jar"]

# Run in shell with:
# docker run --rm --network host <image_name>