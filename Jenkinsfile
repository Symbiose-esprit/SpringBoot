pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ...' ;
                 git branch: 'yasmine',
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
        
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}
