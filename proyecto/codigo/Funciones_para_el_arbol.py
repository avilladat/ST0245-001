import pandas as pd
import numpy as np


def leerCSV(nombreArchivo):
    """Esta función se encarga de leer los datos de un un archivo CSV en forma de DataFrame y escoge los atributos pertinentes.

    :param nombreArchivo: el nombre del archivo que se leerá
    :return: el DataFrame del archivo leído
    """

    datos = pd.read_csv(nombreArchivo, sep=';')

    # Se escogen las variables que afectan el rendimiento de un estudiante y no colisionan con temas éticos
    cualidad_decision = datos[["fami_numlibros", "punt_lenguaje", "punt_matematicas", "punt_biologia",
                               "punt_quimica", "punt_fisica", "punt_ciencias_sociales", "punt_filosofia", "punt_ingles", "desemp_ingles", "exito"]]

    return cualidad_decision


def propiedadDeShannon(dataFrame):
    """Calcula la entropía de shannon en un nodo del árbol.

    :param dataFrame: el DataFrame que contiene todos los estudiantes en un nodo del árbol
    :return: entropía de shannon en el nodo
    """
    tuvoExito = len(list(dataFrame[dataFrame["exito"] == 1]["exito"]))
    noTuvoExito = len(list(dataFrame[dataFrame["exito"] == 0]["exito"]))
    numeroEstudiantes = len(dataFrame["exito"])

    if (tuvoExito == 0 or noTuvoExito == 0):
        return 0
    shannon = -((tuvoExito / numeroEstudiantes) * np.log2(tuvoExito / numeroEstudiantes)) - ((noTuvoExito / numeroEstudiantes) * np.log2(noTuvoExito / numeroEstudiantes))
    return shannon


def gananciaDeInformación(dataFramePadre, dataFrameIzq, dataFrameDer):
    """Calcula la ganacia de información para cierta división en un nodo del árbol.

    :param dataFramePadre: el DataFrame que contiene todos los estudiantes del nodo dividido
    :param dataFrameIzq: el DataFrame que contiene todos los estudiantes en el nodo izquierdo
    :param dataFrameDer: el DataFrame que contiene todos los estudiantes en el nodo derecho
    :return: la ganancia de información
    """
    
    numeroEstudiantesPadre = len(dataFramePadre["exito"])
    numeroEstudiantesIzq = len(dataFrameIzq["exito"])
    numeroEstudiantesDer = len(dataFrameDer["exito"])

    shannonPadre = propiedadDeShannon(dataFramePadre)
    shannonIzq = propiedadDeShannon(dataFrameIzq)
    shannonDer = propiedadDeShannon(dataFrameDer)
    ganacia = shannonPadre - (((numeroEstudiantesIzq / numeroEstudiantesPadre) * shannonIzq) +
                              ((numeroEstudiantesDer / numeroEstudiantesPadre) * shannonDer))
    return ganacia


# Prueba con un ejemplo de una presentacion del profesor
""" 
dataFrame1 = pd.DataFrame([
    [1,0],
    [1,0],
    [1,0],
    [1,0],
    [0,0],
    [0,0],
    [0,0],
    [0,0],
    [0,0]
], columns=("exito", "num"))

dataFrame2 = pd.DataFrame([
    [1,0],
    [0,0],
    [0,0],
    [0,0]
], columns=("exito", "num"))

dataFrame3 = pd.DataFrame([
    [1,0],
    [1,0],
    [1,0],
    [0,0],
    [0,0]
], columns=("exito", "num"))

print(propiedadDeShannon(dataFrame1))
print(propiedadDeShannon(dataFrame2))
print(propiedadDeShannon(dataFrame3))
print(gananciaDeInformación(dataFrame1, dataFrame2, dataFrame3))
 """
#print (giniPonderado(dataFrame1, dataFrame2))
