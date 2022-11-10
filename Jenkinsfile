pipeline {
    agent any
    tools { 
      maven 'M2_HOME' 
      jdk 'JAVA_HOME' 
    }
    stages {
         stage('Clone repo GIT') {
            steps {
                git branch: 'oussema',
                url : 'https://github.com/Symbiose-esprit/SpringBoot.git';
            }
        }
        stage('Test mvn') {
            steps {
            	sh """ mvn install """;
                sh """ mvn clean """;
                sh """ mvn test """;
            }
        }
        stage('Mvn SonarQube') {
            steps {
                jacoco(execPattern: 'target/jacoco.exec')
            	sh """ mvn sonar:sonar -Dsonar.projectKey=springboot-devops -Dsonar.host.url=http://192.168.56.2:9000 -Dsonar.login="c37a407abfaa2556e895aff32c4538cf9ed75c91" """;
            }
        }
        stage('Nexus') {    
            steps {  
		script {          
		sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.56.2:8081/repository/nexusrepo/ -Dfile=target/tpAchatProject-1.0.jar'
		}
               
            }
        }
    }

    post {
        always {  
             echo 'This will always run'  
         }    
    }
}