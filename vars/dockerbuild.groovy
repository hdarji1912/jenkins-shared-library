def call(String imageName, String imageTag = "latest") {

    
    echo "Building Docker Image..."
    echo "Image Name : ${imageName}"
    echo "Image Tag  : ${imageTag}"

    sh """
        docker build -t ${imageName}:${imageTag} .
    """

    echo "Docker image built successfully."
}
