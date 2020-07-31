public class Punto3D {
    private double x;
    private double y;
    private double z;

    public Punto3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public double radio() {
        double r = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
        return r;
    }

    public double anguloPolar() {
        return Math.acos(this.z / radio());
    }

    public double anguloAcimut() {
        return Math.atan2(this.y, this.x);
    }

    public double distancia(Punto3D p) {
        return Math.sqrt(Math.pow((this.x - p.x()), 2) + Math.pow((this.y - p.y()), 2) + Math.pow((this.z - p.z()), 2));
    }
}