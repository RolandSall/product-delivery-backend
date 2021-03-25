FROM openjdk:11
VOLUME /tmp
ADD  target/inventory_service.jar inventory_service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/inventory_service.jar"]