FROM openjdk:11
VOLUME /tmp
ADD  target/product_service.jar product_service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/product_service.jar"]