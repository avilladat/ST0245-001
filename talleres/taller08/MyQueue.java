public class MyQueue<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public T peek() {
        return this.head.element;
    }

    public void add(T element) {
        MyNode<T> newNode = new MyNode<T>(element);
        if (head == null)
            this.head = newNode;
        if (tail != null)
            this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
    }

    public T remove() {
        T deletedElement = this.head.element;
        this.head = head.next;
        if (this.head == null)
            this.tail = null;
        this.size--;
        return deletedElement;
    }

    public String toString() {
        MyNode<T> auxTop = this.head;
        String text = "[" + remove() + ",";
        while (!isEmpty()) {
            text += remove() + ",";
        }
        this.head = auxTop;
        return text.substring(0, text.length() - 1) + "]";
    }
}

