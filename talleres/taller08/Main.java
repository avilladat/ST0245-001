
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //String str = "6 5 - 4 +";

        //System.out.println(Punto_1.notacion_polaca(str));

        Stack<Nevera> stack = new Stack<Nevera>();
        Queue<Tienda> queue = new LinkedList<Tienda>();
        stack.push(new Nevera(1, "A"));
        stack.push(new Nevera(2, "B"));
        stack.push(new Nevera(3, "C"));
        stack.push(new Nevera(4, "D"));
        stack.push(new Nevera(5, "E"));
        stack.push(new Nevera(6, "F"));
        queue.add(new Tienda("La esquina", 3));
        queue.add(new Tienda("La otra esquina", 2));
        queue.add(new Tienda("La otra otra esquina", 1));

        Punto_2.asignar(stack, queue);
    }
}
