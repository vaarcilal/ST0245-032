import pyllist as ll

a = ll.dllist()
b = ll.dllist()

s1 = "hola"
s2 = "chao"
for i in s1:
    a.append(i)
for i in s2:
    b.append(i)

#for i in a:
#    print(i,end="")
#print()

a += b
for i in a:
    print(i,end="")
print()
