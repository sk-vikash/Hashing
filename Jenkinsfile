pipeline {
  agent any 
  stages {
    stage("### Print All Pre Defined Variable ##") {
      steps {
        echo sh(script: 'env|sort', returnStdout: true)
      }
    }
    stage("### Maven ##")  {
      steps {
         sh "mvn -v"
         sh "mvn clean compile"
      }
    }
  }
}
