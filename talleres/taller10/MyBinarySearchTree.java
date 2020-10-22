public class MyBinarySearchTree {
    private MyNode root;
    private int size;

    public int size() {
        return this.size;
    }

    public Name root() {
        return this.root.data;
    }

    private void insertAux(Name data, MyNode node) {
        if (data.number < node.data.number) {
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

    public void insert(Name data) {
        if (this.root == null)
            this.root = new MyNode(data);
        else
            insertAux(data, this.root);
        this.size++;
    }

    private boolean containsAux(Name data, MyNode node) {
        if (data.number == node.data.number)
            return true;
        else if (data.number < node.data.number) {
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

    public boolean contains(Name data) throws Exception {
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

    public void printInOrder() throws Exception {
        if (this.root == null)
            throw new Exception("Missing tree");
        else
            printInOrderAux(this.root);
    }

    public void printPreOrder() throws Exception {
        if (this.root == null)
            throw new Exception("Missing tree");
        else
            printPreOrderAux(this.root);
    }

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

    private void graphGeneratorOnlyNamesAux(MyNode node){
        if (node.left != null) {
            System.out.println("\"" + node.data.name + "\" -> \"" + node.left.data.name + "\"");
            graphGeneratorOnlyNamesAux(node.left);
        }
        if (node.right != null) {
            System.out.println("\"" + node.data.name + "\" -> \"" + node.right.data.name + "\"");
            graphGeneratorOnlyNamesAux(node.right);
        }    
    }

    public void graphGenerator() throws Exception {
        if (this.root == null)
            throw new Exception("Missing tree");
        else
            graphGeneratorAux(this.root);
    }

    public void graphGeneratorOnlyNames() throws Exception {
        if (this.root == null)
            throw new Exception("Missing tree");
        else
            graphGeneratorOnlyNamesAux(this.root);
    }
}
