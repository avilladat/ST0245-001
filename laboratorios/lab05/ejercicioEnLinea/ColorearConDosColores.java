import java.util.ArrayList;
import java.util.Queue;

class ColorearConDosColores {

    public static boolean bicolorable(Digraph grafo, int verticeInicial) throws Exception {
        ArrayList<Integer> listaVisitados = new ArrayList<>();
        return bicolorableAux(grafo, verticeInicial, listaVisitados, verticeInicial); // padre
    }

    private static boolean bicolorableAux(Digraph grafo, int nodo, ArrayList<Integer> listaVisitados, int padre)
            throws Exception {
        if (grafo.getSuccessors(nodo).isEmpty()) { // si el nodo no tiene más sucesores
            return true;
        }

        else if (listaVisitados.contains(nodo)) {// sino, si el nodo ya esta en la lista
            return nodosParesOImpares(nodo, listaVisitados);
        }

        ArrayList<Integer> arrayTemporal = new ArrayList<>(listaVisitados.size());
        for (int i: listaVisitados){
            arrayTemporal.add(i);
        }

        Queue<Integer> nodosHijos = grafo.getSuccessors(nodo);
        //LinkedList<Integer> listaTemporal = listaVisitados;
        //listaTemporal.add(nodo);
        arrayTemporal.add(nodo);
        for (int i : nodosHijos) {
            if (padre != i && !bicolorableAux(grafo, i, arrayTemporal, nodo)) {
                return false;
            }
        }

        return true;
    }

    public static boolean nodosParesOImpares(int nodo, ArrayList<Integer> lista) { // Corregir para empezar a contar
                                                                                    // desde el final
        boolean yaEncontroElNodo = false;
        int contador = 0;

        for (int i: lista) {
            if (i == nodo) {
                yaEncontroElNodo = true;
            }
            if (yaEncontroElNodo) {
                contador++;
            }
        }

        return contador % 2 == 0;
    }

    public static void main(String[] args) throws Exception {
        DigraphAM graphAM = new DigraphAM(14);
        
        graphAM.addArc(1, 2, 1);
        graphAM.addArc(1, 5, 1);
        graphAM.addArc(2, 3, 1);
        graphAM.addArc(3, 4, 1);
        graphAM.addArc(4, 8, 1);
        graphAM.addArc(8, 9, 1);
        graphAM.addArc(9, 10, 1);
        graphAM.addArc(10, 2, 1);
        graphAM.addArc(10, 5, 1);
        graphAM.addArc(10, 11, 1);
        graphAM.addArc(11, 12, 1);
        graphAM.addArc(12, 7, 1);
        graphAM.addArc(7, 6, 1);
        graphAM.addArc(6, 5, 1);
        graphAM.addArc(8, 12, 1);
        
        graphAM.printCodeForGraphViz();
        System.out.println(bicolorable(graphAM, 1));

        DigraphAM graphAM1 = new DigraphAM(3);
        graphAM1.addArc(0, 1, 1);
        graphAM1.addArc(1, 2, 1);
        graphAM1.addArc(2, 0, 1);

        System.out.println(bicolorable(graphAM1, 0));

        DigraphAM graphAM2 = new DigraphAM(3);
        graphAM2.addArc(0, 1, 1);
        graphAM2.addArc(1, 2, 1);

        System.out.println(bicolorable(graphAM2, 0));


        DigraphAM graphAM3 = new DigraphAM(9);
        graphAM3.addArc(0, 1, 1);
        graphAM3.addArc(0, 2, 1);
        graphAM3.addArc(0, 3, 1);
        graphAM3.addArc(0, 4, 1);
        graphAM3.addArc(0, 5, 1);
        graphAM3.addArc(0, 6, 1);
        graphAM3.addArc(0, 7, 1);
        graphAM3.addArc(0, 8, 1);

        System.out.println(bicolorable(graphAM3, 0));
    }
}