def call(String repoUrl, String branch = "main") {

   
    echo "Cloning Repository..."
    echo "Repository : ${repoUrl}"
    echo "Branch     : ${branch}"
  

    git(
        branch: branch,
        url: repoUrl
    )

    echo "Repository cloned successfully."
}
