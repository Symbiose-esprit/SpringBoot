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
            	sh """ mvn verify sonar:sonar -Dsonar.host.url=http://192.168.33.10:9000/ 
                       -Dsonar.login=50f1b40924f73c84e539c4635b3eeaf49a38ec13    """    
            }
        }
        
         
    }
   
	
    post {
        always {  
             echo 'This will always run'  
         }    
    }
    
   }
