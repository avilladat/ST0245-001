import java.util.ArrayList;

public class Linea2D {
    private Punto pInicial;
    private Punto pFinal;

    public Linea2D(Punto pInicial, Punto pFinal) {
        this.pInicial = pInicial;
        this.pFinal = pFinal;
    }

    public Punto pi() {
        return this.pInicial;
    }

    public Punto pf() {
        return this.pFinal;
    }

    public double pendiente() {
        return (this.pInicial.y() - this.pFinal.y()) / (this.pInicial.x() - this.pFinal.x());
    }

    public ArrayList<Punto> puntos() {
        ArrayList<Punto> ps = new ArrayList<Punto>();
        if (pendiente() < -1 || pendiente() > 1) {
            if (this.pInicial.x() < this.pFinal.x()) {
                double x = this.pInicial.x();
                double y = this.pInicial.y();
                int v = (int) x;
                while (y <= this.pFinal.y()) {
                    if (v == x)
                        ps.add(new Punto(x, y));
                    else if (x > v + (0.5))
                        ps.add(new Punto(v + 1, y));
                    else if (x < v - 0.5)
                        ps.add(new Punto(v - 1, y));
                    else
                        ps.add(new Punto(v, y));
                    if(pendiente()>0)
                        y++;
                    else
                        y--;
                    x = x + (1/pendiente());
                    v = (int) x;
                }
            } else {
                double x = this.pFinal.x();
                double y = this.pFinal.y();
                int v = (int) x;
                while (y <= this.pInicial.y()) {
                    if (v == x)
                        ps.add(new Punto(x, y));
                    else if (x > v + (0.5))
                        ps.add(new Punto(v + 1, y));
                    else if (x < v - 0.5)
                        ps.add(new Punto(v - 1, y));
                    else
                        ps.add(new Punto(v, y));
                    if(pendiente()>0)
                        y++;
                    else
                        y--;
                    x = x + (1/pendiente());
                    v = (int) x;
                }
            }
        } else {
            if (this.pInicial.x() < this.pFinal.x()) {
                double x = this.pInicial.x();
                double y = this.pInicial.y();
                int v = (int) y;
                while (x <= this.pFinal.x()) {
                    if (v == y)
                        ps.add(new Punto(x, y));
                    else if (y > v + (0.5))
                        ps.add(new Punto(x, v + 1));
                    else if (y < v - (0.5))
                         ps.add(new Punto(x, v - 1));
                    else
                        ps.add(new Punto(x, v));
                    if(pendiente()>0)
                        x++;
                    else
                        x--;
                    y = y + pendiente();
                    v = (int) y;
                }
            } else {
                double x = this.pFinal.x();
                double y = this.pFinal.y();
                int v = (int) y;
                while (x <= this.pInicial.x()) {
                    if (v == y)
                        ps.add(new Punto(x, y));
                    else if (y > v + (0.5))
                        ps.add(new Punto(x, v + 1));
                    else if (y < v - (0.5))
                        ps.add(new Punto(x, v - 1));
                    else
                        ps.add(new Punto(x, v));
                    if(pendiente()>0)
                        x++;
                    else
                        x--;
                    y = y + pendiente();
                    v = (int) y;
                }
            }
        }
        return ps;
    }
}
