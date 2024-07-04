import java.awt.Container;
import java.awt.Window;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;


// encapsulate the world we are modeling
public class World {
    private Cell[][] matrix; 

    public World(int size) {
        matrix = new Cell[size][size];
        initializeMatrix();
    }

    private void initializeMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = new Cell(CellState.EMPTY); 
            }
        }
    }

    // iterate through the matrix and spread fire
    public void spreadFire(double probCatch) {
        // Create a new grid to store the next state
        Cell[][] nextGrid = new Cell[matrix.length][matrix[0].length];

        // Initialize the next grid with the conditions
        for (int i = 0; i < nextGrid.length; i++) {
            for (int j = 0; j < nextGrid[i].length; j++) {
                if (isBoundary(i, j)) {
                    nextGrid[i][j] = new Cell(CellState.EMPTY);
                } else {
                    nextGrid[i][j] = new Cell(matrix[i][j].getState());
                }
            }
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[i].length - 1; j++) {
                Cell currentCell = matrix[i][j];
                if (currentCell.getState() == CellState.TREE) {
                    if (isNeighborBurning(i, j)) {
                        if (Math.random() < probCatch) {
                            nextGrid[i][j].setState(CellState.BURNING);
                        }
                    }
                } else if (currentCell.getState() == CellState.BURNING) {
                    nextGrid[i][j].setState(CellState.EMPTY);
                }
            }
        }

        matrix = nextGrid;
    }

    private boolean isBoundary(int i, int j) {
        return i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[0].length - 1;
    }

    private boolean isNeighborBurning(int i, int j) {
        // Check neighboring cells for a burning state
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;
                if (matrix[i + x][j + y].getState() == CellState.BURNING) {
                    return true;
                }
            }
        }
        return false;
    }

    // set up the initial state of the world 
    public void initializeWorld(int n) {
        matrix = new Cell[n + 2][n + 2];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[i].length - 1) {
                    matrix[i][j] = new Cell(CellState.EMPTY);
                } else {
                    matrix[i][j] = new Cell(CellState.TREE);
                }
            }
        }

        int center = n / 2 + 1; 
        matrix[center][center] = new Cell(CellState.BURNING);
    }

    public void simulateStep(double probCatch) {
        Cell[][] nextGrid = new Cell[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                nextGrid[i][j] = new Cell(matrix[i][j].getState());
            }
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[i].length - 1; j++) {
        
                CellState current = matrix[i][j].getState();
                CellState north = matrix[i - 1][j].getState();
                CellState east = matrix[i][j + 1].getState();
                CellState south = matrix[i + 1][j].getState();
                CellState west = matrix[i][j - 1].getState();
                CellState northeast = matrix[i - 1][j + 1].getState();
                CellState northwest = matrix[i - 1][j - 1].getState();
                CellState southeast = matrix[i + 1][j + 1].getState();
                CellState southwest = matrix[i + 1][j - 1].getState();

                if (current == CellState.TREE && (north == CellState.BURNING || east == CellState.BURNING ||
                    south == CellState.BURNING || west == CellState.BURNING || northeast == CellState.BURNING ||
                    northwest == CellState.BURNING || southeast == CellState.BURNING || southwest == CellState.BURNING)) {
                    
                    if (Math.random() < probCatch) {
                        nextGrid[i][j].setState(CellState.BURNING);
                    }
                } else if (current == CellState.BURNING) {
                    nextGrid[i][j].setState(CellState.EMPTY);
                }
            }
        }

        matrix = nextGrid;
    }

    // count the number of cells in each state  and returns the count
    public Map<CellState, Integer> countStateOccurrences() {
        Map<CellState, Integer> stateCounts = new HashMap<>();
        stateCounts.put(CellState.EMPTY, 0);
        stateCounts.put(CellState.TREE, 0);
        stateCounts.put(CellState.BURNING, 0);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                CellState currentState = matrix[i][j].getState();
                stateCounts.put(currentState, stateCounts.get(currentState) + 1);
            }
        }

        return stateCounts;
    }


    // check if simulation is done running
    public boolean isSimulationComplete() {
        // check for any BURNING cells
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].getState() == CellState.BURNING) {
                    return false;
                }
            }
        }
        return true;
    }


    // display current state
    public void displayWorld() {
        WorldPanel worldPanel = new WorldPanel(matrix, 10); 
        JFrame frame = new JFrame();
        frame.add(worldPanel);
         frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //save the current state of the simulation to a file
    public void saveSimulationState(String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            // Serialize the current state of the matrix to the file
            out.writeObject(matrix);
            System.out.println("Simulation state saved to " + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    //load a saved state of the simulation from a file
    public void loadSimulationState(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {
            matrix = (Cell[][]) in.readObject();
            System.out.println("Simulation state loaded from " + filename);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }
}