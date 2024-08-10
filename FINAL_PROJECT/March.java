import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class March {
    private Point2D.Double startPoint;
    private double length;
    private Point2D.Double endPoint;

    public March(Point2D.Double startPoint, double length) {
        this.startPoint = startPoint;
        this.length = length;
        this.endPoint = new Point2D.Double(startPoint.x + length, startPoint.y);
    }

    public Point2D.Double getEndPoint() {
        return endPoint;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        g2d.drawLine((int) startPoint.x, (int) startPoint.y, (int) endPoint.x, (int) endPoint.y);
        g2d.drawOval((int) endPoint.x - 5, (int) endPoint.y - 5, 10, 10);
        System.out.println("Drawing march from " + startPoint.x + ", " + startPoint.y + " to " + endPoint.x + ", " + endPoint.y);
    }
}
