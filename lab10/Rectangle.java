package lab;

public class Rectangle extends Shape implements Resizable {

    private double length;
    private double width;

    public Rectangle(double length, double width, Color color, boolean filled, Point location) {
        super();
        this.length = length;
        this.width = width;
    }

    public Rectangle(double length2, double width2, java.awt.Color red, boolean filled, java.awt.Point p) {
        //TODO Auto-generated constructor stub
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle[length=" + length + ", width=" + width + ", " + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        Rectangle rectangle = (Rectangle) obj;

        if (Double.compare(rectangle.length, length) != 0) return false;
        return Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public void resize(int percent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resize'");
    }
}

