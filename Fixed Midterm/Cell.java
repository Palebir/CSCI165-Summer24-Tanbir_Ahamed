import java.awt.Color;

public class Cell {
    private CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public Color getColor() {
        switch (state) {
            case EMPTY:
                return Color.YELLOW;
            case TREE:
                return Color.GREEN;
            case BURNING:
                return Color.RED;
            default:
                return Color.BLACK;
        }
    }
}
