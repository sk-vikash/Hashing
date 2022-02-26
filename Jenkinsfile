pipeline {
  agent any 
  
  stages {
    stage("#### Build ####") {
      steps {
        echo $GIT_URL
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
