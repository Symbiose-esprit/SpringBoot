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
	stage('Building our image') {      
            steps {
		sh 'docker build -t aminelaajimi/tpachatprojet:1.0.0 .'
               
            }
        }
	stage('Deploy our image') {
             
             
            steps {
               
		 withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerHubPwd')]) {
      		  sh " docker login -u aminelaajimi -p ${dockerHubPwd}"
        
               
            }
            sh 'docker push aminelaajimi/tpachatprojet:1.0.0'
        }        

    }
	stage('Docker compose') {
             
             
            steps {
               
            sh 'docker-compose up -d'
               
            }
        }
        
    }
	stage('Test JUnit/Mockito') {         
            steps {
               
            sh 'mvn test -Ptests,extra-tests,jacoco'
	    sh 'mvn verify -Pjacoco-generate-report -DskipTests'
               
            }
        }
        
    }
    post {
        always {  
             echo 'This will always run'  
         }    
    }
}