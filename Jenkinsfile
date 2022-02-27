pipeline {
  agent any

  options {
    buildDiscarder(loRotator(numToKeepStr: '30')
    disableConcurrentBuilds()
    timeout(time: 1, unit: 'HOURS')
    timestamps()
    ansiCOlor('xterm')
  }

  stages {
    stage("### Print All Pre Defined Variable ##") {
      steps {
        echo sh(script: 'env|sort', returnStdout: true)
      }
    }
    stage("### Maven ##")  {
      steps {
         sh 'mvn -v'
         sh 'mvn clean compile'
      }
    }
  }
}
