package othello.slothello.logic.movechecker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.slothello.logic.Grid;

public class DownLeftMoveCheckerTest {

    public DownLeftMoveCheckerTest() {
    }

    Grid grid;
    DownLeftMoveChecker checker;

    @Before
    public void setUp() {
        grid = new Grid(6);
        checker = new DownLeftMoveChecker(grid);
    }

    @Test
    public void colouredCellsToDownLeftCorrectlyRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 1, false), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 1, true), false);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(3, 1, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(3, 1, false), false);
    }

    @Test
    public void emptyCellToDownLeftRecognized() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 3, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(4, 3, false), true);
    }

    @Test
    public void cellToDownLeftOnBorder() {
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(2, 5, true), true);
        assertEquals(checker.isCellNextToSameEmptyOrOutOfBounds(0, 2, false), true);
    }

    @Test
    public void goToDownLeftUntilSameOrEmptyFoundReturnsCorrectColouredTileCoordinate() {
        grid.setCellInCoordinate(1, 3, false);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(3, 1, false);
        assertEquals(i[0], 1);
        assertEquals(i[1], 3);
        grid.setCellInCoordinate(2, 3, true);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(4, 1, true);
        assertEquals(i[0], 2);
        assertEquals(i[1], 3);
    }

    @Test
    public void goToDownLeftUntilSameOrEmptyFoundReturnsNullCorrectly() {
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 1, false), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(3, 1, true), null);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(5, 4, false), null);
    }

    @Test
    public void goToDownLeftUntilSameFoundWorksOverMultipleTiles() {
        grid.setCellInCoordinate(1, 4, true);
        int[] i = checker.goDirectionUntilFoundSameColourOrEmpty(4, 1, true);
        assertEquals(i[0], 1);
        assertEquals(i[1], 4);
        grid.setCellInCoordinate(3, 1, true);
        grid.setCellInCoordinate(1, 3, false);
        i = checker.goDirectionUntilFoundSameColourOrEmpty(4, 0, false);
        assertEquals(i[0], 1);
        assertEquals(i[1], 3);
    }

    @Test
    public void goToDownLeftUntilBorderFound() {
        grid.setCellInCoordinate(1, 4, false);
        grid.setCellInCoordinate(0, 5, false);
        Assert.assertArrayEquals(checker.goDirectionUntilFoundSameColourOrEmpty(4, 1, true), null);
    }

    @Test
    public void cellsChangeColourCorrectly() {
        grid.setCellInCoordinate(1, 3, false);
        checker.turnTilesToDirectionForLegalMove(3, 1, false);
        assertEquals(grid.getCellInCoordinate(2, 2).getColour(), false);
        grid.setCellInCoordinate(1, 4, true);
        checker.turnTilesToDirectionForLegalMove(4, 1, true);
        assertEquals(grid.getCellInCoordinate(3, 2).getColour(), true);
    }

}
