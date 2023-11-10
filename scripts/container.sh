#!/usr/bin/env bash

# set variables
NAME=rpc
VERSION=0.0.1

# clean before proceeding
mvn clean
docker stop $NAME
docker rm $NAME
docker rmi "$(docker images | grep $VERSION | awk '{print $3}')"

# build the RPC server
mvn package

# build the docker image
docker build -t $NAME:$VERSION .

# start the container
docker run --name $NAME -d --restart always -p 22023:22023 $NAME:$VERSION

# wait for the server to start inside the container
sleep 5s

# test started server
curl http://127.0.0.1:22023/api/rest/v1/system/info
echo ""
echo "OK"