import java.util.ArrayList;

/**
 * Almacena las notas de los estudiantes en una universidad
 *
 * @author Alejandro
 * @author Cristian
 * @version 1.0
 */

public class Base_de_datos {
    private ArrayList<Año_semestre> años_semestres;

    public Base_de_datos() {
        años_semestres = new ArrayList<Año_semestre>();
    }

    public ArrayList<Año_semestre> getAños_semestres() {
        return años_semestres;
    }

    public void setAños_semestres(ArrayList<Año_semestre> años_semestres) {
        this.años_semestres = años_semestres;
    }

    public void consultarPorCurso(String curso, String año_semestre){
        System.out.println("            " + curso);
        Año_semestre temp = buscarAñoSemestre(año_semestre); //O(n) donde n es el numero de semestres que hay registrados
        ArrayList<Estudiante> estudiantes = temp.getEstudiantes();
        for (int i = 0; i < estudiantes.size(); i++){ //O(m) donde m es el numero de estudiantes en el semestre buscado
            if (estudiantes.get(i).tieneCurso(curso)){ //O(m*z) donde z es el numero de materias que tiene el estudiante analizado en el semestre
                System.out.println(estudiantes.get(i).getNombreEstudiante() + "    " + //O(m*z) donde z es el numero de materias que tiene el estudiante analizado en el semestre
                estudiantes.get(i).imprimirNotaCurso(curso));
            }
        } // O(n + m*z)
    }

    public void consultarPorEstudiante(String estudiante, String año_semestre){
        Año_semestre temp = buscarAñoSemestre(año_semestre); //O(n) donde n es el numero de semestres que hay registrados
        ArrayList<Estudiante> estudiantes = temp.getEstudiantes();
        for (int i = 0; i < estudiantes.size(); i++){ //O(m) donde m es el numero de estudiantes en el semestre buscado
            if (estudiantes.get(i).getNombreEstudiante().equals(estudiante)){ //O(m)
                System.out.println(estudiantes.get(i)); //O(m*z) donde z es el numero de materias que tiene el estudiante buscado
                break;
            }
        } //O(n + m*z)
    }

    public Año_semestre buscarAñoSemestre(String año_semestre){
        for (int i = 0; i < años_semestres.size(); i++){
            if (años_semestres.get(i).getAño_semestre().equals(año_semestre)){//Comprueba se el año_semestre analizado es
                //equivalente al año semestre buscado
                return años_semestres.get(i);
            }
        }
        return null;
    }

    public void agregarEstudianteAlaBaseDeDatos(String año_semestre, Estudiante estudiante){
        if (buscarAñoSemestre(año_semestre) == null){
            ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
            estudiantes.add(estudiante);
            Año_semestre año_semestreTemp = new Año_semestre(año_semestre, estudiantes);
            años_semestres.add(año_semestreTemp);
        }
        else {
            for (int i = 0; i < años_semestres.size(); i++){ //O(n) donde n es el numero de semestres
                if (años_semestres.get(i).getAño_semestre().equals(año_semestre)){
                    años_semestres.get(i).agregarEstudiante(estudiante); //O(n*m) donde m son las materias del estudiante en el semestre requerido
                    break;
                }
            }
        } //O(n*m) 
    }

    public void agregarMateriaAUnEstudiante(String año_semestre, String estudiante, Materia curso){
        for (int i = 0; i < años_semestres.size(); i++){ //O(n) donde n es el numero de semestres
            if (años_semestres.get(i).getAño_semestre().equals(año_semestre)){
                for (int j = 0; j < años_semestres.get(i).getEstudiantes().size(); j++){ //O(n*m) donde m es el numero de estudiantes en el semestre
                    if (años_semestres.get(i).getEstudiantes().get(j).getNombreEstudiante().equals(estudiante)){
                        años_semestres.get(i).getEstudiantes().get(j).agregarCurso(curso);// O(n*m*z) donde z es el numero de materias que posee el alumno requerido en el semestre
                        break;
                    }
                }
                break;
            }
        } // O(n*m*z)
    }
}
