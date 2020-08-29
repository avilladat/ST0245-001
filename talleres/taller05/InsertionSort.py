import time
import matplotlib.pyplot as plt


def insertionSort(a):
    for i in range(1, len(a)):             #C_1*(n-1)
        while i > 0 and a[i] < a[i-1]:     #C_2*n(n-1)/2
            a[i-1],a[i] = a[i], a[i-1]     #C_3*n(n-1)/2
            i-=1                           #C_4*n(n-1)/2

#T(n) = C_1*(n-1) + C_2*n(n-1)/2 + C_3*n(n-1)/2 + C_4*n(n-1)/2
#T(n) es O(C_1*(n-1) + C_2*n(n-1)/2 + C_3*n(n-1)/2 + C_4*n(n-1)/2)   Notación O
#T(n) es O((C_2 + C_3 + C_4)((n^2-n)/2) + C_1*(n-1))                 Factorización 
#T(n) es O((C_2 + C_3 + C_4)((n^2-n)/2))                             Regla de suma 
#T(n) es O((n^2-n)/2)                                                Regla del producto
#T(n) es O(n^2-n)                                                    Regla del producto
#T(n) es O(n^2)                                                      Regla de la suma

def array(n):
    w = []
    while n>=0:
        w+=[n]
        n-=1
    return w

def graficar(a, b):
    t = []
    for n in range(a, b): 
        ti = time.time()
        insertionSort(array(n))
        t.append(time.time()-ti)
    plt.ylabel('Ecuación de la complejidad') 
    plt.xlabel('Tamaño del problema') 
    plt.plot(range(1, b-a+1), t, label = "Insertion sort") 
    plt.legend()
    plt.grid() 
    plt.show()

graficar(0,1000)