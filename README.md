# Prerequisites

In order to run this program locally, you are going to need:
- IntelliJ IDEA [https://www.jetbrains.com/idea/download/]
- Docker [https://www.docker.com/products/docker-desktop/]
- Postman [https://www.postman.com/downloads/]

# Initial Setup

- Open the repository in IntelliJ.
- Right-click the pom.xml file and navigate to Maven > "Reload Project" to download dependencies.

# Maven Tool Window (view > tool windows > maven)

- Under the "Lifecycle" folder, double-click on "clean" and then double-click on "install".

# Terminal

- Run the command: docker build -t username/sprintserver .
- Run the command: docker push username/sprintserver:latest
- Run the command: docker-compose up

# Postman

- In postman, make a request to http://localhost:8080/ and at the end type aircraft, airport, city, or passengers.
