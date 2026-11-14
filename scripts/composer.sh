#!/usr/bin/env bash

# Set variables.
NAME=rpc

# Clean before proceeding.
echo "Stopped container: $(docker stop $NAME)"
echo "Removed container: $(docker rm $NAME)"
docker rmi "$(docker images --format table | grep "/$NAME" | awk '{print $3}' | xargs)"

# Build and start the docker image.
docker compose up -d

# Wait for the RPC server starting inside the container.
echo -e "\nWaiting 5s..."
sleep 5s

# Test started RPC server
curl -w '\n' http://127.0.0.1:22023/api/rest/v1/system/info
