public class Ejecutar {
    public static void main(String[] args) {
        Tabla_hash th = new Tabla_hash();
        th.put("Cristian", 987654321);
        th.put("Carlos", 123456789);

        try {
            System.out.println(th.get("Cristian"));
            System.out.println(th.get("Carlo"));
        } catch (NullPointerException n) {
            System.out.println("No se encontró la persona");
        }
    }
}
