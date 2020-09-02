import time
import matplotlib.pyplot as plt

def mergeSort(nums):
    '''
    Ordena de menor a mayor un arreglo de enteros dado
    :param nums: Arreglo de enteros
    :return: El parámetro nums ordenado de menor a mayor
    '''
    if len(nums)<2: return nums                       
    nums1 = mergeSort(nums[:int(len(nums)/2)])        
    nums2 = mergeSort(nums[int(len(nums)/2):])        
    i=0                                          
    j=0                                                                              
    sortnums = []                                     
    while i<len(nums1) and j<len(nums2):              
        if nums1[i]>nums2[j]:
            sortnums+=[nums2[j]]
            j+=1
        else:
            sortnums+=[nums1[i]]
            i+=1   
    if(i>=len(nums1)): sortnums += nums2[j:]
    else: sortnums += nums1[i:]
    return sortnums

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
        mergeSort(array(n))
        t.append(time.time()-ti)
        n+=50
        x+=[n]
    plt.ylabel('Ecuación de la complejidad') 
    plt.xlabel('Tamaño del problema') 
    plt.plot(x, t, label = "MergeSort") 
    plt.legend()
    plt.grid() 
    plt.show()

graficar(0,1000000)

