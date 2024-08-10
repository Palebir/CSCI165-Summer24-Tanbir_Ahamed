import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;

public class World extends JPanel {
    private int gridSize;
    private Cell[][] grid;
    private double probCatch;

    public World(int gridSize, double probCatch) {
        this.gridSize = gridSize;
        this.probCatch = probCatch;
        this.grid = new Cell[gridSize + 2][gridSize + 2]; // Adding boundary
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < gridSize + 2; i++) {
            for (int j = 0; j < gridSize + 2; j++) {
                if (i == 0 || i == gridSize + 1 || j == 0 || j == gridSize + 1) {
                    grid[i][j] = new Cell(CellState.EMPTY); // Boundary cells
                } else {
                    grid[i][j] = new Cell(CellState.TREE); // Internal cells
                }
            }
        }
        grid[gridSize / 2 + 1][gridSize / 2 + 1].setState(CellState.BURNING); // Middle cell burning
    }

    public void applySpread() {
        Cell[][] newGrid = new Cell[gridSize + 2][gridSize + 2];

        for (int i = 1; i <= gridSize; i++) {
            for (int j = 1; j <= gridSize; j++) {
                newGrid[i][j] = new Cell(grid[i][j].getState());

                if (grid[i][j].getState() == CellState.TREE && hasBurningNeighbor(i, j)) {
                    if (new Random().nextDouble() < probCatch) {
                        newGrid[i][j].setState(CellState.BURNING);
                    }
                } else if (grid[i][j].getState() == CellState.BURNING) {
                    newGrid[i][j].setState(CellState.EMPTY);
                }
            }
        }
        grid = newGrid;
    }

    private boolean hasBurningNeighbor(int i, int j) {
        return grid[i - 1][j].getState() == CellState.BURNING || grid[i + 1][j].getState() == CellState.BURNING
                || grid[i][j - 1].getState() == CellState.BURNING || grid[i][j + 1].getState() == CellState.BURNING
                || grid[i - 1][j - 1].getState() == CellState.BURNING || grid[i - 1][j + 1].getState() == CellState.BURNING
                || grid[i + 1][j - 1].getState() == CellState.BURNING || grid[i + 1][j + 1].getState() == CellState.BURNING;
    }

    public boolean hasBurningTree() {
        for (int i = 1; i <= gridSize; i++) {
            for (int j = 1; j <= gridSize; j++) {
                if (grid[i][j].getState() == CellState.BURNING) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cellSize = Math.min(getWidth(), getHeight()) / gridSize;
        for (int i = 1; i <= gridSize; i++) {
            for (int j = 1; j <= gridSize; j++) {
                g.setColor(grid[i][j].getColor());
                g.fillRect((j - 1) * cellSize, (i - 1) * cellSize, cellSize, cellSize);
            }
        }
    }
}
