FROM openjdk:11.0.13-oracle
MAINTAINER ridiculands
COPY build/libs/ridiculands-java-0.0.1-SNAPSHOT.jar ridiculands.jar
EXPOSE 80 443 8080
ENTRYPOINT ["java","-jar","/ridiculands.jar"]
