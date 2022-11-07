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
    }

    post {
        always {  
             echo 'This will always run'  
         }    
    }
}