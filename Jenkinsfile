pipeline {
    agent any
        tools { 
          maven 'M2_HOME' 
          jdk 'JAVA_HOME' 
        }
        environment {
        DOCKERHUB_CREDENTIALS = credentials('Dockerhub Account')
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

       stage('JUNIT/MVN Mockito') {
            steps {
                sh 'mvn test'
            }
        }
        stage('NEXUS'){
            steps{
                sh 'mvn deploy -DskipStaging=true'
            }
        }
         stage("Building Docker Image") {
                steps{
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/achat .'
                }
        }
        
        stage("Login to DockerHub") {
                steps{
                   // sh 'sudo chmod 666 /var/run/docker.sock'
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
                }
        }
        stage("Push to DockerHub") {
                steps{
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/achat'
                }
        }
        stage("Docker-compose") {
                steps{
                    sh 'docker-compose up -d'
                }
        }
        
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}
