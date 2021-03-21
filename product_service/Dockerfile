FROM openjdk:11
VOLUME /tmp
ADD  target/product-service.jar product-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/product-service.jar"]