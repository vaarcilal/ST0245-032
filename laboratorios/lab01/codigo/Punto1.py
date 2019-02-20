def llenarRect(n):
    if n <= 3:
        return n
    return llenarRect(n-1) + llenarRect(n-2)

print(llenarRect(3))
