pipeline {
    agent any

    tools {
      maven 'MAVEN_HOME'
      jdk 'JAVA_HOME'
    }
    stages {

        stage('Clone Repo GIT') {
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

        stage('Docker Compose Sonexus') {
             steps {
                sh 'docker-compose -f docker-compose-sonexus.yml up -d'
             }
        }
        
        stage('Mvn SonarQube') {
            steps {
            	sh """ mvn sonar:sonar -Dsonar.projectKey=springboot-devops -Dsonar.host.url=http://192.168.56.4:9000 -Dsonar.login="eba03a61a8ad621f33f6f8c06687de49aa493e4d" """;
            }
        }

        stage('Nexus Script') {
            steps {
                script {
                	sh """ mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.56.4:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar """
                }
            }
        }

        stage('Build Image') {
            steps {
                sh 'docker build -t mahdibehi/springboot-devops:jenkins .'
            }
        }
        
        stage('Deploy Image') {
            steps {
                sh """ docker login -u mahdibehi -p dckr_pat_UoNF-WMddLEf6c9U8wG_AIisy44 """
                sh """ docker push mahdibehi/springboot-devops:jenkins """
            }
        }

        stage('Docker Compose') {
             steps {
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