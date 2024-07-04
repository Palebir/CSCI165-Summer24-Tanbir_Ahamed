import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class WorldPanel extends JPanel {
    private Cell[][] matrix;
    private final int cellSize;

    public WorldPanel(Cell[][] matrix, int cellSize) {
        this.matrix = matrix;
        this.cellSize = cellSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                CellState state = matrix[i][j].getState();
                Color color;
                switch (state) {
                    case EMPTY:
                        color = Color.YELLOW;
                        break;
                    case TREE:
                        color = Color.GREEN;
                        break;
                    case BURNING:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.BLACK; 
                }
                g.setColor(color);
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

    public void setMatrix(Cell[][] matrix) {
        this.matrix = matrix;
        repaint(); 
    }
}
