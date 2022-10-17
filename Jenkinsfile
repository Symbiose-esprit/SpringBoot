pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ...' ;
                 git branch: 'master',
                 url : 'https://github.com/Symbiose-esprit/SpringBoot.git';           
            }
        }
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}