package othello.slothello.logic.movechecker;

import othello.slothello.logic.Cell;
import othello.slothello.logic.Grid;

/**
 * Luokka, joka tarkista onko siirto laillinen valitussa ruudussa ja vaihtaa
 * ruutujen värejä sääntöjen mukaan, kun laillinen siirto tehdään.
 */
public class MoveChecker {

    private Grid grid;

    public MoveChecker(Grid grid) {
        this.grid = grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public boolean isMoveLegal(int x, int y, boolean a) {
        Cell cell = grid.getCellInCoordinate(x, y);

        if (cell.isEmpty()) {
            if (new LeftMoveChecker(grid).goDirectionUntilFoundSameColourOrEmpty(x, y, a) != null) {
                return true;
            }
            if (new UpLeftMoveChecker(grid).goDirectionUntilFoundSameColourOrEmpty(x, y, a) != null) {
                return true;
            }
            if (new UpMoveChecker(grid).goDirectionUntilFoundSameColourOrEmpty(x, y, a) != null) {
                return true;
            }
            if (new UpRightMoveChecker(grid).goDirectionUntilFoundSameColourOrEmpty(x, y, a) != null) {
                return true;
            }
            if (new RightMoveChecker(grid).goDirectionUntilFoundSameColourOrEmpty(x, y, a) != null) {
                return true;
            }
            if (new DownRightMoveChecker(grid).goDirectionUntilFoundSameColourOrEmpty(x, y, a) != null) {
                return true;
            }
            if (new DownMoveChecker(grid).goDirectionUntilFoundSameColourOrEmpty(x, y, a) != null) {
                return true;
            }
            if (new DownLeftMoveChecker(grid).goDirectionUntilFoundSameColourOrEmpty(x, y, a) != null) {
                return true;
            }
        }
        return false;
    }

    public void makeMove(int x, int y, boolean a) {
        new LeftMoveChecker(grid).turnTilesToDirectionForLegalMove(x, y, a);
        new UpLeftMoveChecker(grid).turnTilesToDirectionForLegalMove(x, y, a);
        new UpMoveChecker(grid).turnTilesToDirectionForLegalMove(x, y, a);
        new UpRightMoveChecker(grid).turnTilesToDirectionForLegalMove(x, y, a);
        new RightMoveChecker(grid).turnTilesToDirectionForLegalMove(x, y, a);
        new DownRightMoveChecker(grid).turnTilesToDirectionForLegalMove(x, y, a);
        new DownMoveChecker(grid).turnTilesToDirectionForLegalMove(x, y, a);
        new DownLeftMoveChecker(grid).turnTilesToDirectionForLegalMove(x, y, a);
    }
}
