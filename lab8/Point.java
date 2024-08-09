public class Point {
    private int x;
    private int y;

    // No-argument constructor
    public Point() {
        this(0, 0);
    }

    // Overloaded constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Copy constructor
    public Point(Point other) {
        this(other.x, other.y);
    }

    // Getter for x
    public int getX() {
        return x;
    }

    // Setter for x
    public void setX(int x) {
        this.x = x;
    }

    // Getter for y
    public int getY() {
        return y;
    }

    // Setter for y
    public void setY(int y) {
        this.y = y;
    }

    // Method to set both x and y
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Method to get x and y as an array
    public int[] getXY() {
        return new int[]{x, y};
    }

    // Override toString method
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Method to calculate distance from another point (x, y)
    public double distance(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Overloaded method to calculate distance from another Point
    public double distance(Point other) {
        return distance(other.x, other.y);
    }

    // Overloaded method to calculate distance from origin (0,0)
    public double distance() {
        return distance(0, 0);
    }

    // Static method to calculate distance between two Points
    public static double distance(Point a, Point b) {
        return a.distance(b);
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }
}
