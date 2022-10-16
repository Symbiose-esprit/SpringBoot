pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ...' ;
                 git branch: 'master',
                 url : 'https://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@github.com/Symbiose-esprit/SpringBoot.git';           
            }
        }
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}