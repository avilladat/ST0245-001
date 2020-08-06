def subconjuntos(s):
    subconjuntosbase("",s)

def subconjuntosbase(base, t):
    if t=="":
        print(base)
    else:
       subconjuntosbase(base+t[0],t[1:len(t)]) 
       subconjuntosbase(base,t[1:len(t)])

s = 'abc'
print('Los subconjuntos de "'+s+'" son:')
print(subconjuntos(s))
