import pandas as pd
import numpy as np
from sklearn.neighbors import KDTree

X = [(1, 1,1), (2, 2,1), (3,3, 3), (4,4, 4), (5,5, 5)]
tree = KDTree(X)
print(tree)
