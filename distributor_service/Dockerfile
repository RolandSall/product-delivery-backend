FROM openjdk:11
VOLUME /tmp
ADD  target/distributor_service.jar distributor_service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/distributor_service.jar"]