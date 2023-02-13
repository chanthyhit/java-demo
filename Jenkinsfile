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
                sh './mvnw clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'whoami'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo $JAVA_HOME'
            }
        }
    }
}
