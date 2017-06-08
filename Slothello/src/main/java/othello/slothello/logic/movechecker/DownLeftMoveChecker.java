package othello.slothello.logic.movechecker;

import othello.slothello.logic.Grid;

/**
 * Luokka, joka tarkistaa viistoon alas vasemmalle valitusta ruudusta onko
 * siirto laillinen ja kääntää vaihtaa tarvittavien ruutujen värejä.
 */
public class DownLeftMoveChecker implements DirectionOfMoveChecker {

    private Grid grid;

    DownLeftMoveChecker(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean isCellNextToSameEmptyOrOutOfBounds(int x, int y, boolean a) {
        if (x == 0 || y == grid.getGridSizeMinusOne()) {
            return true;
        }
        x--;
        y++;
        return grid.isCellInCoordinateEmptyOrSameColour(x, y, a);
    }

    @Override
    public int[] goDirectionUntilFoundSameColourOrEmpty(int x, int y, boolean a) {
        if (isCellNextToSameEmptyOrOutOfBounds(x, y, a)) {
            return null;
        }
        x = x - 2;
        y = y + 2;
        while (x >= 0 || y <= grid.getGridSizeMinusOne()) {
            if (grid.isCellInCoordinateSameColour(x, y, a)) {
                return new int[]{x, y};
            } else {
                y++;
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
        int[] i = goDirectionUntilFoundSameColourOrEmpty(x, y, a);
        int x2 = i[0];
        int y2 = i[1];
        grid.setCellInCoordinate(x, y, a);
        while (x > x2 || y < y2) {
            x--;
            y++;
            grid.setCellInCoordinate(x, y, a);
        }
        return true;
    }

}
