FROM openjdk:11
EXPOSE 80

ADD /target/tpAchatProject-1.0-SNAPSHOT.jar tpAchatProject.jar

ENTRYPOINT ["java","-jar","tpAchatProject.jar"]