FROM openjdk:11
EXPOSE 80

ADD http://192.168.56.4:8081/repository/maven-releases/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","tpAchatProject.jar"]