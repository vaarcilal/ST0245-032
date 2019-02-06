import pyAesCrypt
def perm(l):
    if len(permutation) == n:
        print("".join(permutation))
    else:
        for i in range(n):
            if chosen[i]:
                continue
            chosen[i] = True
            permutation.append(l[i])
            perm(l)
            chosen[i] = False
            permutation.pop()
string = "abcd"
n = len(string)
chosen = [False] * len(string)
permutation = []
perm(string)
