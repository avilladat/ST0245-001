def euclides(a, b):
    if(a%b==0):
        return b
    else:
        return euclides(b, a%b)

print("Algoritmo de Euclides")
print(euclides(180, 1032))