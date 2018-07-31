pipeline {
    agent { label 'local' }
	environment {
		jar_file = 'oneroster-api-1.0.jar'
		commit_hash = sh(returnStdout: true, script: "git log -1 --pretty=format:'%H'").trim()
		commit_user = sh(returnStdout: true, script: "git log -1 --pretty=format:'%ce'").trim()
		commit_title = sh(returnStdout: true, script: "git log -1 --pretty=format:'%s'").trim()
		build_date = sh(returnStdout: true, script: "date +%m-%d-%Y' '%H:%M:%S").trim()
		full_message = "version = ${commit_hash}\ncommit_message = ${commit_title}\ncommit_user = ${commit_user}\nbuild_date = ${build_date}"
	}
    stages {
        stage('Build') {
            steps {
                dir("api/src/main/resources"){
                    echo 'Creating version stamp...'
                    writeFile file: "version.properties", text: full_message
                }
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
}