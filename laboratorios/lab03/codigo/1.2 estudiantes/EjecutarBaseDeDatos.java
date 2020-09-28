import java.util.ArrayList;

/**
 * Ejecuta y se hacen pruebas de la clase Base_de_datos.java
 *
 * @author Alejandro
 * @author Cristian
 * @version 1.0
 */

public class EjecutarBaseDeDatos {
    public static void main(String[] args) {
        Base_de_datos b_datos = new Base_de_datos();
        ArrayList<Materia> materias = new ArrayList<Materia>();
        materias.add(new Materia("Estructura, datos y algoritmos", 5));
        Estudiante estudiante = new Estudiante("Cristian", materias);
        b_datos.agregarEstudianteAlaBaseDeDatos("2020-2", estudiante);
        b_datos.consultarPorEstudiante("Cristian", "2020-2");
        b_datos.consultarPorCurso("Estructura, datos y algoritmos", "2020-2");
    }
}
