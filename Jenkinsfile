pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {

                    bat 'mvn clean'
            }
        }

        stage ('Testing Stage') {

            steps {
                    bat 'mvn verify'
            }
        }

        }
    }
