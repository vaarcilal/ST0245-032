from time import process_time
import random
import sys
from matplotlib import pyplot as plt
import numpy as np

sys.setrecursionlimit(100000)


def sumar_arreglo(n):
    return sumar(n,0)

def sumar(n,index):
    if(index==len(n)):
        return 0
    return n[index] + sumar(n,index+1)

lista = []
tiempos = []
tamaños = range(20,20020,1000)
for i in tamaños:
    lista.append(i)
    one = process_time()
    suma = sumar_arreglo(lista)
    two = process_time()
    tiempos.append(two-one)

plt.rcParams.update({'figure.autolayout': True})

fig, ax = plt.subplots()
plt.style.use('fivethirtyeight')
fit = np.polyfit(range(1,21),tiempos,1)
fit_fn = np.poly1d(fit)
ax.plot(range(1,21),tiempos)
ax.plot(range(1,21),fit_fn(range(1,21)),'--k')
xlabels = range(1,21)
plt.xticks(xlabels)
ax.set(xlim=[1, 20], xlabel='Valores de n', ylabel='Tiempo (sg)',
       title='Tiempo vs N')
plt.show()
