"""
Autor: Vincent A. Arcila L.

Uso:
    fecha1 = time(2001,4,6)
    fecha2 = time(2000,4,10)
    fecha3 = time(2001,4,6)
    print(fecha1)
    fecha1.is_after(fecha2)
    fecha1.is_same(fecha3)

"""

class time():
    def __init__(self, year=2000, month=1, day=1, hours=0, minutes=0, seconds=0):
        self.year = year
        self.month = month
        self.day = day
        self.hours = hours
        self.minutes = minutes
        self.seconds = seconds

    def is_after (self , other):
        sec1=self.year*31536000+self.month*2629746+self.day*86400+self.hours*3600+self.minutes*60+self.seconds
        sec2=other.year*31536000+other.month*2629746+other.day*86400+other.hours*3600+other.minutes*60+other.seconds
        if sec1>sec2:
            return True
        return False

    def is_same(self, other):
        sec1=self.year*31536000+self.month*2629746+self.day*86400+self.hours*3600+self.minutes*60+self.seconds
        sec2=other.year*31536000+other.month*2629746+other.day*86400+other.hours*3600+other.minutes*60+other.seconds
        if sec1==sec2:
            return True
        return False


    def __str__(self):
        return "{3:}-{4:02d}-{5:02d} {0:02d}:{1:02d}:{2:02d}".format(self.hours,self.minutes,self.seconds,self.year,self.month,self.day)


