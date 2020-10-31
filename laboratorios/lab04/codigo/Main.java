public class Main {
    public static void main(String[] args) {
        try {
            Reader r = new Reader();
            //r.leer("ConjuntoDeDatosCon15abejas.txt");
            r.leer("ConjuntoDeDatosCon15abejas.txt");
            r.choque();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}
