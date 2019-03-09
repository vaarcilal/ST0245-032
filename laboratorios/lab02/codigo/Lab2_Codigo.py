import random
import sys
from time import process_time
from matplotlib import pyplot as plt 

sys.setrecursionlimit(2000000000)

def insertionSort(x):
    for i in range(1, len(x)):
        key = x[i]
        j = i-1
        while j >=0 and key < x[j] :
                x[j+1] = x[j]
                j -= 1
        x[j+1] = key
    return x


def arrSum(nums, i,s):
    if i == len(nums):
        return s
    return arraySum(nums,i+1) + nums[i] + s
def arraySum(nums, i):
    return arrSum(nums,i,0)

def arrMax(nums,i,m):
    if i == len(nums):
        return m
    if(nums[i] > m):
        m = nums[i]
    return arrMax(nums,i+1,m)

def arrayMax(nums,n):
    return  arrMax(nums,n,nums[0])

def mergeSort(arr):
    if len(arr) >1: 
        mid = len(arr)//2 
        L = arr[:mid]
        R = arr[mid:]
        mergeSort(L) 
        mergeSort(R) 
        i = j = k = 0
        while i < len(L) and j < len(R): 
            if L[i] < R[j]: 
                arr[k] = L[i] 
                i+=1
            else: 
                arr[k] = R[j] 
                j+=1
            k+=1
          
        while i < len(L): 
            arr[k] = L[i] 
            i+=1
            k+=1
          
        while j < len(R): 
            arr[k] = R[j] 
            j+=1
            k+=1
        return arr


def randomarray(n):
    return [(int)(-100*random.random()+100) for e in range(n)]
def reversedarray(n):
    return list(range(n,0,-1))

def medirMergeSort():
    tiempos = []
    valoresn = [500,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,18000,18500,19000,19500,20000,30000,35000,38000,40000]
    print("MERGESORT")
    for i in valoresn:
        lista = randomarray(i)
        #arraySum(lista,int((len(lista)/2)))
        one = process_time()
        suma = mergeSort(lista)
        two = process_time()
        tiempos.append(two-one)
        print(str(i)+ "  -  " + str(two - one))

    plt.plot(valoresn,tiempos)
    #plt.xticks(valoresn)
    plt.xlim(500,40000)
    plt.xlabel('Valores de N')
    plt.ylabel('Tiempo (sg)')
    plt.title('Tiempo vs N - MergeSort')
    plt.savefig('mergeSort.png')

def medirInsertionSort():
    tiempos = []
    valoresn = [500,1000,2000,3000,4000,5000,6000,7000,8000,9000,10000,18000,18500,19000,19500,20000,30000,35000,38000,40000]
    print("INSERTIONSORT")
    for i in valoresn:
        lista = reversedarray(i)
        #arraySum(lista,int((len(lista)/2)))
        one = process_time()
        suma = insertionSort(lista)
        two = process_time()
        tiempos.append(two-one)
        print(str(i)+ "  -  " + str(two - one))

    plt.plot(valoresn,tiempos)
    #   plt.xticks(valoresn)
    plt.xlim(500,40000)
    plt.xlabel('Valores de N')
    plt.ylabel('Tiempo (sg)')
    plt.title('Tiempo vs N - InsertionSort')
    plt.savefig('insertionSort.png')




plt.style.use('grayscale')
#medirMergeSort()
medirInsertionSort()
