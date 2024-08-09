package lab;

import java.awt.Color;
import java.awt.Point;

public abstract class Shape {

    protected Color color;
    protected boolean filled;
    protected Point location;

    public Shape() {}

    public Shape(Color color, boolean filled, Point location) {
        this.color = color;
        this.filled = filled;
        this.location = location;
    }

    public Shape(lab.Color color2, boolean filled2, lab.Point location2) {
        //TODO Auto-generated constructor stub
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Point getLocation() {
        return new Point(location);
    }

    public void setLocation(Point location) {
        this.location = new Point(location);
    }

    @Override
    public String toString() {
        return "Shape[color=" + color + ", filled=" + filled + ", location=" + location + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Shape shape = (Shape) obj;

        if (filled != shape.filled) return false;
        if (!color.equals(shape.color)) return false;
        return location.equals(shape.location);
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
