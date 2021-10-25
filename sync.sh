#!/bin/bash
BASE=/home/fmallet/git/_COURS/L3POO
cp ${BASE}/2021-2022/jar/*.jar HELPERS/jar
rsync -av ${BASE}/2020-2021/share/ HELPERS/src/
rsync -av ${BASE}/2021-2022/TP/TP?.tests TPs/tests/
rsync -av ${BASE}/2021-2022/CM/CM1 CM
