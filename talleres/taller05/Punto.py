from time import process_time
import random
import sys
from matplotlib import pyplot as plt
import numpy as np

def insertion_sort(lista):
    for i in range(len(lista)):
        num = lista[i]
        j = i-1
        while j >=0 and num < lista[j] : 
                lista[j+1] = lista[j] 
                j -= 1
        lista[j+1] = num 

lista = []
tiempos = []
tamaños = range(1000,5000,500)
print(len(tamaños))
for i in tamaños:
    lista += list(reversed(range(i)))
    one = process_time()
    suma = insertion_sort(lista)
    two = process_time()
    tiempos.append(two-one)

plt.rcParams.update({'figure.autolayout': True})

fig, ax = plt.subplots()
plt.style.use('fivethirtyeight')
ax.plot(range(1,9),tiempos)
xlabels = range(1,9)
plt.xticks(xlabels)
ax.set(xlim=[1, 9], xlabel='Valores de n', ylabel='Tiempo (sg)',
       title='Tiempo vs N')
plt.savefig("/home/vincent/Documents/RepoDatos/ST0245-032/talleres/taller05/Punto1.png")    
plt.show()
