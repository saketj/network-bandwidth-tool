#!/bin/bash
COUNTER=0
while [  $COUNTER -lt 10 ]; do
   node index.js
   echo "[`date '+%Y-%m-%d %H:%M:%S'`] Measurements pushed to keen.io cloud."
   sleep 20
done
