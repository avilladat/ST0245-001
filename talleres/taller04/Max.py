import sys
import time
import matplotlib.pyplot as plt

sys.setrecursionlimit(100000000) 

def plot(times, n, lab):
    plt.xlabel('') 
    plt.ylabel('Ecuación de la complejidad') 
    plt.plot(range(1, n), times, label = lab) 
    plt.grid() 
    plt.legend() 
    plt.show()

#a es una lista de enteros
#n es la longitud de al menos 1
#El metodo auxmax recibe a y n, y retorna el elemento de a que es mayor a todos los demas elementos
def auxmax(a, n):
    if n == 1: return a[0]             #C_1 = 4
    return max(a[n-1], auxmax(a, n-1)) #C_2 = 5

    #Complejidad del tiempo
    #T(n) = C_2 + T(n-1) con C_2 = 5
    #T(n) = C_2*n + C_1 con C_1 = 4

#numeros es una lista de enteros
#El metodo max retorna el llamado a auxmax con numeros y el entero 0
def amax(a):
    n = len(a)
    return auxmax(a, n)

def graficar(a, b):
    times = []
    for n in range(a, b): 
        ti = time.time()
        amax([1]+[0]*n)
        times.append(time.time()-ti)
    plot(times, b-a+1, "Suma Volumenes")

graficar(1,1000)