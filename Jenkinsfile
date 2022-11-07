pipeline {
    agent any
    tools { 
      maven 'M2_HOME' 
      jdk 'JAVA_HOME' 
    }
    stages {
         stage('Clone repo GIT') {
            steps {
                git branch: 'mahdi',
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
        stage('Nexus') {    
            steps {  
		        script {          
		            sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.17:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar'
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