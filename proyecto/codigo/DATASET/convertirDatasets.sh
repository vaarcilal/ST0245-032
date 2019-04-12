#!/bin/bash

for i in $(ls *.txt)
do
    python convertirDatasets.py $i
done 
