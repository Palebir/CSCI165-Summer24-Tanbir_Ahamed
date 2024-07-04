import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class WorldTest {
    private World world;
    private final int gridSize = 5; 

    @Before
    public void setUp() {
        world = new World(gridSize);
        world.initializeWorld(gridSize);
    }

    @Test
    public void testInitializeWorld() {
        Map<CellState, Integer> stateCounts = world.countStateOccurrences();
        assertTrue("There should be at least one BURNING cell after initialization", stateCounts.get(CellState.BURNING) > 0);
        assertTrue("There should be TREE cells after initialization", stateCounts.get(CellState.TREE) > 0);
    }

    private void assertTrue(String string, boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }

    @Test
    public void testSimulateStep() {
        world.simulateStep(1.0); // Set probability to 1 to ensure fire spreads
        Map<CellState, Integer> stateCounts = world.countStateOccurrences();
        assertTrue("There should be more BURNING cells after simulation step", stateCounts.get(CellState.BURNING) > 1);
    }

    @Test
    public void testIsSimulationComplete() {
        assertTrue("Simulation should not be complete immediately after initialization", world.isSimulationComplete());
        // Simulate until the fire is out
        while (!world.isSimulationComplete()) {
            world.simulateStep(1.0);
        }
        assertTrue("Simulation should be complete when there are no more BURNING cells", world.isSimulationComplete());
    }
}