FROM openjdk:11
VOLUME /tmp
ADD  target/register_service.jar register_service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/register_service.jar"]