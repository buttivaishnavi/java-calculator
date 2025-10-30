pipeline {
    agent any

    tools {
        jdk 'JDK21'     // Name exactly as configured in Manage Jenkins → Tools
        maven 'Maven3'  // Name exactly as configured in Manage Jenkins → Tools
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                dir('java-calculator') {   // 👈 Run Maven inside the correct folder
                    script {
                        bat 'mvn clean install'
                    }
                }
            }
        }

        stage('Build & Test') {
            steps {
                dir('java-calculator') {   // 👈 Same folder
                    script {
                        bat 'mvn package'
                        bat 'mvn test'
                    }
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                dir('java-calculator') {   // 👈 Same folder
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
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

