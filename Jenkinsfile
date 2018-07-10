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
					dir("build/libs") {
						stash includes: 'oneroster-api-0.0.1-SNAPSHOT.jar', name: 'oneRoster'
					}
				}
            }
        }
        stage('Test') {
            steps {
				echo 'Testing...'
				node ('stage') {
					unstash "oneRoster"
					sh 'pkill -f \'java -jar oneroster-api-0.0.1-SNAPSHOT.jar\''
					script {
						withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
							sh 'nohup java -jar oneroster-api-0.0.1-SNAPSHOT.jar &'
						}
					}
					sh 'echo This is what you want to see'
				}
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