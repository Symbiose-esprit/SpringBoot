pipeline {
    agent any
        tools { 
          maven 'M2_HOME' 
          jdk 'JAVA_HOME' 
        }
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ...' ;
                 git branch: 'yasmine',
                 url : 'https://github.com/Symbiose-esprit/SpringBoot.git';           
            }
        }
       stage('MVN COMPILE') {
            steps {
            	sh """ mvn -DskipTests clean package """ 
                sh """ mvn install """;
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
