package othello.slothello.logic.movechecker;

import othello.slothello.logic.Grid;

public class UpMoveChecker implements DirectionOfMoveChecker {

    private Grid grid;

    public UpMoveChecker(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean isCellNextToSameEmptyOrOutOfBounds(int x, int y, boolean a) {
        if (y == 0) {
            return true;
        }
        y--;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    @Override
    public int[] goDirectionUntilFoundSameColourOrEmpty(int x, int y, boolean a) {
        if (isCellNextToSameEmptyOrOutOfBounds(x, y, a)) {
            return null;
        }
        y = y - 2;
        while (y >= 0) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return new int[]{x, y};
            } else {
                y--;
            }
        }
        return null;
    }

    @Override
    public boolean turnTilesToDirectionForLegalMove(int x, int y, boolean a) {
        if (goDirectionUntilFoundSameColourOrEmpty(x, y, a) == null) {
            return false;
        }
        int[] i = goDirectionUntilFoundSameColourOrEmpty(x, y, a);
        int y2 = i[1];
        grid.setCellInCoordinate(x, y, a);
        while (y > y2) {
            y--;
            grid.setCellInCoordinate(x, y, a);
        }
        return true;
    }

}
