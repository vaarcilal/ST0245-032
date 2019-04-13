#!/usr/bin/env python
from sklearn.neighbors import KDTree
from sys import argv
from time import process_time
from os import getpid
import psutil

TUPLE = getattr(__import__(argv[1].strip(".py"), fromlist=["TUPLE"]), "TUPLE")


process = psutil.Process(getpid())
print(len(TUPLE))

t = 0
for i in range(10):
    a = process_time()
    tree = KDTree(TUPLE,leaf_size=2)
    b = process_time()
    t += (b - a)
t /=10
print("Tree generation mean time: {}".format(t))

t = 0
for i in range(10):
    a = process_time()
    tree.get_arrays()
    b = process_time()
    t += (b - a)
t /=10
print("Search item time: {}".format(t))


print("Memory used by program: {}".format(process.memory_info().rss))

t = 0
for i in range(10):
    a = process_time()
    collision_indices = tree.query_radius(TUPLE, r=100)
    b = process_time()
    t += (b - a)
t /=10
print("Collision detection mean time: {}".format(t))

#collisions = [[TUPLE[idx] for idx in indices] for indices in collision_indices]
#
#result = []
#for collision in collisions:
#    if len(collision) > 1:
#        for i in collision:
#            if i not in result:
#                result.append(i)
