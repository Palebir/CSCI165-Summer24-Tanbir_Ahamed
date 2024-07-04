import java.util.Map;


public class FireSimulation {

    private World world; 
    private double probCatch; 
    private int gridSize; 
    private int cellSize; 

    public FireSimulation(int gridSize, double probCatch, int cellSize) {
        this.gridSize = gridSize;
        this.probCatch = probCatch;
        this.cellSize = cellSize;
        this.world = new World(gridSize); 
    }

    public void initialize() {

        world.initializeWorld(cellSize); 
    }

    public void simulate() {
        while (!world.isSimulationComplete()) {
            world.spreadFire(probCatch); 
            world.displayWorld(); 
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void saveState(String filename) {
        world.saveSimulationState(filename); 
    }

    public void loadState(String filename) {
        world.loadSimulationState(filename); 
    }

    public static void main(String[] args) {
        int gridSize = args.length > 0 ? Integer.parseInt(args[0]) : 50; 
        double probCatch = 0.55; 
        int cellSize = 10; 

        FireSimulation simulation = new FireSimulation(gridSize, probCatch, cellSize);
        simulation.initialize();
        simulation.simulate();
    }
}
