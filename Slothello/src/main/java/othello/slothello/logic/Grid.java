package othello.slothello.logic;

public class Grid {
    
    private Cell[][] cells;
    private int side;
    
    public Grid(int side) {
        /*Defining different size grids mostly for testing purposes, game will be
        in 8x8 grid. For testing purposes grid still has to be square with even
        sides and it has to be at least 4x4*/
        
        if (side < 4) {
            side = 4;
        }
        if (side%2 != 0) {
            side++;
        }
        this.side = side;
        cells = new Cell[side][side];
    }
    
    public Integer getBottomRightCenterCell() {
        return side/2;
    }
    
    public void setUpGrid() {
        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells.length; y++) {
                cells[x][y] = new Cell();
            }
        }
        setUpCenter();
    }
    
    public void setUpCenter() {
        int x = getBottomRightCenterCell();
        int y = x;
        cells[x][y].setWhite();
        cells[x-1][y-1].setWhite();
        cells[x-1][y].setBlack();
        cells[x][y-1].setBlack();
    }
    
}
