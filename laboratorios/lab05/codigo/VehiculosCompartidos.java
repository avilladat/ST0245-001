import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementacion de un algoritmo para asignar vehiculos compartidos Estructura
 * de datos utilizada: Grafo con Matrices de Adyacencia Complejidad: Peor Caso y
 * Mejor Caso O(n*n)
 *
 * @author Mauricio Toro
 * @version 1
 */
public class VehiculosCompartidos {
    /**
     * Metodo para leer un archivo con los duenos de vehiculos y la empresa
     * Complejidad: Mejor y peor caso es O(n*n), donde n es son los duenos de
     * vehiculos y la empresa
     *
     * @param numeroDePuntos El numero de puntos es 1 de la empresa y n-1 de los
     *                       duenos de vehiculos
     * @return un grafo completo con la distancia mas corta entre todos los vertices
     */
    public static DigraphAM leerArchivo(int numeroDePuntos, float p) {
        final String nombreDelArchivo = "dataset-ejemplo-U=" + numeroDePuntos + "-p=" + p + ".txt";
        DigraphAM grafo = new DigraphAM(numeroDePuntos + 1);
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            for (int i = 1; i <= 4; i++) // Descarta las primeras 3 lineas
                lineaActual = br.readLine();
            lineaActual = br.readLine();
            for (int i = 1; i <= numeroDePuntos; i++) { // Descarta los nombres y coordenadas de los vertices
                lineaActual = br.readLine();
            }
            for (int i = 1; i <= 3; i++) // Descarta las siguientes 3 lineas
                lineaActual = br.readLine();
            while (lineaActual != null) { // Mientras no llegue al fin del archivo. Lee la informacion de las aristas
                String[] cadenaParticionada = lineaActual.split(" ");
                grafo.addArc(Integer.parseInt(cadenaParticionada[0]) - 1, Integer.parseInt(cadenaParticionada[1]) - 1,
                        Integer.parseInt(cadenaParticionada[2]));
                lineaActual = br.readLine();
            }
            br.close();
        } catch (Exception ioe) {
            System.out.println("Error leyendo el archivo de entrada: " + ioe.getMessage());
        }

