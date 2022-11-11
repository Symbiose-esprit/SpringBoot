FROM openjdk:8
VOLUME /tmp
ADD http://172.10.0.140:8081/repository/achat/com/esprit/examen/tpAchatProject/1.0/tpAchatProject-1.0.jar tpAchatProject-1.0.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]
