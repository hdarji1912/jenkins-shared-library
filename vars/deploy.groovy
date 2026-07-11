def call(String dockerUsername = "darjihardik",
         String imageName = "todo-app",
         String imageTag = "latest",
         String containerName = "todo-app",
         String hostPort = "5000",
         String containerPort = "5000") {

    echo "🚀 Deploying Docker Container..."

    // Debug Information
    sh """
        echo "=============================="
        echo " HOSTNAME"
        echo "=============================="
        hostname

        echo ""
        echo "=============================="
        echo " CURRENT USER"
        echo "=============================="
        whoami

        echo ""
        echo "=============================="
        echo " DOCKER CONTAINERS"
        echo "=============================="
        docker ps -a

        echo ""
        echo "=============================="
        echo " PORT 5000 STATUS"
        echo "=============================="
        sudo ss -ltnp | grep 5000 || true

        echo ""
        echo "=============================="
        echo " DOCKER IMAGES"
        echo "=============================="
        docker images
    """

    // Pull latest image
    sh """
        docker pull ${dockerUsername}/${imageName}:${imageTag}
    """

    // Stop and remove old container
    sh """
        docker stop ${containerName} || true
        docker rm ${containerName} || true
        docker container prune -f
    """

    // Run new container
    sh """
        docker run -d \
            --restart unless-stopped \
            --name ${containerName} \
            -p ${hostPort}:${containerPort} \
            ${dockerUsername}/${imageName}:${imageTag}
    """

    echo "✅ Deployment completed successfully."
}
