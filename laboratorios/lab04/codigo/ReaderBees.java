import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class ReaderBees {
    private LinkedList<Bee> firstQuatree = new LinkedList<>();
    private LinkedList<Bee> secondQuatree = new LinkedList<>();
    private LinkedList<Bee> thirdQuatree = new LinkedList<>();
    private LinkedList<Bee> fourthQuatree = new LinkedList<>();
    private double minLat, minLon, minAlt, maxLat, maxLon, maxAlt;
    private int size = 0;
    private final double cienMetrosEnGrados = 100 / 111325.2;

    

    public void readBees(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                insertToAQuatree(makeBee(line));
            }
        } catch (Exception e) {

        }
    }

    public void insertToAQuatree(Bee bee){
        if (bee != null){

            if (bee.getLatitud() >= -1*cienMetrosEnGrados){
                if (bee.getLongitud() >= -1*cienMetrosEnGrados){
                    firstQuatree.addLast(bee);
                }
                if (bee.getLongitud() <= cienMetrosEnGrados){
                    fourthQuatree.addLast(bee);
                }
            }
            if (bee.getLatitud() <= cienMetrosEnGrados){
                if (bee.getLongitud() >= -1*cienMetrosEnGrados){
                    secondQuatree.addLast(bee);
                }
                if(bee.getLongitud() <= cienMetrosEnGrados){
                    thirdQuatree.addLast(bee);
                }
            }

        }
    }

    public Bee makeBee(String str) {

        try {
            String[] dates = str.split(",");
            double latitud = Double.parseDouble(dates[0]);
            double longitud = Double.parseDouble(dates[1]);
            double altura = Double.parseDouble(dates[2]);

            if (size == 0) {
                minLat = latitud;
                minLon = longitud;
                minAlt = altura;
                maxLat = latitud;
                maxLon = longitud;
                maxAlt = altura;
            } else {
                if (latitud < minLat) {
                    minLat = latitud;
                }
                if (longitud < minLon) {
                    minLon = longitud;
                }
                if (altura < minAlt) {
                    minAlt = altura;
                }

                if (latitud > maxLat) {
                    maxLat = latitud;
                }
                if (longitud > maxLon) {
                    maxLon = longitud;
                }
                if (altura > maxAlt) {
                    maxAlt = altura;
                }
            }

            size++;

            return new Bee(latitud, longitud, altura);

        } catch (Exception e) {
            return null;
        }
    }

    public LinkedList<Bee> getFirstQuatree() {
        return firstQuatree;
    }

    public void setFirstQuatree(LinkedList<Bee> firstQuatree) {
        this.firstQuatree = firstQuatree;
    }

    public LinkedList<Bee> getSecondQuatree() {
        return secondQuatree;
    }

    public void setSecondQuatree(LinkedList<Bee> secondQuatree) {
        this.secondQuatree = secondQuatree;
    }

    public LinkedList<Bee> getThirdQuatree() {
        return thirdQuatree;
    }

    public void setThirdQuatree(LinkedList<Bee> thirdQuatree) {
        this.thirdQuatree = thirdQuatree;
    }

    public LinkedList<Bee> getFourthQuatree() {
        return fourthQuatree;
    }

    public void setFourthQuatree(LinkedList<Bee> fourthQuatree) {
        this.fourthQuatree = fourthQuatree;
    }

    public double getMinLat() {
        return minLat;
    }

    public void setMinLat(double minLat) {
        this.minLat = minLat;
    }

    public double getMinLon() {
        return minLon;
    }

    public void setMinLon(double minLon) {
        this.minLon = minLon;
    }

    public double getMinAlt() {
        return minAlt;
    }

    public void setMinAlt(double minAlt) {
        this.minAlt = minAlt;
    }

    public double getMaxLat() {
        return maxLat;
    }

    public void setMaxLat(double maxLat) {
        this.maxLat = maxLat;
    }

    public double getMaxLon() {
        return maxLon;
    }

    public void setMaxLon(double maxLon) {
        this.maxLon = maxLon;
    }

    public double getMaxAlt() {
        return maxAlt;
    }

    public void setMaxAlt(double maxAlt) {
        this.maxAlt = maxAlt;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
