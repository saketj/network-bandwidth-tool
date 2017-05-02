val1=$(node ~/software/network-bandwidth-tool/nbt-system-stats/stats.js)
val2=$(ssh 10.235.18.232 'node ~/software/network-bandwidth-tool/nbt-system-stats/stats.js')
val3=$(ssh 10.226.23.148 'node ~/software/network-bandwidth-tool/nbt-system-stats/stats.js')
val4=$(ssh 10.226.25.150 'node ~/software/network-bandwidth-tool/nbt-system-stats/stats.js')
val5=$(ssh 10.226.23.4 'node ~/software/network-bandwidth-tool/nbt-system-stats/stats.js')
echo "[ $val1, $val2, $val3, $val4, $val5 ]"
