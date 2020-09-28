import java.util.*;

/*
Title: EstructuraDatos
Author: Mauricio Toro
Date: 18/06/2020
Code Version: 1
Availability: https://github.com/mauriciotoro/ST0245-Eafit/blob/master/laboratorios/lab03/spoiler/ejercicio-1.1/java/EstructuraDatos.java
*/

/**
 * Almacena la informacion del mapa de una ciudad en forma de grafos
 *
 * @author Alejandro
 * @author Cristian
 * @version 1.0
 */

public class EstructuraDatos
{
    public int size;
    public ArrayList<Triplet<Node, Node, Double>> adjGraph = new ArrayList<>();
    
    public EstructuraDatos(HashMap<Long, Node> nodes, ArrayList<Triplet<Long, Long, Double>> edges){
        size = size();
        for(Triplet<Long, Long, Double> t : edges) {
            Triplet<Node, Node, Double> tr = new Triplet<Node, Node, Double>(new Node(t.x), new Node(t.y), t.z);
            adjGraph.add(tr);
        }
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public  ArrayList<Long> getSuccessors(Long vertexID){
        ArrayList<Long> listaDeSucesores = new ArrayList<Long>();
        for (Triplet<Node, Node, Double> triplete: adjGraph){
            if (vertexID == triplete.y.id){
                listaDeSucesores.add(triplete.y.id);
            }
        }

        return listaDeSucesores;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */ 
    public Double getWeight(Long sourceID, Long destinationID){
        for (Triplet<Node, Node, Double> triplete: adjGraph){
            if ((triplete.x.id == sourceID) && (triplete.y.id == destinationID)){
                return triplete.z;
            }
        }
        return -1.0;
    }

    /**
     * Metodo que tiene la intencion de retornar el tamaño del grafo
     * @return tamaño del grafo
     */
    public int size() {
        return this.size;
    }
}
