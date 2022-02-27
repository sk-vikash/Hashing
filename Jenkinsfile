pipeline {
  agent any 
  stages {
    stage("#### Check All Pre Defined Variable ####") {
      steps {
        echo sh(script: 'env|sort', returnStdout: true)
      }
    }
    stage("#### Check Maven Verion ####")  {
      steps {
         sh "mvn -v"
      }
    }
  }
}
