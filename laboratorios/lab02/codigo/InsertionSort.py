import time
import matplotlib.pyplot as plt

def insertionSort(nums):
    '''
    Ordena de menor a mayor un arreglo de enteros dado
    :param nums: Arreglo de enteros
    :return: El parámetro nums ordenado de menor a mayor
    '''
    for i in range(1, len(nums)):                    #C_1*(n-1)
        while i > 0 and nums[i] < nums[i-1]:         #C_2*n(n-1)/2
            nums[i-1],a[i] = nums[i], nums[i-1]      #C_3*n(n-1)/2
            i-=1                                     #C_4*n(n-1)/2
    return nums                                      #C_5

#T(n) = C_1*(n-1) + C_2*n(n-1)/2 + C_3*n(n-1)/2 + C_4*n(n-1)/2 + C_5
#T(n) es O(C_1*(n-1) + C_2*n(n-1)/2 + C_3*n(n-1)/2 + C_4*n(n-1)/2) + C_5   Notación O
#T(n) es O((C_2 + C_3 + C_4)((n^2-n)/2) + C_1*(n-1)) + C_5                 Factorización 
#T(n) es O((C_2 + C_3 + C_4)((n^2-n)/2))                                   Regla de suma 
#T(n) es O((n^2-n)/2)                                                      Regla del producto
#T(n) es O(n^2-n)                                                          Regla del producto
#T(n) es O(n^2)                                                            Regla de la suma

def array(n):
    w = []
    while n>=0:
        w+=[n]
        n-=1
    return w

def graficar(a, b):
    t = []
    x = []
    n = a
    while n<=b: 
        ti = time.time()
        insertionSort(array(n))
        t.append(time.time()-ti)
        n+=50
        x+=[n]
    plt.ylabel('Ecuación de la complejidad') 
    plt.xlabel('Tamaño del problema') 
    plt.plot(x, t, label = "MergeSort") 
    plt.legend()
    plt.grid() 
    plt.show()

graficar(0,1000)
