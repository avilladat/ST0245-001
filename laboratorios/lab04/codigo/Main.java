public class Main {
    public static void main(String[] args) {
        //ReaderBees rb = new ReaderBees();
        //rb.readBees("ConjuntoDeDatosCon15abejas.txt");
        //Quatree qt = new Quatree(rb);
        //qt.showBeesInCollision();
        try {
            ReaderBees rb = new ReaderBees();
            rb.readBees("ConjuntoDeDatosCon15abejas.txt");
            Quatree qt = new Quatree(rb);
            qt.showBeesInCollision();
        } catch (Exception e) {
            //System.out.println(e);
            e.printStackTrace();
        }
    }
}
