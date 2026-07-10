def call(String credentialsId, String imageName, String imageTag = "latest") {

    withCredentials([usernamePassword(
        credentialsId: credentialsId,
        usernameVariable: 'DOCKER_USERNAME',
        passwordVariable: 'DOCKER_PASSWORD'
    )]) {

        
        echo "Logging into Docker Hub..."
        

        sh """
            echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin

            docker tag ${imageName}:${imageTag} \$DOCKER_USERNAME/${imageName}:${imageTag}

            docker push \$DOCKER_USERNAME/${imageName}:${imageTag}

            docker logout
        """

        echo "Docker image pushed successfully."
    }
}
