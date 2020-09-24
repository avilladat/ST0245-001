public class MyStack<T> {
    private MyNode<T> top;
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public T peek() {
        return this.top.element;
    }

    public void push(T element) {
        MyNode<T> newNode = new MyNode<T>(element);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
    }

    public T pop() {
        T deletedElement = this.top.element;
        this.top = this.top.next;
        this.size--;
        return deletedElement;
    }

    public String toString() {
        MyNode<T> auxTop = this.top;
        String text = "[" + pop() + ",";
        while (!isEmpty()) {
            text += pop() + ",";
        }
        this.top = auxTop;
        return text.substring(0, text.length() - 1) + "]";
    }
}
