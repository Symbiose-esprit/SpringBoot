pipeline {
    agent any
    tools { 
      maven 'M2_HOME'
      jdk 'JAVA_HOME' 
    }
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ....' ;
                 git branch: 'maryem',
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
            	sh """ mvn verify sonar:sonar -Dsonar.host.url=http://http://192.168.33.10/:9000/ 
                       -Dsonar.login=admin   -Dsonar.password=admin - """    
            }
        }
        
    
   
	
    post {
        always {  
             echo 'This will always run'  
         }    
    }
    
   }
}