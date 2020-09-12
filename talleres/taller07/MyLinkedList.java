public class MyLinkedList <T>{
    MyNode<T> init;
    private int size;

    public int size() {
        return size;
    }

    public T get(int index) throws Exception {
        if (index < 0 || index >= size || size == 0)
            throw new Exception("Index: " + index);
        else {
            MyNode<T> i = init;
            for (int j = 0; j < index; j++)
                i = i.next;
            return i.element;
        }
    }

    public void add(T element) {
        if (init == null) {
            init = new MyNode<T>(element);
            size++;
            return;
        }
        MyNode<T> i = init;
        while (i.next != null)
            i = i.next;
        i.next = new MyNode<T>(element);
        size++;
    }

    public void add(T element, int index) throws Exception {
        if (index < 0 || index > size)
            throw new Exception("Index: " + index);
        else if (index == 0 || size == 0)
            addInit(element);
        else {
            MyNode<T> i = init;
            for (int j = 0; j < index - 1; j++)
                i = i.next;
            MyNode<T> newElement = new MyNode<T>(element);
            newElement.next = i.next;
            i.next = newElement;
            size++;
        }
    }

    public void addInit(T element) {
        if (size == 0)
            init = new MyNode<T>(element);
        MyNode<T> addinit = new MyNode<T>(element);
        addinit.next = init;
        init = addinit;
        size++;
    }

    public void delIndex(int index) throws Exception {
        if (index < 0 || index > size)
            throw new Exception("Index: " + index);
        else if (index == 0) {
            init = init.next;
            size--;
        } else {
            MyNode<T> i = init;
            for (int j = 0; j < index - 1; j++)
                i = i.next;
            i.next = i.next.next;
            size--;
        }
    }

    public void delElement(T element) throws Exception {
        try {
            MyNode<T> i = init;
            for (int j = 0; j < size - 1; j++) {
                if (i.next.element == element)
                    break;
                i = i.next;
            }
            i.next = i.next.next;
            size--;
        } catch (Exception e) {
            throw new Exception("Missing element");
        }
    }

    public void replace(T element, int index) throws Exception {
        if (index < 0 || index > size)
            throw new Exception("Index: " + index);
        else if (index == 0)
            init.element = element;
        else {
            MyNode<T> i = init;
            for (int j = 0; j < index - 1; j++)
                i = i.next;
            i.next.element = element;
        }
    }

    public boolean contains(T element) {
        MyNode<T> i = init;
        while (i.next != null) {
            if (i.element.equals(element))
                return true;
            i = i.next;
        }
        if(i.element.equals(element))
            return true;
        return false;
    }

    public int indexOf(T element) throws Exception {
        MyNode<T> i = init;
        int j = 0;
        while (i.next != null) {
            if (i.element == element)
                return j;
            i = i.next;
            j++;
        }
        throw new Exception("Missing element");
    }

    public String toString() {
        if (size == 0)
            return "[ ]";
        MyNode<T> j = init;
        String text = "[" + j.element + ",";
        for (int i = 0; i < size - 1; i++) {
            text = text + j.next.element + ",";
            j = j.next;
        }
        return text.substring(0, text.length() - 1) + "]";
    }
}