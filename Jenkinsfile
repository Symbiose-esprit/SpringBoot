pipeline {
    agent any
    tools { 
      maven 'M2_HOME'
      jdk 'JAVA_HOME' 
    }
    stages {
        stage('Checkout GIT') {
            steps {
                echo 'Pulling ....' ;
                 git branch: 'maryem',
                 url : 'https://github.com/Symbiose-esprit/SpringBoot.git';           
            }
        }
        stage('Test mvn') {
            steps {
            	sh """ mvn -DskipTests clean package """ 
                sh """ mvn install """;
                sh """ mvn test """;
            }
        }
        stage('Mvn SonarQube') {
            steps {
            	sh """ mvn verify sonar:sonar Dsonar.host.url=http://192.168.33.10:9000/ 
                              -Dsonar.login=admin  -Dsonar.password=sonar """ 
            }
        }
        
          stage('Nexus') {
            steps {
                script {
		nexusArtifactUploader artifacts: [[artifactId: 'tpAchatProject', classifier: '', file: 'target/tpAchatProject-1.0.jar', type: 'jar']], credentialsId: 'Nexus', groupId: 'com.esprit.examen', nexusUrl: '192.168.33.10:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-snapshots', version: '1.0.0-SNAPSHOT'
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
