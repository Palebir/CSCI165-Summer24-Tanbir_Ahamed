import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Rectangle extends Shape {
    private double width, height;

    public Rectangle(Point2D.Double position, Color color, boolean isFilled, double width, double height) {
        super(position, color, isFilled);
        this.width = width;
        this.height = height;
    }

    @Override
    public double computeDistance(Point2D.Double point) {
        double dx = Math.max(Math.abs(point.x - position.x) - width / 2, 0);
        double dy = Math.max(Math.abs(point.y - position.y) - height / 2, 0);
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public void drawObject(Graphics2D g2d) {
        g2d.setColor(color);
        int x = (int) (position.x - width / 2);
        int y = (int) (position.y - height / 2);
        if (isFilled) {
            g2d.fillRect(x, y, (int) width, (int) height);
        } else {
            g2d.drawRect(x, y, (int) width, (int) height);
        }
    }
}
