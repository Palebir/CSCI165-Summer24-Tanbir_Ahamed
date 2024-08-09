package lab;

import java.awt.Color;
import java.awt.Point;

public class Circle extends Shape implements Resizable {

    private double radius;

    public Circle(double radius, java.awt.Color red, boolean filled, java.awt.Point p) {
        super();
        this.radius = radius;
    }

    public Circle(double radius2, lab.Color color, boolean filled, lab.Point location) {
        //TODO Auto-generated constructor stub
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", " + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;

        Circle circle = (Circle) obj;

        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public void resize(int percent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resize'");
    }
}
