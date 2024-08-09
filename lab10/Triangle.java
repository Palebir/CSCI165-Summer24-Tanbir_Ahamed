package lab;

public class Triangle extends Shape implements Resizable{

    private double base;
    private double height;

    public Triangle(double base, double height, Color color, boolean filled, Point location) {
        super(color, filled, location);
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public double getPerimeter() {
        // Assuming an equilateral triangle for simplicity
        return 3 * base;
    }

    @Override
    public String toString() {
        return "Triangle[base=" + base + ", height=" + height + ", " + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        Triangle triangle = (Triangle) obj;

        if (Double.compare(triangle.base, base) != 0) return false;
        return Double.compare(triangle.height, height) == 0;
    }

    @Override
    public void resize(int percent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resize'");
    }
}

