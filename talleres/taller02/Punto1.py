x = 50
y = 49

def GCD(x,y):
    if x==y:
        return y
    else:
        if x>y:
            return GCD(x-y,y)
        else:
            return GCD(y-x,x)

print(GCD(x,y))
