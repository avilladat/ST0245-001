public class Punto_4 {
    public static void main(String[] args) {
        MyQueue<String> customers = new MyQueue<>();
        customers.add("Juan");
        customers.add("María");
        customers.add("Pedro");
        while (!customers.isEmpty())
            System.out.println("Atendiendo a " + customers.remove());
    }
}
