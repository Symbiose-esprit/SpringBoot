FROM openjdk:11
EXPOSE 80
ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} tpAchatProject.jar
ENTRYPOINT ["java","-jar","tpAchatProject.jar"]