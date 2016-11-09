node {
    stage('SCM') {
        git 'https://github.com/cylong1016/MavenTest.git'
    }
    stage('QA') {
        sh 'sonar-scanner'
    }
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
        sh "docker stop cylong|| true"
        sh "docker rm cylong || true"
        sh "docker run --name cylong -p 11111:8080 -d tomcat"
        sh "docker cp target/DemoArtifact.war cylong:/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
