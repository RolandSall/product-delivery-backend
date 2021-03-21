FROM openjdk:11
VOLUME /tmp
ADD  target/company_service.jar company_service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/company_service.jar"]