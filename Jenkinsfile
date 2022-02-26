pipeline {
  agent any 
  stages {
    stage("#### Build ####") {
      steps {
        echo sh(script: 'env|sort', returnStdout: true)
        sh "mvn -v"
      }
    }
    stage("#### Deploy ####")  {
      steps {
        echo "deploy"
        sh "env"
      }
    }
  }
}
