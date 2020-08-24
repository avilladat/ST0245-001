import time
import matplotlib.pyplot as plt
#n es un entero positivo
#El metodo rec calcula la cantidad de rec que existen para llenar un rectangulo de 2xn con rectangulos de 2x1
def rec(n):
    if n<=2: return n         
    return rec(n-1)+rec(n-2)  

def graficar(a, b):
    t = []
    for n in range(a, b): 
        ti = time.time()
        rec(n)
        t.append(time.time()-ti)
    plt.ylabel('Ecuación de la complejidad') 
    plt.xlabel('Tamaño del problema') 
    plt.plot(range(1, b-a+1), t, label = "Rellenar rectangulo") 
    plt.legend()
    plt.grid() 
    plt.show()
graficar(1,30)