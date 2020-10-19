pipeline {

  agent {
    label 'Slave_Induccion'
  }

  options {
    buildDiscarder(logRotator(numToKeepStr: '3'))
 	 disableConcurrentBuilds()
  }

  tools {
    jdk 'JDK8_Centos'
    gradle 'Gradle4.5_Centos'
  }

  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
        checkout([
			$class: 'GitSCM',
			branches: [[name: '*/master']],
			doGenerateSubmoduleConfigurations: false,
			extensions: [],
			gitTool: 'Default',
			submoduleCfg: [],
			userRemoteConfigs: [[
				credentialsId: 'GitHub_rquirpa-csh',
				url:'https://github.com/alejandro-diez-ceiba/adn.git'
			]]
		])
      }
    }

    stage('Permissions') {
      steps{
        echo "------------>Permissions<------------"
         sh 'chmod +x gradlew'
      }
    }

    stage('Clean') {
      steps{
        echo "------------>Clean<------------"
        sh './gradlew --b ./build.gradle clean'
      }
    }

    stage('Unit Tests') {
      steps{
        echo "------------>Unit Tests<------------"
        sh 'gradle --b ./build.gradle test'
		    sh 'gradle --b ./build.gradle jacocoTestReport'
      }
    }

    stage('Static Code Analysis') {
      steps{
          echo '------------>Análisis de código estático<------------'
          withSonarQubeEnv('Sonar') {
          sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
        sh './gradlew --b ./build.gradle build -x test'
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit 'build/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'alejandro.diez@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
    }
  }
}