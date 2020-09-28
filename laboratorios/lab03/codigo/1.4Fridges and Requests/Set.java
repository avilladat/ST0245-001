import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Set {
    /**
     * El metodo assigned simula la asignacion de neveras a solicitudes.
     * 
     * @param stack una pila de neveras.
     * @param queue una cola de solicitudes
     * @return void
     */
    public static void assigned(Stack<Fridge> stack, Queue<Requests> queue) {
        while (!stack.isEmpty() && !queue.isEmpty()) {
            int numberFridges = queue.peek().getNumberFridges();
            for (int i = 0; i < numberFridges; i++) {
                if (stack.isEmpty()) {
                    System.out.println("There's no fridges for more requests");
                    break;
                }
                System.out.println("At request from " + queue.peek().getName() + " was assigned:  " + stack.pop());
            }

            queue.poll();
        }
    }

    public static void main(String[] args) {
        Stack<Fridge> stack = new Stack<Fridge>();
        Queue<Requests> queue = new LinkedList<Requests>();
        stack.push(new Fridge(1, "A"));
        stack.push(new Fridge(2, "B"));
        stack.push(new Fridge(3, "C"));
        stack.push(new Fridge(4, "D"));
        stack.push(new Fridge(5, "E"));
        stack.push(new Fridge(6, "F"));
        stack.push(new Fridge(7, "G"));
        queue.add(new Requests("Fridges and more", 3));
        queue.add(new Requests("ElectroFridges", 2));
        queue.add(new Requests("Glaciar", 1));
        queue.add(new Requests("Mabe", 4));
        assigned(stack, queue);
    }
}