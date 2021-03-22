FROM openjdk:11
VOLUME /tmp
ADD  target/gateway_service.jar gateway_service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/gateway_service.jar"]