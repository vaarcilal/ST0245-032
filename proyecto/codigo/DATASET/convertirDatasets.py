#!/usr/bin/env python
"""
Author: Vincent A. Arcila L.
Email: vaarcilal@eafit.edu.co

Script to translate latitude and longitude of the earth to meters from center, which will be first item.
"""

from sys import argv
import math

r = 6378100 # earth's radius

fileToRead = open(argv[1],"r")
fileToWrite = open(argv[1].strip(".txt") + "EnMetros.csv", "w") # file on which translations will be put

counter = 0;
origin = []
fileToWrite.write("x,y,z\n")
for line in fileToRead.readlines()[1:]:
    if counter == 0:
        line.strip("\n") # strip \n at the end of the line
        origin= [float(i) for i in line.split(",")] # get origin coordinates
        fileToWrite.write("0,0,0\n")
        counter += 1
        continue
    line.strip("\n") # strip \n at the end of the line
    coordinates = []
    counter2 = 0
    # relative difference from origin
    for i in line.split(","):
        coordinates.append( float(i) - origin[counter2] )
        counter2 += 1
    counter2 = 0

    coordinates = [(2 * math.pi * r * float(i))/360 for i in coordinates[:2]] + [coordinates[2]] # translate: 2 * pi * radius * angle / 360
    fileToWrite.write( str(coordinates[0]) + ",") 
    fileToWrite.write( str(coordinates[1]) + ",") 
    fileToWrite.write( str(coordinates[2]) + "\n") 
