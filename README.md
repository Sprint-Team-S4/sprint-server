# Prerequisites

In order to run this program locally, you are going to need:
- IntelliJ IDEA [https://www.jetbrains.com/idea/download/]
- Docker [https://www.docker.com/products/docker-desktop/]
- Postman [https://www.postman.com/downloads/]

# 1. Initial Setup

- Open the repository in IntelliJ.
- Right-click the pom.xml file and navigate to Maven > "Reload Project" to download dependencies.

# 2.a Maven Clean Install (tool window [view > tool windows > maven])

- Under the "Lifecycle" folder, double-click on "clean" and then double-click on "install".

# 2.b Maven Clean Install (terminal)

- Run the command: mvn clean install

# 3. Terminal

- Run the command: docker build -t kaylvigh/sprintserver .
- Run the command: docker push kaylvigh/sprintserver:latest
- Run the command: docker-compose up

docker build -t kaylvigh/sprintserver .
docker push kaylvigh/sprintserver:latest
docker-compose up
 
# database refresh

mysql -u root -p
Gosthatsit2
DROP DATABASE finalsprint;
CREATE DATABASE finalsprint;
exit
