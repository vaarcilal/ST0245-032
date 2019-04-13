#!/usr/bin/env python
"""
Author: Vincent A. Arcila L.
Email: vaarcilal@eafit.edu.co

Script to convert scv into a python file with a list of tuples defined
"""

from sys import argv

fileToRead = open(argv[1],"r")
fileToWrite = open(argv[1].strip(".csv") + "s.py","w")

fileToWrite.write("TUPLE = [ ")
lines = fileToRead.readlines()
for line in lines[1:-1]:
    line.strip("\n")
    line = line.split(",")
    fileToWrite.write("( " +line[0] + ", " + line[1] + ", " + line[2].strip("\n") + "), ")


line = lines[-1]
line.strip("\n")
line = line.split(",")
fileToWrite.write("( " +line[0] + ", " + line[1] + ", " + line[2].strip("\n") + ") ]")
