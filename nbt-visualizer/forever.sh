#!/bin/bash

SERVER=nbt-visualizer.js
COUNTER=0
while [ $COUNTER -lt 1 ]; do
  # Check if nbt-visualizer.js is running or not.
  N=$(ps aux | grep nbt-visualizer.js  | wc -l)
  if [ $N -lt 2 ]; then
    # Respawn the process
    echo "Respawing nbt-visualizer server process..."
    node $SERVER
  fi
  sleep 3
done
