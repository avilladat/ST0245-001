#El siguiente hace llamado del metodo __subconjuntosbase__(base, t)
def subconjuntos(s):
       __subconjuntosbase__("",s)

#El siguiente metodo mediante llamados recursivos calcula e imprime las permutaciones guardadas en base de la cadena t
def __subconjuntosbase__(base, t):
    if len(t)==0:       
        print(base)
    else:
        for i in range(len(t)):
            __subconjuntosbase__(base+t[i], t[0:i]+t[i+1:])    

subconjuntos('abc')
