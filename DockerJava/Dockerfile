FROM alpine:latest
RUN apk --update add openjdk11-jre
WORKDIR /usr
COPY ./image-files/docker-java.jar ./lib/apps.jar
COPY ./image-files/README.md .
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-cp", "lib/apps.jar"]
CMD ["demo.HelloArgs", "Beautiful", "World"]