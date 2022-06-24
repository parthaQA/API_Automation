pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
        jdk "Java_Home"
    }

    stages {
        stage('Build') {
            steps {

                // To run Maven on a Windows agent, use
                bat "mvn clean"
            }
         }

        stage('Test') {
            steps {

                    // To run Maven on a Windows agent, use
                bat "mvn verify -DXmlFile=testng.xml"
                }
            }
            post {
                always {
                    stage ('Cucumber Reports') {

                        steps {
                            cucumber buildStatus: "UNSTABLE",
                                fileIncludePattern: "**/cucumber.json",
                                jsonReportDirectory: 'target'

                        }

                    }
                 }
            }
    }
}

