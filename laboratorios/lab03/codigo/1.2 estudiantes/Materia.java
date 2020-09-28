
/**
 * Contiene el nombre de una materia y respectiva nota
 *
 * @author Alejandro
 * @author Cristian
 * @version 1.0
 */

public class Materia{
    private String nombreMateria;
    private int nota;

    public Materia(String nombreMateria, int nota){
        this.nombreMateria = nombreMateria;
        this.nota = nota;
    }

    public String getNombre() {
        return nombreMateria;
    }

    public void setNombre(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}