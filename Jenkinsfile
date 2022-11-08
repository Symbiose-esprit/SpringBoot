pipeline {
    agent any

    tools {
      maven 'MAVEN_HOME'
      jdk 'JAVA_HOME'
    }
    stages {

        stage('Clone repo GIT') {
            steps {
                git branch: 'mahdi',
                url : 'https://github.com/Symbiose-esprit/SpringBoot.git';
            }
        }
        stage('Mvn Scripts') {
            steps {
                echo 'cleaning project ...'
                sh 'mvn clean'

                echo 'artifact construction ...'
                sh 'mvn package -Dmaven.test.skip=true -P test-coverage'

                echo 'compiling project ...'
                sh 'mvn compile'
            }
        }
        stage('Mvn SonarQube') {
            steps {
            	sh """ mvn sonar:sonar -Dsonar.projectKey=springboot-devops -Dsonar.host.url=http://192.168.56.4:9000 -Dsonar.login="c7fd00e60ced552e1b184a3cbf62ef9e2095b9a0" """;
            }
        }
        stage('Build Image') {
            steps {
                sh 'docker build -t mahdibehi/springboot-devops:latest .'
            }
        }
        stage('Deploy Image') {
            steps {
                withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
                    sh "docker login -u mahdibehi -p ${dockerHubPwd}"
                }
                sh 'docker mahdibehi/springboot-devops:latest'
            }
        }
    }
    post {
        always {
             echo 'This will always run'
         }
    }
}