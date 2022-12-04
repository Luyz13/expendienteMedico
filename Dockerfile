FROM amazoncorretto:17
ADD target/expedienteMedico.jar expedienteMedico.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "expedienteMedico.jar"]
