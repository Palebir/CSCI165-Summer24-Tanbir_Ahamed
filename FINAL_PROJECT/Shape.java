import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public abstract class Shape implements Drawable {
    protected Point2D.Double position;
    protected Color color;
    protected boolean isFilled;

    public Shape(Point2D.Double position, Color color2, boolean isFilled) {
        this.position = position;
        this.color = color2;
        this.isFilled = isFilled;
    }

    public abstract double computeDistance(Point2D.Double point);

    @Override
    public abstract void drawObject(Graphics2D g2d);
}
