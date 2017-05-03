#!/bin/bash

SERVER=nbt-visualizer.js
COUNTER=0
while [ $COUNTER -lt 1 ]; do
    echo "Respawing nbt-visualizer server process..."
    timeout 1200 node $SERVER
    sleep 1
done
