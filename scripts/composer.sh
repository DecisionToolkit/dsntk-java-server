#!/usr/bin/env bash

# Set variables.
NAME=rpc

# Clean before proceeding.
echo "Stopped container: $(docker stop $NAME)"
echo "Removed container: $(docker rm $NAME)"
docker rmi "$(docker images | grep /$NAME | awk '{print $3}' | xargs)"

# Build the docker image.
docker-compose up -d

# Wait for the server to start inside the container.
echo -e "\nWaiting 5s..."
sleep 5s

# Test the started server
curl -w '\n' http://127.0.0.1:22023/api/rest/v1/system/info