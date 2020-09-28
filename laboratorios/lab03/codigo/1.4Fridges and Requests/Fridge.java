/**
 * La clase Fidge representa las neveras tiendas que seran solicitadas-
 *   
 * @author Alejandro Villada Toro
 * @author Cristian Alzate Urrea
 * @version 1
 */
public class Fridge {
    private int code;
    private String description;

    public Fridge(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Code: " + code + " Description: " + description;
    }
}