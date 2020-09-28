import java.util.ArrayList;
import java.util.HashMap;

/*
Title: Main
Author: Mauricio Toro
Date: 18/06/2020
Code Version: 1
Availability: https://github.com/mauriciotoro/ST0245-Eafit/blob/master/laboratorios/lab03/spoiler/ejercicio-1.1/java/Main.java
*/

public class Main
{
    public static void main(String [] args) {
        LectorDatos d = new LectorDatos();
        HashMap<Long, Node> nodes = d.readNodes();
        System.out.println(nodes.size());
        ArrayList<Triplet<Long, Long, Double>> edges = d.readEdges();
        System.out.println(edges.size());
        EstructuraDatos e = new EstructuraDatos(nodes, edges);
        System.out.println(e.adjGraph.size());
        System.out.println(nodes.get((long)287291920).id);
        
        Long l = (long)287291920;
        Long l2 = (long)1397149003;
        
        ArrayList<Long> test1 = e.getSuccessors(l);
        System.out.println(test1.size());
        
        for(Long i : test1) {
            System.out.println(i);
        }
        System.out.println("Distance: " + e.getWeight(l, l2));
    }
}
