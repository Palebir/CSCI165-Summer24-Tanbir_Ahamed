package lab;

public class Square extends Rectangle implements Resizable{

    public Square(double side, Color color, boolean filled, Point location) {
        super(side, side, color, filled, location);
    }

    public Square(double side, java.awt.Color blue, boolean filled, java.awt.Point p) {
        //TODO Auto-generated constructor stub
    }

    public double getSide() {
        return getLength();
    }

    public void setSide(double side) {
        setLength(side);
        setWidth(side);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public String toString() {
        return "Square[side=" + getSide() + ", " + super.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

