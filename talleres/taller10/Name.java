public class Name {
    String name;
    int number;

    public Name(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return "" + this.name + " #(" + this.number + ")";
    }
}