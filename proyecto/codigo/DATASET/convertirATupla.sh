#!/bin/bash

for i in $(ls *.csv)
do
    python convertirATupla.py $i
done 
