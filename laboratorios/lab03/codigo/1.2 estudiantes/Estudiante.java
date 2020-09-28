import java.util.ArrayList;

/**
 * Permite almacenar el nombre y las materias de un estudiante
 *
 * @author Alejandro
 * @author Cristian
 * @version 1.0
 */

public class Estudiante {
    private String nombreEstudiante;
    private ArrayList<Materia> cursos;

    public Estudiante(String nombreEstudiante, ArrayList<Materia> cursos) {
        this.nombreEstudiante = nombreEstudiante;
        this.cursos = cursos;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public ArrayList<Materia> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Materia> cursos) {
        this.cursos = cursos;
    }

    public void agregarCurso(Materia curso){
        cursos.add(curso);
    }

    public boolean tieneCurso(String curso){
        for (int i = 0; i < cursos.size(); i++){
            if (cursos.get(i).getNombre().equals(curso)){
                return true;
            }
        }

        return false;
    }

    public String imprimirNotaCurso(String curso){
        for (int i = 0; i < cursos.size(); i++){
            if (cursos.get(i).getNombre().equals(curso)){
                return cursos.get(i).getNota() + "";
            }
        }
        return null;
    }

    public String toString(){
        String temp = "          " + nombreEstudiante + "\n";
        for (int i = 0; i < cursos.size(); i++){
            temp += cursos.get(i).getNombre() + "    " + cursos.get(i).getNota();
        }
        
        return temp;
    }
}
