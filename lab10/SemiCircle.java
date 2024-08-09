package lab;

public class SemiCircle extends Circle implements Resizable {

    public SemiCircle(double radius, Color color, boolean filled, Point location) {
        super(radius, color, filled, location);
    }

    @Override
    public double getArea() {
        return 0.5 * super.getArea();
    }

    @Override
    public double getPerimeter() {
        return Math.PI * getRadius() + 2 * getRadius();
    }

    @Override
    public String toString() {
        return "SemiCircle[" + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

