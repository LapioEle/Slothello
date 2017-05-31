package othello.slothello.logic;

public class Othello {

    private Grid grid;

    public Othello() {

    }

    public void setGameGrid(int size) {
        this.grid = new Grid(size);
    }

    //to do
//    private boolean isMoveLegal(int x, int y, boolean a) {
//        Cell cell = grid.getCellInCoordinate(x, y);
//        if (cell.isEmpty()) {
//            //to do
//        } else {
//            return false;
//        }
//    }
    public boolean isCellToLeftSameColourOrEmpty(int x, int y, boolean a) {
        if (x == 0) {
            return false;
        }
        x--;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToLeftForLegalMove(int x, int y, boolean a) {
        if (isCellToLeftSameColourOrEmpty(x, y, a)) {
            return false;
        }
        x = x - 2;
        while (x >= 0) {
            if (grid.isCellInCoordinateEmptyOrSameColour(x, y, a)) {
                return true;
            } else {
                x--;
            }
        }
        return false;
    }

    public boolean isCellToRightSameColourOrEmpty(int x, int y, boolean a) {
        if (x == grid.getGridSizeMinusOne()) {
            return false;
        }
        x++;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    public boolean findFirstSameColourToRightForLegalMove(int x, int y, boolean a) {
        if (isCellToRightSameColourOrEmpty(x, y, a)) {
            return false;
        }
        x = x + 2;
        while (x <= grid.getGridSizeMinusOne()) {
            if (grid.isCellInCoordinateEmptyOrSameColour(x, y, a)) {
                return true;
            } else {
                x++;
            }
        }
        return false;
    }
    
    public boolean isCellToUpSameColourOrEmpty(int x, int y, boolean a) {
        if (y == 0) {
            return false;
        }
        y--;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }
    
    public boolean findFirstSameColourToUpForLegalMove(int x, int y, boolean a) {
        if (isCellToLeftSameColourOrEmpty(x, y, a)) {
            return false;
        }
        y = y - 2;
        while (y >= 0) {
            if (grid.isCellInCoordinateEmptyOrSameColour(x, y, a)) {
                return true;
            } else {
                y--;
            }
        }
        return false;
    }
    
    public boolean isCellToDownSameColourOrEmpty(int x, int y, boolean a) {
        if (y == grid.getGridSizeMinusOne()) {
            return false;
        }
        y++;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }
    
    public boolean findFirstSameColourToDownForLegalMove(int x, int y, boolean a) {
        if (isCellToRightSameColourOrEmpty(x, y, a)) {
            return false;
        }
        y = y + 2;
        while (y <= grid.getGridSizeMinusOne()) {
            if (grid.isCellInCoordinateEmptyOrSameColour(x, y, a)) {
                return true;
            } else {
                y++;
            }
        }
        return false;
    }
    
}
