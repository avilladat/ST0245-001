import Funciones_para_el_arbol as funciones
import Arbol
import time


def obtener_Posibles_Valores_Para_Cada_Atributo(datos, atributos):
    """Calcula los posibles valores que puede tomar cada variable.

    :param datos: el DataFrame que contiene todos datos a evaluar
    :param atributos: arreglo que contiene todos los atributos
    :return: arreglo de conjuntos con los posibles valores de cada atributo
    """
    posiblesValores = []
    for i in range(len(atributos)):
        columnaAtributo = datos.iloc[:, i] 
        posiblesValores.append(set(columnaAtributo))

    return posiblesValores

def obtener_Posibles_Valores_Para_Un_Atributo(datos, atributo):
    """Calcula los posibles valores que puede tomar uns variable.

    :param datos: el DataFrame que contiene todos datos a evaluar
    :param atributo: atributo que se quiere evaluar
    :return: conjunto con los posibles valores del atributo
    """
    columnaAtributo = datos.dropna()
    columnaAtributo = columnaAtributo[atributo]
    posiblesValores = (set(columnaAtributo))

    return posiblesValores


def esNumerico(posiblesValoresDelAtributo):
    """Define si los posibles valores de un atributo son numericos.

    :param posiblesValoresDelAtributo: un conjunto con los posibles valores que puede tomar un atributo
    :return: retorna True si son numericos y False de lo contrario
    """
    try:
        for v in posiblesValoresDelAtributo:
            c = int(v)
        return True
    except ValueError as error:
        return False


def encontrarMejorCondicionDeUnAtributo(datos, atributo, posiblesValoresDelAtributo):
    """Selecciona la mejor condicion para dividir en un atributp.

    :param datos: el DataFrame que contiene todos datos a evaluar
    :param atributo: atributo que se quiere evaluar
    :param posiblesValoresDelAtributo: todos los valores que puede tomar un atributo
    :return: conjunto con los posibles valores del atributo
    """
    if (esNumerico(posiblesValoresDelAtributo)):
        #ganancia = [ganancia, valorDeLaCondicion, atributo, condicion, indice]
        ganancia = [-1,-1,-1, ">=", -1]
        ganancia[0] = -1
        datos = datos.sort_values(by=[atributo])
        valores = list(datos[atributo])
        for i in range(len(valores) - 1):
            if (i != 0 and valores[i] == valores[i - 1]):
                continue
            else:
                gananciaTemp = funciones.gananciaDeInformación(datos, datos.iloc[0:i], datos.iloc[i:])
                if (gananciaTemp > ganancia[0]):
                    ganancia[0] = gananciaTemp
                    ganancia[1] = valores[i]
                    ganancia[4] = i

        ganancia[2] = atributo

        return ganancia

    else:
        #ganancia = [ganancia, valorDeLaCondicion, atributo, condicion]
        ganancia = [-1.0,0, atributo, "=="]
        for i in posiblesValoresDelAtributo:
            gananciaTemp = funciones.gananciaDeInformación(datos, 
            datos.drop(datos[datos[atributo] != i].index), datos.drop(datos[datos[atributo] == i].index))
            if (gananciaTemp > ganancia[0]):
                    ganancia[0] = gananciaTemp
                    ganancia[1] = i


        return ganancia


def encontrarMejorCondicionEntreLosAtributos(datos, atributos):
    """Selecciona el mejor atributo para dividir y la respectiva division de ese atributo.

    :param datos: el DataFrame que contiene todos datos a evaluar
    :param atributos: atributo que se quiere evaluar
    :param posiblesValoresDelAtributo: todos los valores que puede tomar un atributo
    :return: conjunto con los posibles valores del un arreglo con los parametros que se quieren
    """
    mejoresCondicionesParaCadaAtributo = []
    for atributo in atributos:
        posiblesValoresDelAtributo = obtener_Posibles_Valores_Para_Un_Atributo(datos, atributo)
        mejoresCondicionesParaCadaAtributo.append(encontrarMejorCondicionDeUnAtributo(datos, atributo, posiblesValoresDelAtributo))

    maximaGanancia = [-1,-1, "materia", "condicion", "indice"]
    for mejorCondicion in mejoresCondicionesParaCadaAtributo:
        if (mejorCondicion[0] > maximaGanancia[0]):
            maximaGanancia = mejorCondicion
    
    #mejorCondicion = [ganancia, valorDeLaCondicion, atributo, condicion]
    #mejorCondicion = [ganancia, valorDeLaCondicion, atributo, condicion, indice]

    posiblesValoresDelAtributo = obtener_Posibles_Valores_Para_Un_Atributo(datos, maximaGanancia[2])
    if (esNumerico(posiblesValoresDelAtributo)):
        datosDer = datos.iloc[0 : maximaGanancia[4]]
        datosIzq = datos.iloc[maximaGanancia[4]:]
    else:
        maximaGanancia.append(1)
        datosIzq = datos.drop(datos[datos[atributo] != mejorCondicion[2]].index)
        datosDer = datos.drop(datos[datos[atributo] == mejorCondicion[2]].index)
    
    maximaGanancia.append(datosIzq)
    maximaGanancia.append(datosDer)
    return maximaGanancia
    