        return grafo;
    }

    public static int elMasLejano(Graph grafo, double limite) throws Exception { // O(n)
        int maslejano = Integer.MIN_VALUE;
        int nodo = 0;
        Queue<Integer> hijos = grafo.getSuccessors(0);
        while (!hijos.isEmpty()) {
            int hijo = hijos.poll();
            if (grafo.getWeight(0, hijo) >= limite)
                continue;
            if (maslejano < grafo.getWeight(0, hijo)) {
                maslejano = grafo.getWeight(0, hijo);
                nodo = hijo;
            }
        }
        return nodo;
    }

    public static LinkedList<Integer> organizarDistancias(Graph grafo) throws Exception { // O(n^2)
        LinkedList<Integer> grafoOrganizado = new LinkedList<>();
        int elMasLejano = elMasLejano(grafo, Double.POSITIVE_INFINITY);
        grafoOrganizado.add(elMasLejano);
        for (int hijos = grafo.getSuccessors(0).size(); hijos > 1; hijos--) {
            elMasLejano = elMasLejano(grafo, grafo.getWeight(0, elMasLejano));
            grafoOrganizado.add(elMasLejano);
        }
        return grafoOrganizado;
    }

    public static void permutaciones(Graph grafo, int nodoMasLejano, LinkedList<Integer> permutacion,
            LinkedList<LinkedList<Integer>> permutaciones, int padre, float tiempo, float tiempoLimite)
            throws Exception {
        if (nodoMasLejano == 0 && tiempo <= tiempoLimite)
            permutaciones.add(permutacion);
        else if (permutacion.size() == 5) {
            if (tiempo + grafo.getWeight(permutacion.getLast(), 0) <= tiempoLimite)
                permutaciones.add(permutacion);
        } else if (tiempo > tiempoLimite) {
            // Siguelo intentando no pierdas tu determinacion
        } else {
            permutacion.add(nodoMasLejano);
            Queue<Integer> hijos = grafo.getSuccessors(nodoMasLejano);
            while (!hijos.isEmpty()) {
                LinkedList<Integer> tempList = new LinkedList<>();
                for (int i : permutacion) {
                    tempList.add(i);
                }
                int temporal = hijos.poll();
                if (temporal == padre)
                    continue;
                permutaciones(grafo, temporal, tempList, permutaciones, nodoMasLejano,
                        tiempo + grafo.getWeight(nodoMasLejano, temporal), tiempoLimite);
            }
        }
    }

    public static LinkedList<Integer> laPermutacionMasLarga(LinkedList<LinkedList<Integer>> permutaciones,
            LinkedList<Integer> visitados) { // O(n^3)
        LinkedList<Integer> permutacionMasLarga = new LinkedList<>();
        for (LinkedList<Integer> permutacion : permutaciones) {
            boolean visitado = false;
            for (int nodo : visitados) {
                if (permutacion.contains(nodo)) {
                    visitado = true;
                    break;
                }
            }
            if (visitado == true)
                continue;
            permutacionMasLarga = permutacion.size() > permutacionMasLarga.size() ? permutacion : permutacionMasLarga;
        }
        return permutacionMasLarga;
    }

    /**
     * Algoritmo para asignar vehiculos compartidos Complejidad: ???, donde n son
     * los duenos de vehiculos y la empresa
     *
     * @param grafo Un grafo que puede estar implementado con matrices o con listas
     *              de adyacencia
     * @return una lista de listas con la permutacion para cada subconjunto de la
     *         particion de duenos de vehiculo
     */
    public static LinkedList<LinkedList<Integer>> asignarVehiculos(Graph grafo, float p) throws Exception {
        LinkedList<LinkedList<Integer>> caminos = new LinkedList<>();
        LinkedList<Integer> grafoOrganizado = organizarDistancias(grafo), visitados = new LinkedList<>();
        while (!grafoOrganizado.isEmpty()) {
            int nodo = grafoOrganizado.poll();
            if (visitados.contains(nodo))
                continue;
            LinkedList<LinkedList<Integer>> permutaciones = new LinkedList<>();
            LinkedList<Integer> permutacion = new LinkedList<>();
            permutaciones(grafo, nodo, permutacion, permutaciones, nodo, 0, grafo.getWeight(nodo, 0) * p);
            LinkedList<Integer> laPermutacionMasLarga = laPermutacionMasLarga(permutaciones, visitados);
            caminos.add(laPermutacionMasLarga);
            for (int i : laPermutacionMasLarga)
                visitados.add(i);
        }
        return caminos;
    }

    /**
     * Metodo para escribir un archivo con la respuesta Complejidad: Mejor y peor
     * caso es O(n), donde n son los duenos de vehiculo y la empresa
     *
     * @param permutacionParaCadaSubconjunto es una lista de listas con la
     *                                       permutacion para cada subconjunto de la
     *                                       particion de duenos de vehiculo
     */
    public static void guardarArchivo(LinkedList<LinkedList<Integer>> permutacionParaCadaSubconjunto,
            int numeroDePuntos, float p) {
        final String nombreDelArchivo = "respuesta-ejemplo-U=" + numeroDePuntos + "-p=" + p + ".txt";
        try {
            PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
            for (LinkedList<Integer> lista : permutacionParaCadaSubconjunto) {
                for (Integer duenoDeVehiculo : lista)
                    escritor.print(duenoDeVehiculo + " ");
                escritor.println();
            }
            escritor.close();
        } catch (IOException ioe) {
            System.out.println("Error escribiendo el archivo de salida " + ioe.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        /*
         * // Recibir el numero de duenos de vehiculo y la empresa, y el valor de p por
         * el // main final int numeroDePuntos = args.length == 0 ? 205 :
         * Integer.parseInt(args[0]); final float p = args.length < 2 ? 1.3f :
         * Float.parseFloat(args[1]); // Leer el archivo con las distancias entre los
         * duenos de los vehiculos y la // empresa DigraphAM grafo =
         * leerArchivo(numeroDePuntos, p); // Asignar los vehiculos compartidos long
         * startTime = System.currentTimeMillis(); LinkedList<LinkedList<Integer>>
         * permutacionParaCadaSubconjunto = asignarVehiculos(grafo, p); long
         * estimatedTime = System.currentTimeMillis() - startTime;
         * System.out.println("El algoritmo tomo un tiempo de: " + estimatedTime +
         * " ms"); // Guardar en un archivo
         * guardarArchivo(permutacionParaCadaSubconjunto, numeroDePuntos, p);
         */
        float p = (float) 1.2;
        int numero = 4;
        DigraphAM grafo = leerArchivo(numero, p);
        // grafo.printCodeForGraphViz();
        /*
         * LinkedList<LinkedList<Integer>> l = new LinkedList<>(); LinkedList<Integer>
         * l1 = new LinkedList<>();// organizarDistancias(grafo); permutaciones(grafo,
         * 3, l1, l, 3, 0, grafo.getWeight(3, 0) * p); System.out.println(l);
         * System.out.println("1" + organizarDistancias(grafo));
         * System.out.println(laPermutacionMasLarga(l));
         */

        System.out.println(asignarVehiculos(grafo, (float)1.7));
    }
}