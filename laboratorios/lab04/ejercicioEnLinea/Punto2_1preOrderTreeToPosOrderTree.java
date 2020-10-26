public class Punto2_1preOrderTreeToPosOrderTree {
    public static void main(String[] args) throws Exception {
        MyBinarySearchTree tree = new MyBinarySearchTree();
        int[] preOrderTree = { 50, 30, 24, 5, 28, 45, 98, 52, 60 };
        tree.preOrderTreeToPosOrderTree(preOrderTree);
    }
}