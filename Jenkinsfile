pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = 'dockerhub-credentials'
        IMAGE_NAME = 'zakkedocker/otp2-week2'
        IMAGE_TAG = 'latest'
        SONAR_TOKEN = 'SonarQubeToken'
    }

    stages {
        stage('Build and test') {
            steps {
                bat 'mvn clean test jacoco:report'
            }
        }
        stage('Publish test results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish coverage report') {
            steps {
                jacoco()
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    bat 'mvn sonar:sonar'
                }
            }
        }
        stage('Build Docker image') {
            steps {
                bat "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }
        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: "${DOCKERHUB_CREDENTIALS}",
                    usernameVariable: 'USERNAME',
                    passwordVariable: 'PASSWORD'
                )]) {
                    bat "echo %PASSWORD% | docker login -u %USERNAME% --password-stdin"
                    bat "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
                    bat "docker logout"
                }
            }
        }
    }
}