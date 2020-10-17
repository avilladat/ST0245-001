import java.util.ArrayList;

public class Tests {
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
        System.out.println("InOrder");
        tree.printInOrder();
        System.out.println("PreOrder");
        tree.printPreOrder();
        System.out.println("PosOrder");
        tree.printPosOrder();
        System.out.println(tree.contains(new Name("Alejandro", 2)));
        tree.graphGenerator();

        ArrayList<Integer> nn = new ArrayList<>();
        for (int i = 10; i >= 0; i--)
            nn.add(i);

    }
}