def crearArbol(nombreArchivo):
    """Esta funcion se encarga de llamar los metodos necesarios para generar el arbol.

    :return: None
    """
    datos = funciones.leerCSV(nombreArchivo)
    atributos = datos.columns
    atributos = atributos.drop("exito")
    mejorDecision = encontrarMejorCondicionEntreLosAtributos(datos, atributos)

    arbol = Arbol.Nodo(mejorDecision[2], mejorDecision[1], mejorDecision[3])

    atributos = atributos.drop(mejorDecision[2])
    datosIzq = mejorDecision[5]
    datosDer = mejorDecision[6]

    crearArbolAux(datosIzq, datosDer, arbol, atributos, "mitad")
    
    escribirArbol(arbol)
    return arbol


def crearArbolAux(datosIzq, datosDer, arbol, atributos, lado):
    """Se encarga de hacer la recursion necesaria para generar el arbol.

    :param datosIzq: el DataFrame que contiene todos datos en la izquierda resultantes de la division
    :param datosDer: el DataFrame que contiene todos datos en la derecha resultantes de la division
    :param arbol: arbol en donde se van a almacenar las condiciones
    :param atributos: atributos que se quieren evaluar
    :param lado: indicacion en forma de cadena que indica si la recursion continuo por la izquierda o por la derecha
    :return: None
    """
    propiedadShannonIzq = funciones.propiedadDeShannon(datosIzq)
    propiedadShannonDer = funciones.propiedadDeShannon(datosDer)
    if ((propiedadShannonIzq == 0 and propiedadShannonDer == 0) or (len(datosIzq) <= 100 and (len(datosDer) <= 100))):
        #print("Entro1")
        if (lado == "izquierda"):
            arbol.prediccion = "return True"
        elif (lado == "derecha"):
            arbol.prediccion = "return False"
    elif(len(atributos) < 1):
        #print("Entro2")
        if (lado == "izquierda"):
            arbol.prediccion = "return True"
        elif (lado == "derecha"):
            arbol.prediccion = "return False"
    elif (propiedadShannonDer == 0 and len(datosIzq) >= 100):
        mejorDecision = encontrarMejorCondicionEntreLosAtributos(datosIzq, atributos)
        arbol.nodoIzquierdo = Arbol.Nodo(mejorDecision[2], mejorDecision[1], mejorDecision[3])
        datosIzqTemp = mejorDecision[5]
        datosDerTemp = mejorDecision[6]
        atributos = atributos.drop(mejorDecision[2])
        crearArbolAux(datosIzqTemp, datosDerTemp, arbol.nodoIzquierdo, atributos, "izquierda")
    elif (propiedadShannonIzq == 0 and len(datosDer) >= 100):
        mejorDecision = encontrarMejorCondicionEntreLosAtributos(datosDer, atributos)
        arbol.nodoDerecho = Arbol.Nodo(mejorDecision[2], mejorDecision[1], mejorDecision[3])
        datosIzqTemp = mejorDecision[5]
        datosDerTemp = mejorDecision[6]
        atributos = atributos.drop(mejorDecision[2])
        crearArbolAux(datosIzqTemp, datosDerTemp, arbol.nodoDerecho, atributos, "derecha")

    elif (len(datosIzq) >= 100 or len(datosDer) >= 100):
        if (len(datosIzq) >= 100):
            mejorDecision = encontrarMejorCondicionEntreLosAtributos(datosIzq, atributos)
            arbol.nodoIzquierdo = Arbol.Nodo(mejorDecision[2], mejorDecision[1], mejorDecision[3])
            datosIzqPrimero = mejorDecision[5]
            datosDerPrimero = mejorDecision[6]
            atributos1 = atributos.drop(mejorDecision[2])
            crearArbolAux(datosIzqPrimero, datosDerPrimero, arbol.nodoIzquierdo, atributos1, "izquierda")
        else:
            arbol.nodoIzquierdo = Arbol.Nodo("", 0, "")
            if (lado == "izquierda"):
                arbol.nodoIzquierdo.prediccion = "return True"
            elif (lado == "derecha"):
                arbol.nodoIzquierdo.prediccion = "return False"

        if (len(datosDer) >= 100):
            mejorDecision2 = encontrarMejorCondicionEntreLosAtributos(datosDer, atributos)
            arbol.nodoDerecho = Arbol.Nodo(mejorDecision2[2], mejorDecision2[1], mejorDecision2[3])
            datosIzqSegundo = mejorDecision2[5]
            datosDerSegundo = mejorDecision2[6]
            atributos2 = atributos.drop(mejorDecision2[2])
            crearArbolAux(datosIzqSegundo, datosDerSegundo, arbol.nodoDerecho, atributos2, "derecha")
        else:
            arbol.nodoDerecho = Arbol.Nodo("", 0, "")
            if (lado == "izquierda"):
                arbol.nodoDerecho.prediccion = "return True"
            elif (lado == "derecha"):
                arbol.nodoDerecho.prediccion = "return False"
    

