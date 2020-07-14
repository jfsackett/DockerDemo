# Docker Java
### Example source and config files for demonstrate basic Java operations in Docker.
### Author: Joseph Sackett

#### Installation Requirements
- Java 11+  
- Docker Engine:
    - Linux - [Docker Server](https://docs.docker.com/engine/install#server)
    - Windows - [Docker Desktop](https://docs.docker.com/docker-for-windows/install/)
    - Mac - [Docker Desktop](https://docs.docker.com/docker-for-mac/install/)

#### Build Instructions
1. Clone or download this repository: [jfsackett/DockerDemo](https://github.com/jfsackett/DockerDemo)
2. Open shell and change to DockerJava project root: **&lt;install-path&gt;/DockerDemo/DockerJava**
3. Use Gradle Wrapper to build docker image by executing shell command:  
   `$ ./gradlew docker`
4. Confirm that image built:  
```
$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
docker-java         1                   8b775a0b060c        12 seconds ago      188MB
```

Developer configurations with Gradle installed do not need wrapper: all commands same except use gradle (not gradlew).  
You may also build image manually (after building jar with gradle):  
`$ docker build --tag docker-java:1 .`

#### Execution Instructions
These examples demonstrate various common operation needed by Java applications, including passing command line parameters and reading from files within the image and through binds.  
- Execute default Java app (demo.HelloArgs) with default args:
`docker run docker-java:1`  
- Execute default Java app (demo.HelloArgs) with specfied args:
`docker run docker-java:1 User`  
- Execute specified Java app (demo.HelloArgs) with specfied args:
`docker run docker-java:1 demo.HelloArgs Superuser`
- Execute Java app (demo.EchoFile) to show contents of file inside image:
`docker run docker-java:1 demo.EchoFile README.md`  
- Execute Java app (demo.EchoFile) to show contents of Dockerfile using bind monts:
`docker run --mount type=bind,source="$(pwd)",target=/usr/input,readonly docker-java:1 demo.EchoFile input/Dockerfile`  
