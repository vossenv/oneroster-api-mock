pipeline {
    agent { label 'local' }
	tools {
		gradle 'Gradle 4.8.1'
		jdk 'JDK8'
	}

    stages {
        stage('Build') {
            steps {
				sh 'whoami'
                echo 'Building..'
				dir("api") {
					sh 'chmod +x gradlew'
					sh './gradlew clean unitTest'
					sh './gradlew clean assemble'
				}
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
	post {
			always {
				archiveArtifacts artifacts: '**/*.jar', fingerprint:true
			}
		}
}