/**
 * La clase requests representa las solicitudes de neveras por parte de tiendas
 * 
 * @author Alejandro Villada Toro
 * @author Cristian Alzate Urrea
 * @version 1
 */
public class Requests {
    private String name;
    private int numberFridges;

    public Requests(String name, int numberFridges) {
        this.name = name;
        this.numberFridges = numberFridges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberFridges() {
        return numberFridges;
    }

    public void setNumberFridges(int numberFridges) {
        this.numberFridges = numberFridges;
    }

    public String toString() {
        return "Name: " + name + "   Number of fridges: " + numberFridges;
    }
}
