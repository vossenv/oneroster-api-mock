pipeline {
    agent any
	tools {
		maven 'Maven 3.5.4'
		jdk 'JDK8'
	}

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
				
            }
        }
        stage('Test') {
            steps {
				echo 'Testing...'
			}
		}
        stage('Deploy') {
            steps {
                echo 'Deploying.....'
            }
        }
    }
}