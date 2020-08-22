import time
import matplotlib.pyplot as plt

def plot(times, n, lab):
    plt.xlabel('') 
    plt.ylabel('Ecuación de la complejidad') 
    plt.plot(range(1, n), times, label = lab) 
    plt.grid() 
    plt.legend() 
    plt.show()

#nums es una lista de enteros
#start es un entero que nos indicara en que elemento de nums estamos
#target es el objetivo que queremos alcanzar sumando ciertos elementos de nums
#El metodo suma_volumenes_aux retorna true o false dependiendo si existe almenos una manera de conseguir target sumando elementos de nums
def suma_volumenes_aux(start, nums, target):
    if start==len(nums): return target==0                                                                        #C_1 = 5
    return suma_volumenes_aux(start+1, nums, target-nums[start]) or suma_volumenes_aux(start+1, nums, target)    #C_2 = 6

    #Complejidad del tiempo
    #T(n) = C_2 + T(n-1) + T(n-1) con C_2 = 6
    #T(n) = c2 (2^n - 1) + c1 2^(n-1) 

def suma_volumenes(nums, target):
    return suma_volumenes_aux(0, nums, target)

def graficar(a, b):
    times = []
    for n in range(a, b): 
        ti = time.time()
        suma_volumenes([0]*n, 10)
        times.append(time.time()-ti)
    plot(times, b-a+1, "Suma Volumenes")

graficar(1, 23)