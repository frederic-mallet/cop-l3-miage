#!/bin/bash
cp ~/git/L3POO/2021-2022/jar/*.jar HELPERS/jar
rsync -av ~/git/L3POO/2020-2021/share/ HELPERS/src/
rsync -av ~/git/L3POO/2021-2022/TP/TP1.tests TPs/tests/
rsync -av ~/git/L3POO/2021-2022/CM/CM1 CM
