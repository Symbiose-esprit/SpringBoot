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
         stage('MNV CLEAN') {
            steps {
                sh 'mvn clean'
            }
        }
       stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
            }
        }
        
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}
