package othello.slothello.logic.movechecker;

import othello.slothello.logic.Grid;

/**
 * Rajapinta, joka määrittelee siirron tekemiseen liittyvien apuluokkien
 * tarvittavat metodit.
 */
public interface DirectionOfMoveChecker {

    void setGrid(Grid grid);

    boolean isCellNextToSameEmptyOrOutOfBounds(int x, int y, boolean a);

    int[] goDirectionUntilFoundSameColourOrEmpty(int x, int y, boolean a);

    boolean turnTilesToDirectionForLegalMove(int x, int y, boolean a);

}
