/*
node {
    def WORKSPACE = "/var/lib/jenkins/workspace/springboot-devops"
    def dockerImageTag = "springboot-devops${env.BUILD_NUMBER}"

    try{

        stage('Clone Repo') {
            git branch: 'mahdi',
            git url : 'https://github.com/Symbiose-esprit/SpringBoot.git',
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
*/

pipeline {
    agent any

    stages {
        stage('Testing maven') {
            steps {
                echo """maven -version"""
            }
        }
    }
}
