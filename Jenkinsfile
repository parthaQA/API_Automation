pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3_8_5') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3_8_5') {
                    bat 'mvn verify -DXmlFile=testng.xml'
                }
            }
        }


        stage ('Cucumber report') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncluderPattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'
                }
            }
        }
    }
