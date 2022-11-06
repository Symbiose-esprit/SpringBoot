node {

    def WORKSPACE = "/var/lib/jenkins/workspace/springboot-devops"
    def dockerImageTag = "springboot-devops${env.BUILD_NUMBER}"

    try{
        tools {
          maven 'MAVEN_HOME'
          jdk 'JAVA_HOME'
        }
        stage('Clone repo GIT') {
            steps {
                git branch: 'mahdi',
                url : 'https://github.com/Symbiose-esprit/SpringBoot.git';
            }
        }
        stage('Build Docker'){
            dockerImage = docker.build("springboot-devops:${env.BUILD_NUMBER}")
        }
        stage('Deploy Docker'){
            echo "Docker Image Tag Name: ${dockerImageTag}"
            sh "docker stop springboot-devops || true && docker rm springboot-devops || true"
            sh "docker run --name springboot-devops -d -p 8081:8080 springboot-devops:${env.BUILD_NUMBER}"
        }
    }catch(e){
        throw e
    }
}


/*
pipeline {
    agent any
    tools {
      maven 'MAVEN_HOME'
      jdk 'JAVA_HOME'
    }
    stages {
	
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ...' ;
                 git branch: 'mahdi',
                 url : 'https://github.com/Symbiose-esprit/SpringBoot.git';           
            }
        }
		
        stage('Test mvn') {
            steps {
            	sh """ mvn install """
                sh """ mvn clean """;
                sh """ mvn test """;
            }
        }
        stage('Mvn SonarQube') {
            steps {
		jacoco(execPattern: 'target/jacoco.exec')
            	sh """ mvn sonar:sonar -Dsonar.login=7bd0ae6e97798de973a631cca7fd9b4643f8b8ec"""    
            }
        }
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}
*/