pipeline {
    agent any
    tools { 
      maven 'MAVEN_HOME' 
      jdk 'JAVA_HOME' 
    }
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ...' ;
                 git branch: 'master',
                 url : 'https://github.com/Symbiose-esprit/SpringBoot.git';           
            }
        }
	stage('Cleaning the project') {         
            steps {
                echo 'cleaning project ...'
                sh 'mvn clean'
            }
        }
	stage('Artifact Construction') {                 
            steps {
                echo "artificat contruction"
                sh 'mvn package -Dmaven.test.skip=true -P test-coverage'
            }
        }
	stage('Compiling the artifact') {      
            steps {
		echo "compiling"
                sh 'mvn compile'
               
            }
        }

        

        stage('Mvn SonarQube') {
            steps {
		jacoco(execPattern: 'target/jacoco.exec')
            	sh """ mvn sonar:sonar -Dsonar.login=7bd0ae6e97798de973a631cca7fd9b4643f8b8ec"""    
            }
        }
	stage('Nexus') {    
            steps {  
		script {          
		sh 'mvn deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=tpAchatProject -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://192.168.1.17:8081/repository/maven-releases/ -Dfile=target/tpAchatProject-1.0.jar'
		}
               
            }
        }
        
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}