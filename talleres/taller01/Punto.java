public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x(){
        return this.x;
    }

    public double y(){
        return this.y;
    }

    public double radio(){
        double r = Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
        return r;
    }

    public double angulo(){
        double a = Math.atan(this.y/this.x);
        return a;
    }

    public double distancia(Punto p){
        double d = Math.sqrt(Math.pow((this.x-p.x()),2)+Math.pow((this.y-p.y()),2));
        return d;
    }

    public String toString() {
        return "("+this.x+","+this.y+")";
    }    
}