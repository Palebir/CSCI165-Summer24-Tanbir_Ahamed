import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CellTest {
    private Cell cell;

    @Before
    public void setUp() {
        cell = new Cell(CellState.TREE);
    }

    @Test
    public void testInitialState() {
        assertEquals("Cell should be initialized with TREE state", CellState.TREE, cell.getState());
    }

    @Test
    public void testSetState() {
        cell.setState(CellState.BURNING);
        assertEquals("Cell state should be set to BURNING", CellState.BURNING, cell.getState());
    }

    private void assertEquals(String string, CellState burning, CellState state) {
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }
}
