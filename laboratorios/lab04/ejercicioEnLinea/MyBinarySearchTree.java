import java.util.LinkedList;

/**
 * La clase MyBinarySearchTree es una implementacion en java de un arbol de
 * busqueda binario.
 * 
 * @author Alejandro Villada Toro
 * @author Cristian Alzate Urrea
 * @version 2
 */
public class MyBinarySearchTree {
    private MyNode root;
    private int size;

    /**
     * El metodo size permite conocer el numero de nodos que tiene el arbol.
     *
     * @return el tamaño del arbol.
     */
    public int size() {
        return this.size;
    }

    private void insertAux(int data, MyNode node) {
        if (data < node.data) {
            if (node.left == null)
                node.left = new MyNode(data);
            else
                insertAux(data, node.left);
        } else {
            if (node.right == null)
                node.right = new MyNode(data);
            else
                insertAux(data, node.right);
        }
    }

    /**
     * El metodo insert permite insertar un nuevo nodo al arbol, si el arbol esta
     * vacio se insertara en la raiz del mismo.
     * 
     * @param data es el elemento que se insertara en forma de nodo.
     * @return void
     */
    public void insert(int data) {
        if (this.root == null)
            this.root = new MyNode(data);
        else
            insertAux(data, this.root);
        this.size++;
    }

    private boolean containsAux(int data, MyNode node) {
        if (data == node.data)
            return true;
        else if (data < node.data) {
            if (node.left == null)
                return false;
            else
                return containsAux(data, node.left);
        } else {
            if (node.right == null)
                return false;
            else
                return containsAux(data, node.right);
        }
    }

    /**
     * El metodo contains verifica si un elemnto dado se encuentra en el arbol.
     * 
     * @param data es el elemento que se verifica si esta en el arbol.
     * @return true si el elemento se encuentra en el arbol o false si sucede lo
     *         contrario
     * @throws Exception
     */
    public boolean contains(int data) throws Exception {
        if (this.root == null)
            throw new Exception("Missing tree");
        else
            return containsAux(data, this.root);
    }

    private void printInOrderAux(MyNode node) {
        if (node.left != null)
            printInOrderAux(node.left);
        System.out.println(node.data);
        if (node.right != null)
            printInOrderAux(node.right);
    }

    private void printPreOrderAux(MyNode node) {
        System.out.println(node.data);
        if (node.left != null)
            printPreOrderAux(node.left);
        if (node.right != null)
            printPreOrderAux(node.right);
    }

    private void printPosOrderAux(MyNode node) {
        if (node.left != null)
            printPosOrderAux(node.left);
        if (node.right != null)
            printPosOrderAux(node.right);
        System.out.println(node.data);
    }

    /**
     * Imprime el arbol inOrder.
     * 
     * @return null
     * @throws Exception
     */
    public void printInOrder() throws Exception {
        if (this.root == null)
            throw new Exception("Missing tree");
        else
            printInOrderAux(this.root);
    }

    /**
     * Imprime el arbol preOrder
     * 
     * @return null
     * @throws Exception
     */
    public void printPreOrder() throws Exception {
        if (this.root == null)
            throw new Exception("Missing tree");
        else
            printPreOrderAux(this.root);
    }

    /**
     * Imprime el arbol posorder.
     * 
     * @return null
     * @throws Exception
     */
    public void printPosOrder() throws Exception {
        if (this.root == null)
            throw new Exception("Missing tree");
        else
            printPosOrderAux(this.root);
    }

    private void graphGeneratorAux(MyNode node) {
        if (node.left != null) {
            System.out.println("\"" + node.data + "\" -> \"" + node.left.data + "\"");
            graphGeneratorAux(node.left);
        }
        if (node.right != null) {
            System.out.println("\"" + node.data + "\" -> \"" + node.right.data + "\"");
            graphGeneratorAux(node.right);
        }
    }

    /**
     * Imprime codigo que se pega en http://www.webgraphviz.com y se genera la
     * grafica del arbol.
     * 
     * @return null
     * @throws Exception
     */
    public void graphGenerator() throws Exception {
        if (this.root == null)
            throw new Exception("Missing tree");
        else
            graphGeneratorAux(this.root);
    }

    // A partir de aqui estan los metodos que permiten la solucion de el punto 2
    // del laboratorio 4

    /**
     * Imprime el arbol en posOrder a partir de una arreglo cuyos elementos son los
     * nodos del arbol recorridos en preOrder.
     * 
     * @param preOrderTree es un arreglo que contiene los elementos de un arbol
     *                     recorrido en preOrder.
     * @throws Exception
     */
    public void preOrderTreeToPosOrderTree(int[] preOrderTree) throws Exception {
        this.root = new MyNode(preOrderTree[0]);
        for (int i = 1; i < preOrderTree.length; i++)
            insert(preOrderTree[i]);
        printPosOrder();
    }

    private boolean pathSumAux(int sum, MyNode node, int target, LinkedList<Integer> paths) {
        if (node.left != null && node.right != null) {
            pathSumAux(sum + node.data, node.left, target, paths);
            pathSumAux(sum + node.data, node.right, target, paths);
        } else if (node.left != null) {
            pathSumAux(sum + node.data, node.left, target, paths);
        } else if (node.right != null) {
            pathSumAux(sum + node.data, node.right, target, paths);
        } else {
            if (sum + node.data == target)
                paths.addLast(1);
        }
        return !paths.isEmpty();
    }

    /**
     * Verifica si la suma de los elementos de alguno de los caminos de raiz a hoja
     * del arbol es igual a un entero dado
     * 
     * @param target es el entero al que debe ser igual la suma
     * @return true en caso de que en un camino o mas la suma es igual a target o
     *         false si sucede lo contrario.
     * @throws Exception
     */
    public boolean pathSum(int target){
        return pathSumAux(0, this.root, target, new LinkedList<>());
    }
}