pipeline {
    agent any  // Run on any available Jenkins machine

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/Mugalu-Wa-Thumba-Daniel/Working_With_Menus_and_Panels.git'  // Clone the code from GitHub
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'  // Compile the Java project using Maven
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarTest') {  // Run code analysis using SonarQube
                    bat 'mvn sonar:sonar'
                }
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'  // Run unit tests
            }
        }
    }
}
