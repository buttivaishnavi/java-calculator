pipeline {
    agent any

    tools {
        jdk 'JDK17'     // Must match Jenkins configuration
        maven 'Maven3'  // Must match Jenkins configuration
    }

    stages {
        stage('Checkout') {
            steps {
                // This automatically checks out your GitHub repository
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean install'
                    } else {
                        bat 'mvn clean install'
                    }
                }
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn package'
                        sh 'mvn test'
                    } else {
                        bat 'mvn package'
                        bat 'mvn test'
                    }
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                // Publish test results and store the built JAR file
                junit 'target/surefire-reports/*.xml'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Build and archive completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check logs.'
        }
    }
}
