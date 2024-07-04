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

    // sets the cell's state 
    public boolean ignite(double probCatch) {
    	if (this.state == CellState.TREE && Math.random() < probCatch) {
        	this.state = CellState.BURNING;
        	return true;
    	}
    	return false;
    }

    
   // After a cell has been burning for a certain time change state to empty
    
    public void extinguish() {
        if (this.state == CellState.BURNING) {
            this.state = CellState.EMPTY;
        }
    }

    // check if the cell is currently burning.
    public boolean isBurning() {
        return this.state == CellState.BURNING;
    }

    // check if the cell has potential t burn.
    public boolean canBurn() {
        return this.state == CellState.TREE;
    }

    // updates the cell's state based on its current state and the states of its neighbors. 
    public void updateState(CellState north, CellState east, CellState south, CellState west, 
                            CellState northeast, CellState northwest, CellState southeast, CellState southwest) {
        // If current cell is empty, it remains empty.
        if (this.state == CellState.EMPTY) {
            return; 
        }

        // If the current cell is empty, it transitions to empty.
        if (this.state == CellState.BURNING) {
            this.state = CellState.EMPTY;
            return; 
        }

        // If the current cell is a tree, generate a random number to determine if the tree catches fire.
        if (this.state == CellState.TREE) {
            if (north == CellState.BURNING || east == CellState.BURNING || south == CellState.BURNING || 
                west == CellState.BURNING || northeast == CellState.BURNING || northwest == CellState.BURNING || 
                southeast == CellState.BURNING || southwest == CellState.BURNING) {
                
                double probCatch = 0.55;
                if (Math.random() < probCatch) {
                    this.state = CellState.BURNING; 
                }
            }
        }
    }

    // Override the toString method to provide a string representation of the cell's state, 
    @Override
    public String toString() {
        switch (this.state) {
            case EMPTY:
                return "0"; 
            case TREE:
                return "1"; 
            case BURNING:
                return "2"; 
            default:
                return " "; 
        }
    }
}