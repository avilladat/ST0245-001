#Importamos la libreria pandas para leer el archivo csv, en forma de Dataframe
import pandas as pd

#El variable datos se guarda el archivo csv leido por pandas
datos = pd.read_csv('0_test_balanced_5000.csv', sep=';')
#En la variable cualidad_decision quedan almacenadas aquellas columnas que son pertinentes para tomar una decision,
#eliminando de datos con el metodo .drop aquellas que no lo son
cualidad_decision = datos.drop(['estu_consecutivo.1','periodo', 'estu_inst_cod_departamento','estu_tipodocumento.1','estu_nacionalidad.1',
'estu_genero.1','periodo.1','estu_estudiante.1','estu_cod_reside_depto.1','estu_cod_reside_mcpio.1','fami_pisoshogar','fami_tienemicroondas',
'fami_tienehorno','fami_tieneautomovil.1','fami_tienedvd','fami_tiene_nevera.1','fami_telefono.1','estu_antecedentes','estu_expectativas',
'cole_codigo_icfes','cole_cod_dane_establecimiento','cole_nombre_establecimiento','cole_genero','cole_calendario','cole_cod_dane_sede',
'cole_nombre_sede','cole_cod_mcpio_ubicacion','cole_mcpio_ubicacion','cole_cod_depto_ubicacion','cole_depto_ubicacion','puntaje_prof',
'desemp_prof','exito'],axis=1)
#Se imprime cualidad_decision para verificar 
print(cualidad_decision)
