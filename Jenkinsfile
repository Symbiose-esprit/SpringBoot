pipeline {
    agent any
    tools { 
      maven 'MAVEN_HOME'
      jdk 'JAVA_HOME' 
    }
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ....' ;
                 git branch: 'master',
                 url : 'https://github.com/Symbiose-esprit/SpringBoot.git';           
            }
        }
        stage('Test mvn') {
            steps {
            	sh """ mvn -DskipTests clean package """ 
                sh """ mvn install """;
                sh """ mvn test """;
            }
        }
        stage('Mvn SonarQube') {
            steps {
            	sh """ mvn sonar:sonar -Dsonar.login=a263237445b78211e8c03ce2e369839ea990ff51"""    
            }
        }
        
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
    
   
}