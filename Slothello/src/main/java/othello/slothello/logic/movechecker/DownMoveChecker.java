package othello.slothello.logic.movechecker;

import othello.slothello.logic.Grid;

/**
 * Luokka, joka tarkistaa alas valitusta ruudusta onko siirto laillinen ja
 * kääntää vaihtaa tarvittavien ruutujen värejä.
 */
public class DownMoveChecker implements DirectionOfMoveChecker {

    private Grid grid;

    public DownMoveChecker(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean isCellNextToSameEmptyOrOutOfBounds(int x, int y, boolean a) {
        if (y == grid.getGridSizeMinusOne()) {
            return true;
        }
        y++;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    @Override
    public int[] goDirectionUntilFoundSameColourOrEmpty(int x, int y, boolean a) {
        if (isCellNextToSameEmptyOrOutOfBounds(x, y, a)) {
            return null;
        }
        y = y + 2;
        while (y <= grid.getGridSizeMinusOne()) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return new int[]{x, y};
            } else {
                y++;
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
        while (y < y2) {
            y++;
            grid.setCellInCoordinate(x, y, a);
        }
        return true;
    }

}
