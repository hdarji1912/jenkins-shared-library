def call(String imageName = "todo-app",
         String imageTag = "latest",
         String containerName = "todo-app",
         String hostPort = "5000",
         String containerPort = "5000") {

    
    echo "Deploying Docker Container..."
  

    sh """
        # Stop the container if it is running
        docker stop ${containerName} || true

        # Remove the container if it exists
        docker rm ${containerName} || true

        # Remove old image (optional)
        docker rmi ${imageName}:${imageTag} || true

        # Run the latest container
        docker run -d \
            --name ${containerName} \
            -p ${hostPort}:${containerPort} \
            ${imageName}:${imageTag}
    """

    echo "Deployment completed successfully."
}
