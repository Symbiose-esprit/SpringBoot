FROM openjdk:8
EXPOSE 80

ADD http://192.168.1.17:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]