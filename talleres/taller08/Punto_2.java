import java.util.Stack;
import java.util.Queue;

public class Punto_2 {
    public static void asignar(Stack<Nevera> stack, Queue<Tienda> queue){
        while (!stack.isEmpty() && !queue.isEmpty()){
            int n = queue.peek().getCantidadNeveras();
            for (int i = 0; i < n; i++){
                System.out.println("A la tienda    " + queue.peek().getNombre() +
                 "   se le asigno la nevera:  " + stack.pop());
            }
            queue.poll();
        }
    }
}
