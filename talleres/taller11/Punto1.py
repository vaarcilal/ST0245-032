import numpy as np

class DigraphAM:
    def __init__(self,size):
        self.matrix = np.zeros((size,size))
    def addArc(self,source,dest,weight=1):
        self.matrix[source,dest] = weight
    def getWeight(self,source,dest):
        return self.matrix[source,dest]
    def getSucessors(self,i):
        lista = []
        for j in range(self.size):
            if self.matrix[i,j] != 0:
                lista.append(j)
        return lista

            
class DigraphAL:
    def __init__(self,size):
        self.matrix = np.empty(size,dtype=np.object)
        for i in range(size):
            self.matrix[i] = []
        self.size = size

    def addArc(self,source,dest,weight=1):
        self.matrix[source].append(dest)
        self.matrix[source].append(weight)

    def getWeight(self,source,dest):
        for j in range(0,len(self.matrix[source]),2):
            if self.matrix[source][j] == dest:
                return self.matrix[source][j+1]
                
    def getSucessors(self,source):
        lista = []
        for j in range(0,len(self.matrix[source]),2):
            lista.append(self.matrix[source][j])
        return lista



gmat = DigraphAL(5)
gmat.addArc(1,1)
gmat.addArc(1,4)
gmat.addArc(1,3)
print(gmat.getSucessors(1))
