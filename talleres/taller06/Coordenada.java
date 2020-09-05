

public class Coordenada {
    private Float x, y, z;

    public Coordenada(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

   public float getZ() {
        return z;
    }

    public String toString(){
        return "[" + x + "," + y + "," + z + "]";
    }
}
