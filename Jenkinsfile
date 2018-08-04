pipeline {
    agent { label 'local' }
	environment {
		jar_file = 'oneroster-api-1.0.jar'		
	}
    stages {
        stage('Build') {
            steps {
				echo 'Creating version stamp...'
				sh 'chmod +x infostamp.sh'	
				sh './infostamp.sh'
				echo 'Storing local copy of readme...'
				sh 'cp README.md api/src/main/resources/static/readme.md'
                echo 'Building..'
				dir("api") {
					sh 'chmod +x gradlew'					
					sh './gradlew clean unitTest'
					sh './gradlew clean assemble'
					dir("build/libs") {
						stash includes: jar_file, name: 'oneRoster'
						archiveArtifacts artifacts: '**', fingerprint: true
					}
				}
            }
        }
        stage('Test') {
            steps {
				echo 'Testing...'
				node ('stage') {
					unstash "oneRoster"
					sh 'pkill -f oneroster-api || true'
					script {
						withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
							sh 'nohup java -jar oneroster-api-1.0.jar &'
						}
					}
				}
				dir("api") {
					sh 'sleep 25'
					sh './gradlew karateTest -Dkarate.env=stg'
				}
			}
		}
		stage('Deploy') {
            steps {
                script {
                    if (env.BRANCH_NAME == 'master') {
                        sh 'scp api/build/libs/oneroster-api-1.0.jar deployment@thenewcarag.com:/usr/springboot/oneroster'
                        sh 'ssh deployment@thenewcarag.com sudo service oneroster-api restart'
                    } else {
                        echo 'Not on master branch; Skipping Deploy.'
                    }
                }
            }
        }
    }
	post {
        always {
            deleteDir() /* clean up our workspace */
        }        
    }
}