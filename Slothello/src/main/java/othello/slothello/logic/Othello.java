package othello.slothello.logic;

public class Othello {

    private Grid grid;
    private LegalMoveChecker checker;

    public Othello() {
        this.grid = new Grid(4);
        this.checker = new LegalMoveChecker(grid);
    }

    public void setSpecificGrid(Grid grid) {
        this.grid = grid;
    }

    public void setGameGrid(int size) {
        this.grid = new Grid(size);
    }

}
