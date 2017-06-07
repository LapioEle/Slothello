package othello.slothello.logic;

public class Othello {

    private Grid grid;
    private MoveChecker checker;

    public Othello() {
        this.grid = new Grid(4);
        this.checker = new MoveChecker(grid);
    }

    public void setSpecificGrid(Grid grid) {
        this.grid = grid;
    }

    public void setGameGrid(int size) {
        this.grid = new Grid(size);
    }
    
    public boolean turnTilesForLegalMove(int x, int y, boolean a) {
        checker.isMoveLegal(x, y, a);
        checker.makeMove(x, y, a);
        return true;
    }
    
    public void soutGrid() {
        grid.printGrid();
    }

}
