FROM openjdk:20
ARG JAR_FILE=target/*.jar
ADD ./target/biblioteca-0.0.1-SNAPSHOT.jar biblioteca.jar
ENTRYPOINT ["java","-jar","/biblioteca.jar"]