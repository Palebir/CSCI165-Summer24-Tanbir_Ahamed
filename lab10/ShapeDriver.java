package lab;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class ShapeDriver {

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        Shape s1 = new Circle(5.5, Color.RED, false, p);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());

        Circle c1 = (Circle) s1;
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

        Shape s3 = new Rectangle(1.0, 2.0, Color.RED, false, p);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());

        Rectangle r1 = (Rectangle) s3;
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape s4 = new Square(6.6, Color.BLUE, true, p);
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getPerimeter());
        System.out.println(s4.getColor());

        Rectangle r2 = (Rectangle) s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getPerimeter());
        System.out.println(r2.getColor());

        Square sq1 = (Square) r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getPerimeter());
        System.out.println(sq1.getColor());
    }

    public static Shape findLargest(ArrayList<Shape> shapes) {
        Shape largest = shapes.get(0);
        for (Shape shape : shapes) {
            if (shape.getArea() > largest.getArea()) {
                largest = shape;
            }
        }
        return largest;
    }

    public static double totalArea(ArrayList<Shape> shapes) {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.getArea();
        }
        return total;
    }
    public static void resize(ArrayList<Resizable> resizables, int percent) {
        for (Resizable resizable : resizables) {
            System.out.println("Before resize: " + resizable);
            resizable.resize(percent);
            System.out.println("After resize: " + resizable);
        }
    }
}

