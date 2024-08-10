import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Circle extends Shape {
    private double radius;

    public Circle(Point2D.Double position, Color color, boolean isFilled, double radius) {
        super(position, color, isFilled);
        this.radius = radius;
    }

    @Override
    public double computeDistance(Point2D.Double point) {
        return point.distance(position) - radius;
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(color);
        int diameter = (int) (2 * radius);
        int x = (int) (position.x - radius);
        int y = (int) (position.y - radius);
        if (isFilled) {
            g2d.fillOval(x, y, diameter, diameter);
        } else {
            g2d.drawOval(x, y, diameter, diameter);
        }
    }
}
