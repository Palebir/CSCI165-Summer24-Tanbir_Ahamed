import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class RaymarcherPanel extends JPanel {
    private List<Shape> shapes;
    private Camera camera;

    public RaymarcherPanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);  // Set a background color to ensure the panel is visible
        shapes = new ArrayList<>();
        camera = new Camera(new Point2D.Double(400, 300), 10);
        addMouseMotionListener(camera);
        addMouseListener(camera);

        // Populate shapes
        for (int i = 0; i < 10; i++) {
            Shape shape = generateRandomShape();
            shapes.add(shape);
            System.out.println("Shape added: " + shape.getClass().getSimpleName() + " at " + shape.position);
        }

        revalidate();  
        repaint();     
    }

    private Shape generateRandomShape() {
        int type = (int) (Math.random() * 3);
        Point2D.Double position = randomPoint();
        Color color = randomColor();
        boolean isFilled = Math.random() > 0.5;
        double size = randomSize();

        switch (type) {
            case 0: // Circle
                return new Circle(position, color, isFilled, size);
            case 1: // Rectangle
                return new Rectangle(position, color, isFilled, size, size);
            case 2: // Triangle
                return new Triangle(position, color, isFilled, size, size);
            default:
                return new Circle(position, color, isFilled, size);
        }
    }

    private Point2D.Double randomPoint() {
        double x = Math.random() * getWidth();
        double y = Math.random() * getHeight();
        return new Point2D.Double(x, y);
    }

    private Color randomColor() {
        return new Color((int) (Math.random() * 0x1000000));
    }

    private double randomSize() {
        return 10 + Math.random() * 40;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        System.out.println("Painting components...");

        // Draw a simple red rectangle for debugging
        g2d.setColor(Color.RED);
        g2d.fillRect(50, 50, 100, 100);

        // Draw shapes
        for (Shape shape : shapes) {
            shape.drawObject(g2d);
            System.out.println("Drawing shape: " + shape.getClass().getSimpleName() + " at " + shape.position);
        }

        // Draw the camera
        camera.drawObject(g2d);
        System.out.println("Drawing camera at: " + camera.position);

        // Perform raymarching
        performRaymarching(g2d);
    }

    private void performRaymarching(Graphics2D g2d) {
        Ray ray = new Ray();
        Point2D.Double currentPosition = new Point2D.Double(camera.position.x, camera.position.y);

        while (true) {
            double minDistance = Double.MAX_VALUE;
            for (Shape shape : shapes) {
                double distance = shape.computeDistance(currentPosition);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }

            if (minDistance < 0.01) break;

            March march = new March(currentPosition, minDistance);
            ray.addMarch(march);
            currentPosition = march.getEndPoint();
        }

        ray.draw(g2d);
    }
}
