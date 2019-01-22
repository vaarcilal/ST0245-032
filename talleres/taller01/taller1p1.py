"""
Autor: Vincent A. Arcila L.

Uso:
    p1 = punto()
    p2 = punto()
    p1.cambiar_coordenadas(4,5)
    p2.cambiar_coordenadas(5,4)

    p1.hallar_radio()
    p1.hallar_and()

    p1.dist_euclidiana(p1)

"""

import math
class punto:
    def __init__(self):
        self.x = 0
        self.y = 0
        self.rad = 0
        self.ang = 0

    def cambiar_coordenadas(self,x,y):
        self.y = y
        self.x = x
        self.hallar_radio()

    def hallar_radio(self):
        self.rad = math.sqrt( (self.x**2) + (self.y**2) )
        return self.rad
        

    def hallar_ang(self):
        self.ang = math.degrees(math.atan(self.y/self.x))
        return self.ang

    def dist_euclideana(self,p2):
        return math.sqrt( ((self.x-p2.x)**2) + ((self.y-p2.y)**2) )

