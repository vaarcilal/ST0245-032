from time import process_time
import random
import sys
from matplotlib import pyplot as plt

sys.setrecursionlimit(100000)

def llenarRect(n):
    if n <= 3:
        return n
    return llenarRect(n-1) + llenarRect(n-2)

tiempos = []
for i in range(1,21):
    one = process_time()
    value = llenarRect(i)
    two = process_time()
    tiempos.append(two-one)

plt.rcParams.update({'figure.autolayout': True})
print(len(tiempos))
fig, ax = plt.subplots()
plt.style.use('fivethirtyeight')
ax.plot(range(1,21),tiempos)
xlabels = range(1,21)
plt.xticks(xlabels)
ax.set(xlabel='Valores de n', ylabel='Tiempo (sg)',
       title='Tiempo vs N')
plt.show()
