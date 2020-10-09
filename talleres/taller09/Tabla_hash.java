import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Punto_1
 */
public class Tabla_hash {
    private class Pareja{
        String nombre;
        int numero;

        public Pareja(String nombre, int numero) {
            this.nombre = nombre;
            this.numero = numero;
        }
        
    }


    private ArrayList<LinkedList<Pareja>> tabla;

    public Tabla_hash() {
        tabla = new ArrayList<>(11);
        for (int i = 0; i < 10; i++) {
            tabla.add(new LinkedList<Pareja>());
        }
    }

    private int hash(String str){
        return ((int) str.charAt(0)) % 10;
    }

    public void put(String nombre, int numeroTelefono){
        tabla.get(hash(nombre)).add(new Pareja(nombre, numeroTelefono));
    }

    public int get(String nombre) throws NullPointerException{
        LinkedList<Pareja> temp = tabla.get(hash(nombre));
        Integer num = null;
        while(temp != null){
            if (nombre.equals(temp.peek().nombre)){
                num = temp.peek().numero;
                break;
            }
            temp.poll();
        }
        if (num == null) throw new NullPointerException();
        
        return num;
    }
}

