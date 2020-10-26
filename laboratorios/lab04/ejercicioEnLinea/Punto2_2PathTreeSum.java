public class Punto2_2PathTreeSum {
    public static void main(String[] args) throws Exception {
        MyBinarySearchTree tree1 = new MyBinarySearchTree();
        tree1.insert(5);
        tree1.insert(3);
        tree1.insert(8);
        tree1.insert(2);
        tree1.insert(4);
        tree1.insert(1);
        tree1.insert(7);
        tree1.insert(9);
        tree1.insert(6);
        System.out.println("tree1: " + tree1.pathSum(22));
        tree1.graphGenerator();
    }
}