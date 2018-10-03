# parking-service - spring boot 2.0 with mongodb


## Create a network which will be shared by spring-app and mongodb
docker network create spring_demo_net

## Running mongodb on docker
docker run --name spring-demo-mongo --network=spring_demo_net -v /home/ubuntu/mongo-data:/data/db -d mongo

Let'stake a look at this command closely:
docker run starts the container

--name mongo specifies the name of the container.

--network=custom_net means to which network container should be connected

-v d:/mongo-data:/data/db shares the host's d:/mongo-data folder and mounts it to the container's /data/db folder.

-d means to start the container as a daemon.

mongo is a docker image name.


## Building docker image

docker build --tag=spring-demo-1.0 .


## Running spring boot on docker

docker run -d --name spring-demo --network=spring_demo_net -p 8080:8080  spring-demo-1.0


docker logs spring-demo
