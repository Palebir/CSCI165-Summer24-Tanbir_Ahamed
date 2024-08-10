import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Ray {
    private List<March> marches;

    public Ray() {
        marches = new ArrayList<>();
    }

    public void addMarch(March march) {
        marches.add(march);
    }

    public void draw(Graphics2D g2d) {
        for (March march : marches) {
            march.draw(g2d);
        }
    }
}
