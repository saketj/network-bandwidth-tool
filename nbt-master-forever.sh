#!/bin/bash

JAR=target/nbt-bundled-1.0-SNAPSHOT.jar
CONF=src/main/resources/config-remote.json
until java -jar $JAR -m -c $CONF; do
  echo "Master crashed with exit code $?.  Respawning in 1 second..."
  pid=$(ps aux | grep nbt-visualizer | head -1 | awk '{print $2}')
  kill $pid
  sleep 1
done
