def call(String dockerUsername = "darjihardik",
         String imageName = "todo-app",
         String imageTag = "latest",
         String containerName = "todo-app",
         String hostPort = "5000",
         String containerPort = "5000") {

    echo "Deploying Docker Container..."

    sh """
        docker pull ${dockerUsername}/${imageName}:${imageTag}

        docker stop ${containerName} || true

        docker rm ${containerName} || true

        docker run -d \
          --name ${containerName} \
          -p ${hostPort}:${containerPort} \
          ${dockerUsername}/${imageName}:${imageTag}
    """

    echo "Deployment completed successfully."
}
