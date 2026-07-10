def call(String dockerUsername, String imageName, String imageTag = "latest") {

  
    echo "Building Docker Image..."
    echo "Image : ${dockerUsername}/${imageName}:${imageTag}"
    

    sh """
        docker build -t ${dockerUsername}/${imageName}:${imageTag} .
    """

    echo "Docker image built successfully."
}
