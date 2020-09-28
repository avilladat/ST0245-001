import java.util.ArrayList;

/**
 * Permite almacenar los estudiantes que estuvieron en un determinado semestre y el año de dicho semestre
 *
 * @author Alejandro
 * @author Cristian
 * @version 1.0
 */

public class Año_semestre {
    private String año_semestre;
    private ArrayList<Estudiante> estudiantes;

    public Año_semestre(String año_semestre, ArrayList<Estudiante> estudiantes) {
        this.año_semestre = año_semestre;
        this.estudiantes = estudiantes;
    }

    public String getAño_semestre() {
        return año_semestre;
    }

    public void setAño_semestre(String año_semestre) {
        this.año_semestre = año_semestre;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }
}
