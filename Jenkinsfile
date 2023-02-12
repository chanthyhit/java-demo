pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    submoduleCfg: [],
                    userRemoteConfigs: [
                        [
                            url: 'https://github.com/chanthyhit/java-demo.git',
                            credentialsId: 'github-private-key'
                        ]
                    ]
                ])
            }
        }
        stage('Build') {
            steps {
                sh 'whoami'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo $JAVA_HOME'
            }
        }
    }
}
