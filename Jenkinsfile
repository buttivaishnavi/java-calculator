pipeline {
    agent any

    tools {
        jdk 'JDK21'     // Use the exact name from Jenkins config
        maven 'Maven3'  // Must match your Maven tool name
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

    post {
        success {
            echo '✅ Build and archive completed successfully!'
        }
        failure {
            echo '❌ Build failed. Please check logs.'
        }
    }
}
