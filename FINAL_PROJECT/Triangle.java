import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;

public class Triangle extends Shape {
    private double base, height;

    public Triangle(Point2D.Double position, Color color, boolean isFilled, double base, double height) {
        super(position, color, isFilled);
        this.base = base;
        this.height = height;
    }

    @Override
    public double computeDistance(Point2D.Double point) {
        double dx = Math.max(Math.abs(point.x - position.x) - base / 2, 0);
        double dy = Math.max(Math.abs(point.y - position.y) - height / 2, 0);
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        int[] xPoints = {(int) position.x, (int) (position.x - base / 2), (int) (position.x + base / 2)};
        int[] yPoints = {(int) (position.y - height / 2), (int) (position.y + height / 2), (int) (position.y + height / 2)};
        Polygon triangle = new Polygon(xPoints, yPoints, 3);
        g2d.setColor(color);
        if (isFilled) {
            g2d.fillPolygon(triangle);
        } else {
            g2d.drawPolygon(triangle);
        }
    }
}
