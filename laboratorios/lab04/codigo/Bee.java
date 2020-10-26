/**
 * Bee
 */
public class Bee {
    private double latitud;
    private double longitud;
    private double altura;

    public Bee(double latitud, double longitud, double altura) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.altura = altura;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}

