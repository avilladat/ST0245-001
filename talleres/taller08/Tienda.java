public class Tienda {
    private String nombre;
    private int cantidadNeveras;

    public Tienda(String nombre, int cantidadNeveras){
        this.nombre = nombre;
        this.cantidadNeveras = cantidadNeveras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadNeveras() {
        return cantidadNeveras;
    }

    public void setCantidadNeveras(int cantidadNeveras) {
        this.cantidadNeveras = cantidadNeveras;
    }

    public String toString(){
        return "Nombre: " + nombre + "    Cantidad de neveras: " + cantidadNeveras;
    }
}
