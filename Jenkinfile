pipeline {
  agent any 
  
  stages {
    stage("#### Build ####") {
      steps {
        sh "mvn -v"
      }
    }
    stage("#### Deploy ####")  {
      steps {
        echo "deploy"
      }
    }
  }
}
