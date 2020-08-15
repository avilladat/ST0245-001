#El siguiente método recibe la cantidad de discos de la torre, y tres caracteres que sirven para indicar
def exchange(n, a='a', b='b', c='c'):
    if n==1:
        print(a+'-->'+c)
    else:
        exchange(n-1, a, c, b)
        exchange(1, a, b, c)
        exchange(n-1, b, a, c)

print('Movimientos exactos de la  torre de Hanoi')
exchange(3)