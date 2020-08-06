def ics(x, y):
    xa = []
    icsaux("", x, xa)
    ya = []
    icsaux("", y, ya)
    sa = []
    for i in xa:
        for j in ya:
            if i==j:
                sa.append(i)
    print('La longitud de la subsecuencia común más larga es: '+ str(len(sa[0])))
    if(len(sa[0])==0):
        print('Por lo tanto, no hay subsecuencias comunes')
    else:    
        print('Las subsecuencias comunes que tienen esta longitud son: ')            
    for i in sa:
        if len(sa[0])==len(i):
            print(i)

def icsaux(base, t, s):
    if t=="":
        s.append(base)
    else:
       icsaux(base+t[0],t[1:len(t)], s) 
       icsaux(base,t[1:len(t)], s)

ics('AXYT', 'AYZX')






