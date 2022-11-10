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

        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar  -Dsonar.login=admin -Dsonar.password=yassou'
            }
        }

        stage('NEXUS'){
            steps{
                sh 'mvn deploy -DskipStaging=true'
            }
        }
        
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}
