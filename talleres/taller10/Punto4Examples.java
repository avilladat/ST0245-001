public class Punto4Examples {
    public static void main(String[] args) throws Exception {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        tree.insert(new Name("Wilkenson", 7));
        tree.insert(new Name("Joaquina", 3));
        tree.insert(new Name("Sufranio", 10));
        tree.insert(new Name("Eustaquia", 2));
        tree.insert(new Name("Eustaquio", 4));
        tree.insert(new Name("Piolina", 9));
        tree.insert(new Name("Piolín", 11));
        tree.insert(new Name("Florinda", 1));
        tree.insert(new Name("Jovín", 6));
        tree.insert(new Name("Wilberta", 8));
        tree.insert(new Name("Usnavy", 12));
        // Si desea observar una grafica del arbol binario copie y pegue el string que
        // genera el metodo en siguiente enlace: http://www.webgraphviz.com
        tree.graphGeneratorOnlyNames();
    }
}