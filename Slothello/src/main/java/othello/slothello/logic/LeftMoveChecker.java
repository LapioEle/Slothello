package othello.slothello.logic;

public class LeftMoveChecker implements DirectionOfMoveChecker {
    
    private Grid grid;
    
    public LeftMoveChecker(Grid grid) {
        this.grid = grid;
    }
    
    @Override
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean isCellNextToSameEmptyOrOutOfBounds(int x, int y, boolean a) {
        if (x == 0) {
            return true;
        }
        x--;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    @Override
    public int[] goDirectionUntilFoundSameColourOrEmpty(int x, int y, boolean a) {
        if (isCellNextToSameEmptyOrOutOfBounds(x, y, a)) {
            return null;
        }
        x = x - 2;
        while (x >= 0) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return new int[] {x, y};
            } else {
                x--;
            }
        }
        return null;
    }

    @Override
    public boolean turnTilesToDirectionForLegalMove(int x, int y, boolean a) {
        if (goDirectionUntilFoundSameColourOrEmpty(x, y, a) == null) {
            return false;
        }
        int [] i = goDirectionUntilFoundSameColourOrEmpty(x, y, a);
        int x2 = i[0];
        grid.setCellInCoordinate(x, y, a);
        while (x > x2) {
            x--;
            grid.setCellInCoordinate(x, y, a);
        }
        return true;
    }

}
