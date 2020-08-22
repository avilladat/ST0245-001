import time
import matplotlib.pyplot as plt

def plot(times, n, lab):
    plt.xlabel('') 
    plt.ylabel('Ecuación de la complejidad') 
    plt.plot(range(1, n), times, label = lab) 
    plt.grid() 
    plt.legend() 
    plt.show()

#n es un entero ma
#La funcion f recibe el entero n y retorna el n-esimo numero de fibonacci
def f(n):
    if n<=1: return n             #C_1 = 3
    return f(n-1)+f(n-2)          #C_2 = 4

    #Complejidad del tiempo
    #T(n) = C_2 + T(n-1) + T(n-2)

def graficar(a, b):
    times = []
    for n in range(a, b): 
        ti = time.time()
        f(n)
        times.append(time.time()-ti)
    plot(times, b-a+1, "Sucesión de Fibonacci")

graficar(1, 30)