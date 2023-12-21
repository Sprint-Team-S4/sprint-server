# Prerequisites

In order to run this program locally, you are going to need:
- IntelliJ IDEA [https://www.jetbrains.com/idea/download/]
- Docker [https://www.docker.com/products/docker-desktop/]
- Postman [https://www.postman.com/downloads/]

# 1. Initial Setup

- Open the repository in IntelliJ.
- Right-click the pom.xml file and navigate to Maven > "Reload Project" to download dependencies.

# 2. Maven Clean Install

Option 1: (tool window [view > tool windows > maven])
- Under the "Lifecycle" folder, double-click on "clean" and then double-click on "install".

Option 2: (terminal)
- Run the command: 
`mvn clean install`

# 3. Terminal

- (To restart database) Run the commands:
`mysql -u root -p`
password:
Gosthatsit2
`DROP DATABASE finalsprint;
CREATE DATABASE finalsprint;
exit`

- (Docker) Run the commands:
`docker build -t username/sprintserver .
docker push username/sprintserver:latest
docker-compose up`

# 4. Inject Data into Database

- In mysql, copy and paste the text from [resources > data.sql] and run it as a query.
