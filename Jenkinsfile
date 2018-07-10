pipeline {
    agent { label 'local' }
    stages {
        stage('Build') {
            steps {
				sh 'whoami'
				sh 'echo $JAVA_HOME'
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