public class Point3D extends Point {
    private int z;

    // No-argument constructor
    public Point3D() {
        this(0, 0, 0);
    }

    // Constructor with parameters
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    // Copy constructor
    public Point3D(Point3D other) {
        this(other.getX(), other.getY(), other.z);
    }

    // Getter for z
    public int getZ() {
        return z;
    }

    // Setter for z
    public void setZ(int z) {
        this.z = z;
    }

    // Method to set all x, y, and z
    public void setXYZ(int x, int y, int z) {
        setXY(x, y);
        this.z = z;
    }

    // Method to get x, y, and z as an array
    public int[] getXYZ() {
        return new int[]{getX(), getY(), z};
    }

    // Override toString method
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }

    // Method to calculate distance from another Point3D
    public double distance(int x, int y, int z) {
        int dx = getX() - x;
        int dy = getY() - y;
        int dz = this.z - z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    // Overloaded method to calculate distance from another Point3D
    public double distance(Point3D other) {
        return distance(other.getX(), other.getY(), other.z);
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Point3D point3D = (Point3D) obj;
        return z == point3D.z;
    }
}
