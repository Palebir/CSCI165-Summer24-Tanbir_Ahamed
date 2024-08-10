import javax.swing.JFrame;

public class SpreadingFireSimulation extends JFrame {
    private World world;

    public SpreadingFireSimulation(int gridSize, double probCatch) {
        world = new World(gridSize, probCatch);
        add(world);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void startSimulation() {
        while (world.hasBurningTree()) {
            world.applySpread();
            world.repaint();
            try {
                Thread.sleep(500); // Pause for 500ms between steps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int gridSize = 25;
        double probCatch = 0.5;

        if (args.length == 2) {
            gridSize = Integer.parseInt(args[0]);
            probCatch = Double.parseDouble(args[1]);
        }

        SpreadingFireSimulation simulation = new SpreadingFireSimulation(gridSize, probCatch);
        simulation.startSimulation();
    }
}
