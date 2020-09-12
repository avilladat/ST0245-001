public class Location {
    private double x, y, z;

    public Location(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public boolean equals(Location c) {
        if (x == c.getX() && y == c.getY() && z == c.getZ())
            return true;
        return false;
    }

    public String toString() {
        return "[" + x + "," + y + "," + z + "]";
    }
}
