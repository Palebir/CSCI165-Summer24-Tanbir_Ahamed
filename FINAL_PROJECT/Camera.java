import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;

public class Camera extends Circle implements MouseMotionListener, MouseListener {
    private double angle;

    public Camera(Point2D.Double position, double radius) {
        super(position, Color.RED, true, radius);
        this.angle = 0;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.position.x = e.getX();
        this.position.y = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Not used
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            adjustAngle(1);
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            adjustAngle(-1);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void drawObject(Graphics2D g2d) {
        super.drawObject(g2d);
    }

    public Point2D.Double computeNextPoint(double distance) {
        double x = position.x + distance * Math.cos(Math.toRadians(angle));
        double y = position.y + distance * Math.sin(Math.toRadians(angle));
        return new Point2D.Double(x, y);
    }

    public void adjustAngle(double delta) {
        this.angle += delta;
    }

    public double getAngle() {
        return angle;
    }
}
