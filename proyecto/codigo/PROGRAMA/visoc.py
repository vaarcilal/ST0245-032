#!/usr/bin/env python
from pyoctree import pyoctree as ot
import numpy as np
from sys import argv
from time import process_time
from os import getpid
import psutil

TUPLE = getattr(__import__(argv[1].strip(".py"), fromlist=["TUPLE"]), "TUPLE")
dt = np.dtype('float','float','float')
arr = np.array(TUPLE,dtype=dt)
connectivity = np.zeros((len(TUPLE),3),dtype=np.int32)

process = psutil.Process(getpid())
print(len(TUPLE))

t = 0
for i in range(10):
    a = process_time()
    tree = ot.PyOctree(arr,connectivity)
    b = process_time()
    t += (b - a)
t /=10
print("Tree generation mean time: {}".format(t))
t = 0
for i in range(10):
    a = process_time()
    tree.
    b = process_time()
    t += (b - a)
t /=10
print("Search item time: {}".format(t))


"""
print("Memory used by program: {}".format(process.memory_info().rss))

t = 0
for i in range(10):
    a = process_time()
    collision_indices = tree.query_radius(TUPLE, r=100)
    b = process_time()
    t += (b - a)
t /=10
print("Collision detection mean time: {}".format(t))

"""
