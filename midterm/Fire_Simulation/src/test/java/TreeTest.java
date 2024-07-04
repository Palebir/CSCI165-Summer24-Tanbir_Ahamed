import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {
    private Tree tree;

    @Before
    public void setUp() {
        tree = new Tree("Pine", 0.5, false);
    }

    @Test
    public void testCalculateFireRisk() {
        double baseProbCatch = 0.3;
        double expectedRisk = baseProbCatch * (1.0 - tree.getMoistureLevel());
        assertEquals("Fire risk should be calculated based on moisture level", expectedRisk, tree.calculateFireRisk(baseProbCatch), 0.01);
    }

    private void assertEquals(String string, double expectedRisk, double calculateFireRisk, double d) {
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    public void testDeadTreeIncreasedRisk() {
        tree.setDead(true);
        double baseProbCatch = 0.3;
        double expectedRisk = baseProbCatch * 2 * (1.0 - tree.getMoistureLevel());
        assertEquals("Dead tree should have increased fire risk", expectedRisk, tree.calculateFireRisk(baseProbCatch), 0.01);
    }
}