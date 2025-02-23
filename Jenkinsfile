pipeline {
    agent any  // Run on any available Jenkins machine

    environment {
        BUTLER_PATH = "C:\\butler\\butler.exe"  // Update with actual Butler path
    }

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

        stage('Package for Deployment') {
            steps {
                 bat 'powershell Remove-Item -Path app.zip -ErrorAction Ignore'  // Delete old zip if it exists
                 bat 'powershell Compress-Archive -Path target/*.jar -DestinationPath app.zip -Force'  // Only package JAR file 
            }
        }

        stage('Deploy to Itch.io') {
            steps {
                withCredentials([string(credentialsId: 'itch.io', variable: 'ITCH_API_KEY')]) {
                    bat 'set BUTLER_API_KEY=%ITCH_API_KEY% && "%BUTLER_PATH%" push app.zip emma-nam/fasto:windows'  // Replace game ID if needed
                }
            }
        }
    }

    post {
        success {
            echo 'Build, Tests, SonarQube analysis, and Deployment to Itch.io completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check logs for details.'
        }
    }
}
