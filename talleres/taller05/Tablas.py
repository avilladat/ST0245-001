import time
import matplotlib.pyplot as plt

def tablas(n):
    for i in range(n):                                                              #C_1*n                                 
        for j in range(n): return i*j  #print(str(i)+"  x  "+str(j)+"  =  "+str(i*j))   #C_2*10*n

#T(n) = C1*n + C_2*10*n
#T(n) es O(C1*n + C_2*10*n)   Notación O 
#T(n) es O(n)                 Regla de la suma y producto

def graficar(a, b):
    t = []
    n = a
    x = [n]
    while n <= b:
        ti = time.time()
        tablas(n)
        t.append(time.time()-ti)
        n+=1000000000000000000000000000000000000000000000000000000000000000000000000000
        #if n!=b: x+=[n]
        for i in t: print(i)
    '''
    plt.ylabel('Ecuación de la complejidad') 
    plt.xlabel('Tamaño del problema') 
    plt.plot(x, t, label = "Suma de arreglos") 
    plt.legend()
    plt.grid() 
    plt.show()
    '''

graficar(0,10000000000000000000000000000000000000000000000000000000000000000000000000000)