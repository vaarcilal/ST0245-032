#!/usr/bin/env python
"""
Author: Vincent A. Arcila L.
"""
from sys import argv

s = ""
with open(argv[1],"r") as inpFile:
    with open( argv[1].rstrip(".txt") + "Processed.txt","w") as outFile:
        lines = inpFile.readlines()
        outFile.write(lines[0])
        for line in lines[1:]:
            if(line == "\n"):
                break

            state = True
            for ch in line:
                if(ch=="["):
                    state = False
                if(state==True):
                    outFile.write("H")
                else:
                    outFile.write(ch)


