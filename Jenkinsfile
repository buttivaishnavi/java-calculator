pipeline {
    agent any

    tools {
        jdk 'C:\Program Files\Microsoft\jdk-21.0.8.9-hotspot'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Install Dependencies') {
            steps {
                script {
                    bat 'mvn clean install'
                }
            }
        }
        stage('Build & Test') {
            steps {
                script {
                    bat 'mvn package'
                    bat 'mvn test'
                }
            }
        }
        stage('Archive Artifact') {
            steps {
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}