def escribirArbol(arbol):
    """Se encarga escribir el código resultante de construir el árbol, para poder predecir el resultado de los estudiantes.

    :param arbol: el que contiene las condiciones para predecir los estudiantes
    :return: None
    """
    archivo = open("Predecir.py", "w")
    archivo.write("def predecir(dataset): \n")
    escribirArbolAux(arbol, archivo, "   ")
    archivo.close()

def escribirArbolAux(arbol, archivo, espacio):
    """Se encarga de hacer la recursion necesaria para escribir el arbol.

    :param arbol: el que contiene las condiciones para predecir los estudiantes
    :param archivo: el archivo en donde se van a escribir las condiciones
    :param espacio: cadena en donde se van agregando los espacios requeridos por la indentación de Python
    :return: None
    """
    if (arbol.nodoIzquierdo == None and arbol.nodoDerecho == None):
        archivo.write(espacio + arbol.prediccion + "\n")
    elif(arbol.nodoDerecho == None):
        nuevoEspacio = "   " + espacio
        #if (list(dataset["punt_ingles"])[0]>=51.0):
        archivo.write(espacio + "if" + "(list(dataset[" + "\"" + arbol.atributo + "\"])[0]" + arbol.tipoDeCondicion + str(arbol.limite)  + "):\n")
        escribirArbolAux(arbol.nodoIzquierdo, archivo, nuevoEspacio)

        archivo.write(espacio + "else: \n")
        archivo.write(espacio + "   " + "return False" + "\n")
    elif(arbol.nodoIzquierdo == None):
        #nuevoEspacio = "   " + espacio
        #archivo.write(espacio + "else: \n")
        escribirArbolAux(arbol.nodoDerecho, archivo, espacio)
    else:
        nuevoEspacio =  "   " + espacio
        archivo.write(espacio + "if" + "(list(dataset[" + "\"" + arbol.atributo + "\"])[0]" + arbol.tipoDeCondicion + str(arbol.limite)  + "):\n")
        escribirArbolAux(arbol.nodoIzquierdo, archivo, nuevoEspacio)

        archivo.write(espacio + "else: \n")
        escribirArbolAux(arbol.nodoDerecho, archivo, nuevoEspacio)


def predecir(dataFrame):
    import Predecir
    for i in range(len(dataFrame)):
        estudiante = dataFrame.iloc[0 : 1]
        print(Predecir.predecir(estudiante))
        dataFrame = dataFrame.drop([i])

def predecirYCalcularError(dataFrame):
    import Predecir
    buenos = 0
    total = 0
    numeroTrues = 0
    numeroFalses = 0
    for i in range(len(dataFrame)):
        estudiante = dataFrame.iloc[0 : 1]
        descicion = Predecir.predecir(estudiante)
        #print(descicion)
        if ((descicion == True and list(estudiante["exito"])[0] == 1) or (descicion == False and list(estudiante["exito"])[0] == 0)):
            buenos += 1
        if (descicion == True):
            numeroTrues += 1
        else:
            numeroFalses += 1
        total += 1
        dataFrame = dataFrame.drop([i])
    print("Numero de predicciones correctas: ", buenos)
    print("Porcentaje de acierto: ", buenos/total)
    print("Numero de True: ", numeroTrues)
    print("Numero de False: ", numeroFalses)
    
    
def alturaArbolAux(arbol): #//2T(n/2) siendo n numero de nodos
    if(arbol == None):
        return 0
    else:
        return max(alturaArbolAux(arbol.nodoIzquierdo),alturaArbolAux(arbol.nodoDerecho))+1

def alturaArbol(arbol):
    return alturaArbolAux(arbol)



""" datos = funciones.leerCSV("lite.csv")
atributos = datos.columns
atributos = atributos.drop("exito")
datos = datos.drop(datos[datos["fami_numlibros"] == "26 A 100 LIBROS"].index)
print(datos)
 """



tiempoInicial = time.time()
nodo = crearArbol("0_train_balanced_15000.csv")
tiempoFinal = time.time()
print(tiempoFinal - tiempoInicial)
print("Funcionó!!!!!!!!!!!")


datos = funciones.leerCSV("0_train_balanced_15000.csv")
predecirYCalcularError(datos)

print()
print(alturaArbol(nodo))

""" if(list(estudiante["punt_ingles"])[0]>=51.0):
    print(list(datos["punt_ingles"])[0])
    print("Si")
if(list(datos["punt_ciencias_sociales"])[0]>=50.0):
    print(list(datos["punt_ciencias_sociales"])[0])
    print("Si") """

""" 
posiblesValores = obtener_Posibles_Valores_Para_Un_Atributo(datos, "punt_lenguaje")
valores = list(datos["punt_lenguaje"])
ganancia = encontrarMejorCondicionDeUnAtributo(datos, "punt_lenguaje", posiblesValores)
print(ganancia[0])
print(ganancia[1])
 """

