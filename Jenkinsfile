pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {

                    sh 'mvn clean compile'
            }
        }

        stage ('Testing Stage') {

            steps {
                    sh 'mvn verify -DXmlFile=testng.xml'
            }
        }


        stage ('Cucumber report') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'
                }
            }
        }
    }
