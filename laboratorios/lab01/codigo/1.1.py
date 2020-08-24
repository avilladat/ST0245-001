import time
import matplotlib.pyplot as plt
#x es una cadena de caracteres
#y es una cadena de caracteres
#El metodo Subcadena calcula la longitud de la subcadena comun mas larga entre x e y
def Subcadena(x, y):
    if(len(x)==0 or len(y)==0): return 0                                  #C_1 = 7
    if(x[len(x)-1] == y[len(y)-1]): return Subcadena(x[:-1], y[:-1]) + 1  #C_2 = 12
    return max(Subcadena(x[:-1], y), Subcadena(x, y[:-1]))                #C_3 = 4

    #T(n, m) = |C_1                         ,n==0 o m==0
    #          |C_2 + T(n-1, m-1)           ,
    #          |C_3 + T(n-1, m) + T(n, m-1) ,n>0 y m>0

def graficar(a, b):
    t = []
    for n in range(a, b): 
        ti = time.time()
        Subcadena(["x"]*n,["y"]*n)
        t.append(time.time()-ti)
    plt.ylabel('Ecuación de la complejidad') 
    plt.xlabel('Tamaño del problema') 
    plt.plot(range(1, b-a+1), t, label = "Subcadena común más larga") 
    plt.legend()
    plt.grid() 
    plt.show()
graficar(0,20)