package othello.slothello.logic.movechecker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.slothello.logic.Grid;

public class MoveCheckerTest {

    public MoveCheckerTest() {
    }

    Grid grid;
    MoveChecker checker;

    @Before
    public void setUp() {
        grid = new Grid(6);
        checker = new MoveChecker(grid);
    }

    @Test
    public void someLegalMovesForBothPlayersRecognizedInStartingPosition() {
        assertEquals(checker.isMoveLegal(2, 1, false), true);
        assertEquals(checker.isMoveLegal(3, 1, true), true);
        assertEquals(checker.isMoveLegal(4, 3, false), true);
        assertEquals(checker.isMoveLegal(2, 4, true), true);
    }

    @Test
    public void legalFromMultipleDirectionsRecognized() {
        grid.setCellInCoordinate(1, 0, false);
        grid.setCellInCoordinate(1, 1, false);
        grid.setCellInCoordinate(2, 2, false);
        grid.setCellInCoordinate(0, 1, false);
        grid.setCellInCoordinate(2, 0, false);
        assertEquals(checker.isMoveLegal(0, 0, true), true);
    }

    @Test
    public void illegalMoveNotRecognized() {
        assertEquals(checker.isMoveLegal(2, 1, true), false);
        assertEquals(checker.isMoveLegal(4, 1, true), false);
    }

    @Test
    public void makeMoveTurnsAllTiles() {
        grid = new Grid(8);
        checker = new MoveChecker(grid);
        grid.setCellInCoordinate(1, 2, true);
        grid.setCellInCoordinate(2, 3, false);
        grid.setCellInCoordinate(3, 4, false);
        grid.setCellInCoordinate(7, 2, true);
        grid.setCellInCoordinate(6, 3, false);
        grid.setCellInCoordinate(5, 4, false);
        grid.setCellInCoordinate(4, 4, false);
        grid.setCellInCoordinate(4, 2, true);
        grid.setCellInCoordinate(5, 5, false);
        grid.setCellInCoordinate(6, 5, false);
        grid.setCellInCoordinate(7, 5, true);
        checker.makeMove(4, 5, true);
        assertEquals(grid.getCellInCoordinate(4, 4).getColour(), true);
        assertEquals(grid.getCellInCoordinate(6, 5).getColour(), true);
        assertEquals(grid.getCellInCoordinate(4, 3).getColour(), true);
        assertEquals(grid.getCellInCoordinate(2, 3).getColour(), true);
        assertEquals(grid.getCellInCoordinate(4, 5).getColour(), true);
    }
}
