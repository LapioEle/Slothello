package othello.slothello.logic;

public class Othello {

    private Grid grid;

    public Othello() {

    }

    private void setGameGrid(int size) {
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
    //to do
//    private boolean isMoveLegalFromLeft(int x, int y, boolean a) {
//        if (isCellToLeftSameColourOrEmpty(x, y, a)) {
//            return false;
//        }
//        x = x - 2;
//        
//    }
    private boolean isCellToLeftSameColourOrEmpty(int x, int y, boolean a) {
        if (x == 0) {
            return false;
        }
        x--;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

}
