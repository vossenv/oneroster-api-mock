pipeline {
    agent { label 'local' }
	
	jar_file = 'oneroster-api-0.0.1-SNAPSHOT.jar'
	
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
				dir("api") {
					sh 'chmod +x gradlew'
					sh './gradlew clean unitTest'
					sh './gradlew clean assemble'
					dir("build/libs") {
						stash includes: jar_file, name: 'oneRoster'
					}
				}
            }
        }
        stage('Test') {
            steps {
				echo 'Testing...'
				node ('stage') {
					unstash "oneRoster"
					sh 'pkill -f oneroster-api-0.0.1-SNAPSHOT.jar'
					script {
						withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
							sh 'nohup java -jar oneroster-api-0.0.1-SNAPSHOT.jar &'
						}
					}
					sh './gradlew clean karateTest'
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