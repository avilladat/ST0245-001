import pandas as pd


def leerCSV(nombreArchivo):
    """Esta función se encarga de leer los datos de un un archivo CSV en forma de DataFrame y escoge los atributos pertinentes.

    :param nombreArchivo: el nombre del archivo que se leerá
    :return: el DataFrame del archivo leído
    """
    
    datos = pd.read_csv("lite.csv", sep=';')

    #Se escogen las variables que afectan el rendimiento de un estudiante y no colisionan con temas éticos
    cualidad_decision = datos[["estu_consecutivo.1", "estu_tomo_cursopreparacion", "estu_cursodocentesies", 
    "estu_simulacrotipoicfes", "estu_actividadrefuerzoareas," "fami_numlibros", 
    "punt_lenguaje", "punt_matematicas", "punt_biologia", "punt_quimica", "punt_fisica", 
    "punt_ciencias_sociales", "punt_filosofia", "punt_ingles", "exito"]]

    return cualidad_decision



def gini(dataFrame):
    """Calcula la impureza Gini en un nodo del árbol.

    :param dataFrame: el DataFrame que contiene todos los estudiantes en un nodo del árbol
    :return: la impureza de Gini en el nodo
    """

    tuvoExito = len(list(dataFrame[dataFrame["exito"] == 1]["exito"]))
    noTuvoExito = len(list(dataFrame[dataFrame["exito"] == 0]["exito"]))
    numeroEstuantes = len(dataFrame["exito"])
    impureza = 1 - ((noTuvoExito / numeroEstuantes)**2) - ((tuvoExito / numeroEstuantes)**2)
    return impureza

def giniPonderado(dataFrameIzq, dataFrameDer):
    """Calcula la impuereza de la clasificación en nodos del árbol.

    :param dataFrameIzq: el DataFrame que contiene todos los estudiantes en el nodo izquierdo
    :param dataFrameDer: el DataFrame que contiene todos los estudiantes en el nodo derecho
    :return: la impureza ponderada
    """

    estudiantesIzq = len(dataFrameIzq["exito"])
    estudiantesDer = len(dataFrameDer["exito"])
    giniIzq = gini(dataFrameIzq)
    giniDer = gini(dataFrameDer)
    impurezaPonderada = (estudiantesIzq * giniIzq + estudiantesDer * giniDer) / (estudiantesIzq + estudiantesDer)
    return impurezaPonderada


""" Prueba con un ejemplo de una presentacion del profesor

dataFrame1 = pd.DataFrame([
    [1,0],
    [0,0],
    [0,0]
], columns=("exito", "num"))

dataFrame2 = pd.DataFrame([
    [1,0],
    [1,0],
    [1,0],
    [1,0],
    [0,0]
], columns=("exito", "num"))

print(gini(dataFrame1))
print(gini(dataFrame2))

print (giniPonderado(dataFrame1, dataFrame2))
"""
