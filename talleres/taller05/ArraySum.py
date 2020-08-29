import time
import matplotlib.pyplot as plt



def ArraySum(a):
    c = 0               #C1
    for i in a: c+=i    #C2*n        
    return c            #C3

#T(n) = C1 + C2*n + C3
#T(n) es O(C1 + C2*n + C3)    Notación O 
#T(n) es O(n)                 Regla de la suma y producto

def graficar(a, b):
    t = []
    n = a
    x = [n]
    while n <= b:
        ti = time.time()
        ArraySum([1]*n)
        t.append(time.time()-ti)
        n+=100000
        if n!=b: x+=[n]
    plt.ylabel('Ecuación de la complejidad') 
    plt.xlabel('Tamaño del problema') 
    plt.plot(x, t, label = "Suma de arreglos") 
    plt.legend()
    plt.grid() 
    plt.show()

graficar(10000000,20000000)

