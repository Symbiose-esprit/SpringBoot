pipeline {
    agent any

    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ...' ;
                 git branch: 'mahdi',
                 url : 'https://github.com/Symbiose-esprit/SpringBoot.git';           
            }
        }

        stage('Test mvn') {
            steps {
                echo """maven -version"""
            	sh """ mvn -DskipTests clean package """ 
                sh """ mvn install """;
                sh """ mvn test """;
            }
        }
        /*
        stage('Mvn SonarQube') {
            steps {
		jacoco(execPattern: 'target/jacoco.exec')
            	sh """ mvn sonar:sonar -Dsonar.login=7bd0ae6e97798de973a631cca7fd9b4643f8b8ec"""    
            }
        }
        */
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}
node {
    def WORKSPACE = "/var/lib/jenkins/workspace/springboot-devops"
    def dockerImageTag = "springboot-devops${env.BUILD_NUMBER}"

    try{

        stage('Clone Repo') {
            git branch: 'mahdi',
            git url : 'https://github.com/Symbiose-esprit/SpringBoot.git',
                credentialsId: '307a3184-b702-486c-bdca-a208080ae8f3',
                branch: 'mahdi'
        }
        stage('Build Docker'){
            dockerImage = docker.build("springboot-devops:${env.BUILD_NUMBER}")
        }
        stage('Deploy Docker'){
            echo "Docker Image Tag Name: ${dockerImageTag}"
            sh "docker stop springboot-devops || true && docker rm springboot-devops || true"
            sh "docker run --name springboot-devops -d -p 8081:8080 springboot-devops:${env.BUILD_NUMBER}"
        }
    }catch(e){
        throw e
    }
}

